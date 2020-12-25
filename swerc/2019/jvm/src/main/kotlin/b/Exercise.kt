package b

fun main() {
    val inputs = generateSequence(::readLine).drop(1).toList()
    val v = inputs.groupingBy { it }.eachCount()
    val max = v.maxByOrNull { it.value }!!
    println(if (2*max.value > inputs.size) max.key else "NONE")
}
