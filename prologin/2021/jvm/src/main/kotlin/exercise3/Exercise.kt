package exercise3

import org.clubcode.library.graph.*

fun main() {
    val A = readLine()!!.toInt()
    val N = readLine()!!.toInt()
    val M = readLine()!!.toInt()
    val graph = DirectedWeightedGraph<Int, Int>()

    val inputs = generateSequence(::readLine).map {
        it.split(" ").map { s -> s.toInt() }
    }.toList()
    inputs.forEachIndexed { index, list ->
        for ((j, el) in list.withIndex()) {
            val id = index * M + j + 1

            val nextLine = inputs[index]
            repeat(3) {
                val k = j + it - 1
                if (k in nextLine.indices)
                    graph.addEdge(id, (index + 1) * M + k + 1, el)
            }
            if (index == 0) {
                graph.addEdge(0, id, 0)
            }
            if (index == inputs.lastIndex) {
                graph.addEdge(id, Int.MAX_VALUE, el)
            }

        }
    }
    val dijkstra = graph.dijkstra(0, Int.MAX_VALUE)
    if (dijkstra.first <= A)
        println(dijkstra.second
            .map { (it - 1) % M }.drop(1).dropLast(1).joinToString(" ")
        )
    else
        println("IMPOSSIBLE")
}
