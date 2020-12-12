package day11

import java.lang.IllegalArgumentException

fun main() {
    val input = CellularAutomaton(generateSequence(::readLine).map {
        it.map { c ->
            when (c) {
                '.' -> State.FLOOR
                '#' -> State.OCCUPIED
                'L' -> State.EMPTY
                else -> throw IllegalArgumentException("Impossible")
            }
        }
    }.toList())
    while (input.next() > 0);
    println(input.count())
}

fun mainPart2() {
    val input = CellularAutomaton(generateSequence(::readLine).map {
        it.map { c ->
            when (c) {
                '.' -> State.FLOOR
                '#' -> State.OCCUPIED
                'L' -> State.EMPTY
                else -> throw IllegalArgumentException("Impossible")
            }
        }
    }.toList())

    while (input.nextPart2() > 0);
    println(input.count())
}

class CellularAutomaton(var l: List<List<State>>) {

    val width: Int
        get() = l[0].size

    val height: Int
        get() = l.size

    fun next(): Int {
        var count = 0
        val next = List(l.size) { mutableListOf<State>() }
        for (i in l.indices) {
            for (j in l[i].indices) {
                val neighbors = neighbors(i, j)
                val newValue = when {
                    this[i, j] == State.EMPTY && !neighbors.any { it == State.OCCUPIED } -> State.OCCUPIED
                    this[i, j] == State.OCCUPIED && neighbors.count { it == State.OCCUPIED } >= 4 -> State.EMPTY
                    else -> this[i, j]
                }
                next[i].add(newValue)
                if (newValue != this[i, j]) count++
            }
        }
        l = next
        return count
    }

    fun nextPart2(): Int {
        var count = 0
        val next = List(l.size) { mutableListOf<State>() }
        for (i in l.indices) {
            for (j in l[i].indices) {
                val neighbors = projectedSeats(i, j)
                val newValue = when {
                    this[i, j] == State.EMPTY && !neighbors.any { it == State.OCCUPIED } -> State.OCCUPIED
                    this[i, j] == State.OCCUPIED && neighbors.count { it == State.OCCUPIED } >= 5 -> State.EMPTY
                    else -> this[i, j]
                }
                next[i].add(newValue)
                if (newValue != this[i, j]) count++
            }
        }
        l = next
        return count
    }

    operator fun get(i: Int, j: Int) = l[i][j]

    fun inBound(i: Int, j: Int) = i in l.indices && j in l[i].indices

    fun neighbors(i0: Int, j0: Int): List<State> {
        val result = mutableListOf<State>()
        for (i in (-1)..1) {
            for (j in (-1)..1) {
                if ((i != 0 || j != 0) && (i0 + i) in l.indices && (j0 + j) in l[i0 + i].indices) {
                    result.add(this[i0 + i, j0 + j])
                }
            }
        }
        return result
    }

    fun projectedSeats(i0: Int, j0: Int): List<State> {
        val result = mutableListOf<State>()
        val directions = listOf(
                { p: Pair<Int, Int>, i: Int -> p.first + i to p.second + i},
                { p: Pair<Int, Int>, i: Int -> p.first + i to p.second },
                { p: Pair<Int, Int>, i: Int -> p.first to p.second + i },
                { p: Pair<Int, Int>, i: Int -> p.first - i to p.second - i },
                { p: Pair<Int, Int>, i: Int -> p.first - i to p.second },
                { p: Pair<Int, Int>, i: Int -> p.first to p.second - i },
                { p: Pair<Int, Int>, i: Int -> p.first + i to p.second - i },
                { p: Pair<Int, Int>, i: Int -> p.first - i to p.second + i }
        )
        for (direction in directions) {
            for (i in 1 until kotlin.math.max(width, height)) {
                val point = direction(i0 to j0, i)
                if(!inBound(point.first, point.second))
                    break
                if (this[point.first, point.second] in listOf(State.OCCUPIED, State.EMPTY)) {
                    result.add(this[point.first, point.second])
                    break
                }
            }
        }
        return result
    }

    fun count(): Int {
        return l.fold(0) { acc, list -> acc + list.count { it == State.OCCUPIED } }
    }

    override fun toString(): String {
        return l.joinToString("\n", postfix = "\n") { it.joinToString("") }
    }
}

enum class State(val str: String) {
    FLOOR("."),
    EMPTY("L"),
    OCCUPIED("#");

    override fun toString(): String {
        return this.str
    }
}
