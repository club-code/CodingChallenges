package day21

fun main() {
    val inputs = generateSequence(::readLine).map {
        val r = it.split(" (contains ")
        r[0].split(" ") to r[1].dropLast(1).split(", ")
    }.toList()

    println(inputs.parse().first.sum())

}

fun mainPart2() {
    val inputs = generateSequence(::readLine).map {
        val r = it.split(" (contains ")
        r[0].split(" ") to r[1].dropLast(1).split(", ")
    }.toList()

    println(inputs.parse().second.joinToString(","))
}

fun List<Pair<List<String>, List<String>>>.parse(): Pair<List<Int>, List<String>> {
    val countsAllergens = this.map { it.second }.flatten().groupingBy { it }.eachCount()
    val associateIngredients = this.map { it.first.map { s -> s to it.second } }.flatten()
        .groupingBy { it.first }.aggregate { _, accumulator: MutableMap<String, Int>?, element, _ ->
            val acc = accumulator ?: mutableMapOf()
            for (el in element.second) {
                val v = acc.getOrDefault(el, 0)
                acc[el] = v + 1
            }
            acc
        }
    val countIngredients = this.map { it.first }.flatten().groupingBy { it }.eachCount()

    val x = associateIngredients.map {
        it.key to it.value.filter { v -> countsAllergens[v.key]!! <= v.value }
    }.toMap()

    val noAllergensIngredients = x.filter { it.value.isEmpty() }.map { it.key }

    val allergenics = x.filterNot { it.key in noAllergensIngredients }
        .map { it.key to it.value.map { it.key }.toSet() }.toMap()

    return noAllergensIngredients.map { countIngredients[it]!! } to allergenics.findConstraints().sortedBy { it.second }.map { it.first }
}

fun Map<String, Set<String>>.findConstraints(): List<Pair<String, String>> {
    return if (this.values.all { it.size == 1 }) {
        this.entries.map { it.key to it.value.first() }
    } else {
        val uniques = this.filter { it.value.size == 1 }.map { it.value }.flatten().toSet()
        this.map { it.key to (if (it.value.size > 1) it.value-uniques else it.value) }.toMap().findConstraints()
    }
}
