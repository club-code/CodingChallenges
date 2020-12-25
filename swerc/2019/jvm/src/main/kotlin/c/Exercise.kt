package c

fun main() {
    val inputs = generateSequence(::readLine).drop(1).filter { it.length <= 7 }.map { it.toLong() }.toSet()

    var i = 0L
    while (i in inputs) {
        i++
    }
    println(i)
}
