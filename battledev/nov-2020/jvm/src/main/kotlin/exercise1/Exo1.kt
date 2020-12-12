package exercise1

fun main() {
    val input = generateSequence(::readLine)
    val lines = input.toList()
    println(lines.drop(1).filter{it.takeLast(5).all{c -> c in '0'..'9'}}.size)
}