package b

import kotlin.math.max

fun main(){
    val input = generateSequence(::readLine).drop(1).map {
        val el = it.split(" ")
        el[0].toInt()..el[1].toInt()
    }.toList()

    val edges = input.mapIndexed { i, _ -> input.edge(i) }

//    System.err.println(input.maxSquare(0, 2))
    var k = 1
    println(edges.mapIndexed { i, it ->
        if (i > 0 && it == edges[i-1]) {
            0
        } else {
            val m = it.map { j -> input.maxSquare(i, j, k) }.maxOrNull() ?: 0
            k = max(m, k)
            m
        }
    }.maxOrNull()!!)

}

fun List<IntRange>.edge(line: Int): List<Int> {
    return listOf(this[line].first(), this[line].last())
}

fun List<IntRange>.check(i: Int, j: Int) = i in this.indices && j in this[i]

fun List<IntRange>.checkSquare(l: List<Pair<Int, Int>>) = l.all { this.check(it.second, it.first) }

fun List<IntRange>.maxSquare(i: Int, j: Int, startK: Int = 1): Int {
    var max = 0

    for (dir in Dir.values()) {
        var k = startK
        while (this.checkSquare(dir.increase(j, i, k))) {
            k++
        }
        max = max(max, k)
    }

    return max
}

enum class Dir(val increase: (Int, Int, Int) -> List<Pair<Int, Int>>) {
    NE({ x, y, i -> listOf((x+i) to (y-i), x to (y-i), (x+i) to y)}),
    SE({ x, y, i -> listOf((x+i) to (y+i), x to (y+i), (x+i) to y)}),
    SW({ x, y, i -> listOf((x-i) to (y+i), x to (y+i), (x-i) to y)}),
    NW({ x, y, i -> listOf((x-i) to (y-i), x to (y-i), (x-i) to y)})
}
