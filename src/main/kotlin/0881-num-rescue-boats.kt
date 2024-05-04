fun numRescueBoats(people: IntArray, limit: Int): Int {
    people.sort()
    var i = 0
    var j = people.lastIndex
    var boats = 0

    while (i <= j) {
        if (people[i] + people[j] <= limit) {
            i++
        }
        j--
        boats++
    }
    return boats
}
