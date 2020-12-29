package exercise4

import org.clubcode.library.graph.*
import kotlin.math.min
import kotlin.math.max

fun main() {
    val n = readLine()!!.toInt()
    val m = readLine()!!.toInt()
    val aqueducs = (0 until m).map {
        val line = readLine()!!.split(" ")
        System.err.println("line $line")
        ValueEdge(listOf(line[0].toInt()), listOf(line[1].toInt()), 1)
    }
    val start = readLine()!!.toInt()
    val end = readLine()!!.toInt()

    val graph = UndirectedWeightedGraph<List<Int>, Int>()
    graph.addEdges(aqueducs)

    val g = UndirectedUnweightedGraph<Int>()
    g.addEdges(aqueducs.map { Edge(it.from.first(), it.to.first()) })

    val r = try {
        graph.minimumCost(listOf(start))
    } catch (e: NoSuchElementException) {
        listOf()
    }
    val min = r.filter { end in it.first }.minByOrNull { it.third }

    if (min == null) {
        println(0)
    } else {
        val edges = min.first.map { g.getEdgesAdjacents(it).filter { e -> e.to in min.second } }.flatten()
        println(edges.size)
        for (edge in edges) {
            println("${min(edge.from, edge.to)} ${max(edge.from, edge.to)}")
        }
    }
    System.err.println(min)
}


/**
 * Stoer-Wagner algorithm : find a global minimum cut of an undirected and weighted graph
 * @see <a href="https://basics.sjtu.edu.cn/~dominik/teaching/2016-cs214/presentation-slides/2016-12-06-StoerWagner-BigNews.pdf"></a>
 */

fun <T> UndirectedWeightedGraph<List<T>, Int>.minimumCost(a: List<T>): List<Triple<List<T>, Set<T>, Int>> {
    val minimumCut = mutableListOf<Triple<List<T>, Set<T>, Int>>()
    while (this.getNodes().size > 1) {
        val n = this.minimumCostPhase(a)
        minimumCut.add(n)
    }
    return minimumCut
}

fun <T> UndirectedWeightedGraph<List<T>, Int>.minimumCostPhase(a: List<T>): Triple<List<T>, Set<T>, Int> {
    val A = mutableSetOf<List<T>>()
    val V = this.getNodes()
    var last = a
    var previousLast = a

    A.add(a)
    while (A.size != V.size && A != V) {
        val n = this.getMostTightlyConnected(A)
        A.add(n)
        previousLast = last
        last = n
    }

    val v = this.getEdgesAdjacents(last)

    val w = v.fold(0) {acc, valueEdge -> acc+valueEdge.weight }

    val r = (v + this.getEdgesAdjacents(previousLast)).filter { it.to !in listOf(last, previousLast) }
        .groupingBy { it.to }
        .aggregate { _, accumulator: Int?, element, _ ->
            val acc = accumulator ?: 0
            acc + element.weight
        }
    this.removeNode(last)
    this.removeNode(previousLast)
    val t = last+previousLast
    for (x in r) {
        this.addEdge(t, x.key, x.value)
    }

    return Triple(last, (A.flatten() - last).toSet(), w)
}

fun <T> UndirectedWeightedGraph<List<T>, Int>.getMostTightlyConnected(A: Set<List<T>>): List<T> {
    return A.map { this.getEdgesAdjacents(it).filterNot { e -> e.to in A } }.flatten().first().to
}
