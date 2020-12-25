package g

fun main() {
    val inputs = generateSequence(::readLine).toList()
    val nbSpecies = inputs[0].split(" ")[0].toInt()
    val friends = inputs.subList(nbSpecies + 1, inputs.size).dropLast(1).map {
        it.split(" ")
    }.groupingBy { it[0] }.aggregate<List<String>, String, MutableList<String>> { _, accumulator, element, _ ->
        val acc = accumulator ?: mutableListOf()
        acc.add(element[1])
        acc
    }
    System.err.println(friends)
    val last = inputs.last().split(" ")
    println(last.toMutableList().bubbleSort(friends).joinToString(" "))
}

fun MutableList<String>.bubbleSort(friends: Map<String, List<String>>): List<String> {

    for (i in this.lastIndex downTo 0) {
        for (j in 0 until i) {
            if (this[j + 1] < this[j] &&
                (this[j] in friends[this[j + 1]] ?: listOf() || this[j + 1] in friends[this[j]] ?: listOf())
            ) {
                val t = this[j]
                this[j] = this[j + 1]
                this[j + 1] = t
            }
        }
    }

    return this
}

