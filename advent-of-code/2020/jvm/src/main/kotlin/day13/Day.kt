package day13

import org.clubcode.library.number.euclid

fun main() {
    val inputs = generateSequence(::readLine).toList()
    val timestamp = inputs[0].toInt()
    val buses = inputs[1].split(",").filter { it != "x" }.map { it.toInt() }
    val next = buses.map { it to nextDeparture(timestamp, it) }.minByOrNull { it.second }!!
    println((next.second - timestamp) * next.first)
}

fun mainPart2() {
    val inputs = generateSequence(::readLine).toList()
    val buses = inputs[1].split(",").mapIndexed { index, s -> index to s }
        .filter { it.second != "x" }.map { it.first to it.second.toLong() }

    val n = buses.map { it.second }.also { System.err.println(it) }
    val a = buses.map { -it.first.toLong() }.also { System.err.println(it) }

    println(chineseRemainder(a, n))
}

fun nextDeparture(timestamp: Int, id: Int): Int {
    val rest = timestamp % id
    return if (rest == 0)
        timestamp
    else
        timestamp + id - rest
}

fun chineseRemainder(a: List<Long>, n: List<Long>): Long {
    val prod = n.reduce { acc, l -> acc * l }
    var sum = 0L

    for (i in n.indices) {
        val p = prod / n[i]
        sum += a[i] * moduloInv(p, n[i]) * p
    }
    val s = sum % prod
    return if(s < 0L) s + prod else s
}

fun moduloInv(a: Long, b: Long): Long {
    return ((euclid(a, b).u + b) % b)
}