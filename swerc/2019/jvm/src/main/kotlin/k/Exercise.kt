package k

import java.util.*

fun main() {
    val inputs = generateSequence(::readLine).toList()
    val node = inputs[0].split(" ")[2].toInt()
    val edges = inputs.drop(1).map {
        val s = it.split(" ")
        s[0].toInt() to s[1].toInt()
    }
    val graph = OrientedGraph()
    graph.addAll(edges)

    val set = graph.findVertices(node)
    println(set.size)
    for (x in set) {
        println(x)
    }
}

class OrientedGraph(val adjacencyList: MutableMap<Int, MutableSet<Int>> = mutableMapOf()) {

    val revertAdjacencyList by lazy {
        adjacencyList.map { it.value.map { v -> v to it.key } }.flatten().groupingBy { it.first }
            .aggregate<Pair<Int, Int>, Int, MutableSet<Int>> { _, accumulator, element, _ ->
                val acc = accumulator ?: mutableSetOf()
                acc.add(element.second)
                acc
            }.mapValues { it.value.toSet() }
    }

    fun add(from: Int, to: Int) {
        val set = adjacencyList.getOrDefault(from, mutableSetOf())
        set.add(to)
        adjacencyList[from] = set
    }

    fun addAll(edges: Collection<Pair<Int, Int>>) {
        for (edge in edges) {
            add(edge.first, edge.second)
        }
    }

    fun remove(from: Int, to: Int) {
        val set = adjacencyList.getOrDefault(from, mutableSetOf())
        set.remove(to)
    }

    fun getDestinations(from: Int) = adjacencyList.getOrDefault(from, mutableSetOf()).toSet()

    fun predecessors(node: Int) = revertAdjacencyList[node] ?: setOf()

    fun auxiliary(node: Int) =
        adjacencyList.filterKeys { it != node }.mapValues { (it.value - node).toMutableSet() }.toMutableMap()

    fun findVertices(node: Int): Set<Int> {
        val predecessors = predecessors(node)
        val auxiliary = auxiliary(node)

        val g = OrientedGraph(auxiliary)
        val goal = mutableMapOf<Int, MutableSet<Int>>()
        for (p in predecessors) {
            g.annotate(p, p, goal)
        }

        return goal.filter { it.key in predecessors && it.value.size == 1 }.keys
    }

    fun annotate(n: Int, r: Int, goal: MutableMap<Int, MutableSet<Int>>) {
        val m = goal.getOrDefault(n, mutableSetOf())
        if (r in m) return
        if (m.size >= 2) return
        m.add(r)
        goal[n] = m
        for (p in revertAdjacencyList[n] ?: setOf()) {
            annotate(p, r, goal)
        }
    }

    /**
     * @return marked elements, marked elements in out
     */
    fun breadthFirstSearch(node: Int, out: Set<Int>): Set<Int> {
        val queue = LinkedList<Int>()
        val marked = mutableSetOf<Int>()
        val goal = mutableSetOf<Int>()

        queue.add(node)
        marked.add(node)
        while (queue.isNotEmpty()) {
            val s = queue.remove()
            if (s in out)
                goal.add(s)
            for (neighbor in adjacencyList[s] ?: setOf()) {
                if (neighbor !in marked) {
                    queue.add(neighbor)
                    marked.add(neighbor)
                }
            }
        }

        return goal
    }
}
