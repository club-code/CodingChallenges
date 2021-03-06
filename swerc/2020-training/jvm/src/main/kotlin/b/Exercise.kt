package b

import org.clubcode.library.vector.IntVector2

fun main() {
    val hidings = generateSequence(::readLine).drop(1).map {
        val v = it.split(" ")
        IntVector2(v[0].toInt(), v[1].toInt())
    }.toList()

    val costs = hidings.mapIndexed { i, v -> hidings.mapIndexed { j, w ->
        if (i != j)
            w.getManhattanDistance(v)
        else
            0
    }.average() }

    val min = costs.zip(hidings).reduce { acc, p ->
        when {
            p.first < acc.first -> p
            p.first == acc.first -> {
                p.first to p.second.minBetween(acc.second)
            }
            else -> acc
        }
    }

    println("${min.second.x} ${min.second.y}")
}

fun IntVector2.minBetween(o: IntVector2): IntVector2 {
    return if (this.x < o.x || (this.x == o.x && this.y < o.y)) this else o
}
