package exercise1

fun main() {
    val inputs = generateSequence(::readLine).toList()[1].split(" ").map { it.toInt() }
    var c = inputs[0].toChar()
    if (c !in 'A'..'Z') {
        println()
    } else {
        for (x in inputs.drop(1)) {
            c = ('A' + (c - 'A' + x) % 26)
        }
        println(c)
    }
}