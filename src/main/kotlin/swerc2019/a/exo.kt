package swerc2019.a

import java.lang.Integer.max
import java.util.*
import kotlin.math.ceil
import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    val s = Scanner(System.`in`)

    val house = Vector2(s.nextInt(), s.nextInt())
    val destination = Vector2(s.nextInt(), s.nextInt())
    val maxDistance = s.nextInt()
    val carCO2 = s.nextInt()
    val transportsCO2 = List(s.nextInt()) {
        s.nextInt()
    }
    val stations = List(s.nextInt()) {
        Station(Vector2(s.nextInt(), s.nextInt()), List(s.nextInt()) {
            Link(s.nextInt(), s.nextInt())
        })
    }

    val size = stations.size + 2
    val graph = Graph(size)
    graph.addTransition(0, size - 1, destination.toCost(house, carCO2))
    for (index in stations.indices) {
        graph.addTransition(0, index + 1, stations[index].position.toCost(house, carCO2))
        graph.addTransition(index + 1, size - 1, stations[index].position.toCost(destination, carCO2))
        for (link in stations[index].links) {
            val c = stations[link.other].position.toCost(stations[index].position, transportsCO2[link.mode - 1])
            graph.addTransition(index + 1, link.other + 1, c)
            graph.addTransition(link.other + 1, index + 1, c)
        }
    }

    val dists = graph.dijkstraMax(maxDistance, size - 1)
    println(dists)
}

data class Vector2(val x: Int, val y: Int) {
    fun dist(other: Vector2) = ceil(sqrt((x - other.x).toDouble().pow(2) + (y - other.y).toDouble().pow(2))).toInt()
}

fun Vector2.toCost(other: Vector2, factor: Int): Cost {
    val dist = this.dist(other)
    return Cost(dist, dist * factor)
}

data class Cost(val distance: Int, val CO2: Int) : Comparable<Cost> {
    operator fun plus(other: Cost) = Cost(distance + other.distance, CO2 + other.CO2)

    override fun compareTo(other: Cost): Int {
        return CO2 - other.CO2
    }
}

data class Node(val i: Int, val cost: Cost) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return cost.CO2 - other.cost.CO2
    }
}

data class Link(val other: Int, val mode: Int)

data class Station(val position: Vector2, val links: List<Link>)

class Graph(val nbNodes: Int) {
    private val values = MutableList(nbNodes) { MutableList<Cost?>(nbNodes) { null } }

    fun addTransition(start: Int, end: Int, cost: Cost) {
        values[start][end] = cost
    }

    fun dijkstraMax(max: Int, dest: Int): Int {
        //System.err.println(values)
        val dist = arrayOfNulls<Cost>(nbNodes)
        dist[0] = Cost(0, 0)

        val priorityQueue = PriorityQueue<Node>()

        priorityQueue.add(Node(0, Cost(0, 0)))

        while (priorityQueue.isNotEmpty()) {
            val node = priorityQueue.poll()
            //System.err.println("node: $node")
            if (node.i == dest)
                return node.cost.CO2
            for (v in values[node.i].indices) {
                val neighbor = values[node.i][v]
                if (neighbor != null) {
                    //System.err.println("   neighbor: $v")
                    val alt = node.cost + neighbor

                    if (alt.distance <= max &&
                        (alt.distance < dist[v]?.distance ?: Int.MAX_VALUE ||
                                alt.CO2 < dist[v]?.CO2 ?: Int.MAX_VALUE)
                    ) {
                        if (alt.distance < dist[v]?.distance ?: Int.MAX_VALUE && alt.CO2 < dist[v]?.CO2 ?: Int.MAX_VALUE)
                            dist[v] = alt
                        //System.err.println("      v: $v, alt: $alt")
                        priorityQueue.add(Node(v, alt))
                    }
                }
            }
        }
        return -1
    }

}