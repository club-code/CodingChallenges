package day15

fun main() {
    val inputs = readLine()!!.split(",").map { it.toInt() }
    println(inputs.execute(2020))
}

fun mainPart2() {
    val inputs = readLine()!!.split(",").map { it.toInt() }
    println(inputs.execute(30000000))
}

fun List<Int>.execute(max: Int): Int {
    val map = mutableMapOf<Int, Pair<Int, Int>>()

    for (i in this.indices) {
        val m = map[this[i]]
        if (m == null)
            map[this[i]] = -1 to i
        else
            map[this[i]] = m.shl(i)
    }

    var previous = this.last()

    for (i in this.size until max) {
        val m = map[previous]!!
        val next =
            if (m.first == -1) 0
            else m.second-m.first
        val pairNext = map[next]
        map[next] = pairNext?.shl(i) ?: -1 to i
        previous = next
    }

    return previous
}

fun <T> Pair<T, T>.shl(new: T): Pair<T, T> = this.second to new
