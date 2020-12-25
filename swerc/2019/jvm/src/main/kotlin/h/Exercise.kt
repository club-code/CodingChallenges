package h

fun main() {
    val n = readLine()!!.toLong()

    val values = Cycle::class.java.getResource("/h/precompute.txt").readText()
        .split("\n").map {
            val l = it.split(" ")
            l[0].toLong() to l[1].toLong()
        }
    val i = if (n < mu) {
        n
    } else {
        ((n - mu) % lambda) + mu
    }
    val cycleCount = if (n < mu) {
        0L
    } else {
        ((n - mu) / lambda)*evenValuesInCycle
    }

    val v = values[(i / size).toInt()]
    println(v.second + evenNumber(v.first, i%size) + cycleCount)
}


