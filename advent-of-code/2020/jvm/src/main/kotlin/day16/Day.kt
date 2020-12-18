package day16

import org.clubcode.library.collection.split

fun main() {
    val inputs = generateSequence(::readLine).split { it.isEmpty() }

    val list = inputs[0].map {
        val results = Regex(".+ (\\d+)-(\\d+) or (\\d+)-(\\d+)").matchEntire(it)!!
        (results.groupValues[1].toInt()..results.groupValues[2].toInt()) to
                (results.groupValues[3].toInt()..results.groupValues[4].toInt())
    }

    println(inputs[2].asSequence().drop(1).map { it.split(",").map { n -> n.toInt() } }
        .map { list.checkTicket(it) }
        .flatten()
        .reduce { acc, i -> acc + i })
}

fun mainPart2() {
    val inputs = generateSequence(::readLine).split { it.isEmpty() }

    val list = inputs[0].map {
        val results = Regex(".+ (\\d+)-(\\d+) or (\\d+)-(\\d+)").matchEntire(it)!!
        (results.groupValues[1].toInt()..results.groupValues[2].toInt()) to
                (results.groupValues[3].toInt()..results.groupValues[4].toInt())
    }

    val ticket = inputs[1][1].split(",").map { n -> n.toInt() }

    val valid = inputs[2].asSequence().drop(1).map { it.split(",").map { n -> n.toInt() } }
        .filter { list.checkTicket(it).isEmpty() }.toList()
    val constraints = valid.findFieldsOrder(list)
    val result = constraints.findConstraint()

    println(result.mapIndexed { index, i -> if (i in 0..5) ticket[index] else 1 }
        .fold(1L) { acc, i -> acc * i })
}

tailrec fun List<List<Int>>.findConstraint(): List<Int> {
    if (this.all { it.size == 1 })
        return this.flatten()
    val matches = this.filter { it.size == 1 }.flatten()
    return this.map { if (it.size > 1) it - matches else it }.findConstraint()
}

fun List<List<Int>>.findFieldsOrder(l: List<Pair<IntRange, IntRange>>): List<List<Int>> {
    val result = mutableListOf<MutableList<Int>>()

    for (i in l.indices) {
        result.add(mutableListOf())
        for (j in l.indices) {
            if (this.all { l[j].checkField(it[i]) }) {
                result.last().add(j)
            }
        }
    }

    return result
}

fun Pair<IntRange, IntRange>.checkField(value: Int): Boolean {
    return value in this.first || value in this.second
}

fun List<Pair<IntRange, IntRange>>.checkTicket(l: List<Int>): List<Int> {
    val result = mutableListOf<Int>()

    for (value in l) {
        if (this.all { value !in it.first && value !in it.second })
            result.add(value)
    }

    return result
}
