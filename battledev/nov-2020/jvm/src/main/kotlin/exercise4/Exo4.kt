package exercise4

fun main() {
    val input = generateSequence(::readLine)
    val lines = input.toList()
    val dico = mutableMapOf<Int, Int>()

    val keys = lines[1].split(" ").map{it.toInt()}
    val compute = IntArray(keys.size)

    compute[0] = keys[0]
    for(i in 1 until compute.size) {
        compute[i] = compute[i-1] xor keys[i]
    }

    val intervals = lines.drop(2).map{it.split(" ")}.map{ Interval(it[0].toInt(), it[1].toInt()) }

    for(interval in intervals) {
        val k = interval.compute(compute)
        val v = dico.getOrElse(k){0}
        dico[k] = v+1
    }

    println((0 until 256).map{dico.getOrElse(it){0}}.joinToString(" "))
}

data class Interval(val start: Int, val end: Int) {
    fun compute(compute: IntArray) = compute[end] xor (if(start > 0) compute[start-1] else 0)
}