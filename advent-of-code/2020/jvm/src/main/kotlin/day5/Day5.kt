package day5

fun main() {
    val inputs = generateSequence(::readLine).map { it.toId() }
    println(inputs.max())
}

fun mainPart2() {
    val inputs = generateSequence(::readLine).map { it.toId() }
    val freeRows = inputs.filter { it in 8 until 127 * 8 }.groupBy { it / 8 }.filter { it.value.size == 7 }
    println(freeRows.entries.map { (it.key * 8 until (it.key+1) * 8) - it.value }.first().first())
}

fun String.toId(): Int {
    val row = this.take(7).replace('F', '0').replace('B', '1').toInt(2)
    val column = this.takeLast(3).replace('R', '1').replace('L', '0').toInt(2)
    return row * 8 + column
}
