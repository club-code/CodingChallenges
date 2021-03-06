package e

import kotlin.math.min
import kotlin.math.max

fun main() {
    val inputs = generateSequence(::readLine).map {
        val i = it.split(" ").drop(1).map { x -> x.toInt() }
        if (i.isNotEmpty())
            i.minOrNull()!! to i.maxOrNull()!!
        else
            Int.MAX_VALUE to Int.MIN_VALUE
    }.reduce { acc, pair ->
        (min(acc.first, pair.first)) to (max(acc.second, pair.second))
    }
    println("${inputs.first} ${inputs.second}")
}