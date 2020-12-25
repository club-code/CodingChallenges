package k

fun main() {
    val inputs = generateSequence(::readLine).toList()
    val node = inputs[0].split(" ")[2].toInt()
    val edges = inputs.drop(1).map {
        val s = it.split(" ")
        s[0].toInt() to s[1].toInt()
    }
    val graph = OrientedGraph()
    graph.addAll(edges)


}

class OrientedGraph {
    val adjacencyList = mutableMapOf<Int, MutableSet<Int>>()

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

    fun annotate() {

    }
}
