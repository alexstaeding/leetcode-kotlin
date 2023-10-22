import java.util.Queue
import java.util.ArrayDeque

fun isMatch(s: String, p: String): Boolean {
    val stateStack = ArrayDeque<State>(p.length)
    stateStack.add(State())
    for (c in p) {
        when (c) {
            '*' -> stateStack.last().addSelfStar()
            '.' -> {
                val newState = State()
                stateStack.last().addAnyTransition(newState)
                stateStack.add(newState)
            }
            else -> {
                val newState = State()
                stateStack.last().addTransition { dC -> newState.takeIf { dC == c } }
                stateStack.add(newState)
            }
        }
    }
    return stateStack.first().consume(s.toCollection(ArrayDeque()))
}

class State {
    private val transitions = mutableListOf<(Char) -> State?>()

    fun addTransition(transition: (Char) -> State?) {
        transitions += transition
    }

    fun addSelfStar() {
        transitions += { this }
    }

    fun addAnyTransition(to: State) {
        transitions += { to }
    }

    fun consume(seq: Queue<Char>): Boolean {
        val next = seq.poll() ?: return true
        for (transition in transitions) {
            return (transition(next) ?: continue).consume(seq)
        }
        return false
    }
}
