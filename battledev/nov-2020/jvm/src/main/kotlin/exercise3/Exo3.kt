package exercise3

import java.util.*

fun main() {
    val input = generateSequence(::readLine)
    val lines = input.toList()
    val nodes = mutableMapOf<Int, MutableList<Int>>()
    nodes[0] = mutableListOf()
    val result = Array(10){0}
    val queue = LinkedList<Pair<Int, Int>>()
    // level, node
    queue.add(0 to 0)
    lines.drop(1).map{it.split(" ")}.map{it[0].toInt() to it[1].toInt()}.forEach{nodes.putChild(it.first, it.second)}


    while (queue.isNotEmpty()) {
        val element = queue.remove()
        result[element.first]++
        queue.addAll(nodes[element.second]!!.map{(element.first + 1) to it})
    }

    println(result.joinToString(" "))
}

fun MutableMap<Int, MutableList<Int>>.putChild(value: Int, parent: Int) {
    this.getOrPut(value){mutableListOf()}
    val p = this.getOrPut(parent){mutableListOf()}
    p.add(value)
}
