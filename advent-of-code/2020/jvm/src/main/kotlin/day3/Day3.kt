package day3

fun main() {
    val input = generateSequence(::readLine).toList()
    println(input.countTrees(3, 1))
}

fun mainPart2() {
    val input = generateSequence(::readLine).toList()
    val slope1 = input.countTrees(1, 1)
    val slope2 = input.countTrees(3, 1)
    val slope3 = input.countTrees(5, 1)
    val slope4 = input.countTrees(7, 1)
    val slope5 = input.countTrees(1, 2)
    System.err.println("$slope1 $slope2 $slope3 $slope4 $slope5")
    println(slope1 * slope2 * slope3 * slope4 * slope5)
}

fun List<String>.countTrees(right: Int, down: Int): Long {
    var x = 0
    var count = 0L
    for (i in down until this.size step down) {
        val str = this[i]
        x = (x + right) % str.length
        if (str[x] == '#') {
            count++
        }
    }
    /* ou
    this.filterIndexed {i, _ -> i % down == 0 && i != 0}
        .filterIndexed { i, s -> s[(i+1) * right % s.length] == '#' }
        .size
     */
    return count
}
