package a

import java.util.*
import kotlin.math.ceil
import kotlin.math.log2

var weights: IntArray = intArrayOf()

fun main() {
    val inputs = generateSequence(::readLine).toList()
    val K = inputs[1].toInt()
    weights = inputs[2].split(" ").map { it.toInt() }.sorted().toIntArray()
    println(result(K).joinToString("\n"))
}

fun result(K: Int): List<SearchNode> {
    val n = weights.indexOfFirst { it >= weights.take(ceil(log2(K.toDouble())).toInt()).sum() }.let { if(it == -1) weights.size else it }
    val result = mutableListOf<SearchNode>()
    val toLook = PriorityQueue<HeadSearch>()
    val s = SearchNode(0, listOf())
    result.add(s)
    for (i in weights.indices)
        toLook.add(HeadSearch(i, s.aggregate(weights[i])))

    while(result.size < K) {
        val x = toLook.poll()
        if (result.last().value != x.s.value)
            result.add(x.s)
        toLook.addAll(x.generateNext(n))
    }
    return result
}

class HeadSearch(val index: Int, val s: SearchNode): Comparable<HeadSearch> {
    override fun compareTo(other: HeadSearch): Int {
        return s.value - other.s.value
    }
    fun generateNext(n: Int) = (index+1 until n).map { HeadSearch(it, s.aggregate(weights[it])) }
}

data class SearchNode(val value: Int, val list: List<Int>) : Comparable<SearchNode> {
    fun aggregate(s: Int) = SearchNode(value + s, list + s)
    override fun toString(): String {
        return "${value}: ${list.joinToString(" ") { it.toString() }}"
    }

    override fun compareTo(other: SearchNode): Int {
        return value - other.value
    }
}


//
//fun result(weights: List<Int>, K: Int): List<SearchNode> {
//    val sortedWeights = weights.sorted()
//    return sortedWeights.flatMapIndexed { i, it ->
//        Node(it, sortedWeights.subList(i+1, sortedWeights.size)).first(K - 1, SearchNode(0, listOf()))
//    }.sortedBy { it.value }
//        .distinctBy { it.value }
//        .take(K-1)
//}
//
//data class Node(val v: Int, val next: List<Int>) {
//    fun first(K: Int, l: SearchNode): List<SearchNode> {
//        val my = l.aggregate(v)
//        val others = next.flatMapIndexed { i, it -> Node(it, next.subList(i + 1, next.size)).first(K - 1, my) }
//        return listOf(my) + others
//    }
//}
//
//data class SearchNode(val value: Int, val list: List<Int>) {
//    fun aggregate(s: Int) = SearchNode(value + s, list + s)
//    override fun toString(): String {
//        return "$value: ${list.joinToString(" ") { it.toString() }}"
//    }
//}
