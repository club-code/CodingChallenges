package h

import java.io.File

const val lambda = 182129209L
const val mu = 350125310L
const val size = 10000
const val evenValuesInCycle = 91029304L

fun mainCompute() {
    val file = File("precompute.txt")
    file.writeText("")

    var i = 0L
    var x = x0
    var count = 0
    file.appendText("$x $count\n")
    while (i < lambda+mu) {
        repeat(size) {
            if (x and 1L == 0L)
                count++
            x = f(x)
            i++
        }
        file.appendText("$x $count\n")
    }
}

/**
 * Find 91029304
 */
fun evenInCycle() {
    val values = Cycle::class.java.getResource("/h/precompute.txt").readText()
        .split("\n").map {
            val l = it.split(" ")
            l[0].toLong() to l[1].toLong()
        }
    val v = values[(mu/size).toInt()]
    var x = x0
    repeat((mu-v.first).toInt()) {
        x = f(x)
    }
    val count = evenNumber(x, lambda)
    println(count)
}

fun evenNumber(y: Long, count: Long): Long {
    var x = y
    var result = 0L
    for (i in 0L until count) {
        if (x and 1L == 0L)
            result++
        x = f(x)
    }
    return result
}
