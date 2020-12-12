package day7

fun main() {
    val inputs = generateSequence(::readLine)
        .map { s ->
            val bag = s.split(" bags contain ")
            val list = bag[1]
                .dropLast(1)
                .split(", ")
                .mapNotNull { it.toBagCount() }
            bag[0] to list
        }.toMap()
    val cache = inputs.keys.map<String, Pair<String, Boolean?>> { it to null }.toMap().toMutableMap()
    println(inputs.count { it.key.containsGold(inputs, cache) })
}

fun mainPart2() {
    val inputs = generateSequence(::readLine)
        .map { s ->
            val bag = s.split(" bags contain ")
            val list = bag[1]
                .dropLast(1)
                .split(", ")
                .mapNotNull { it.toBagCount() }
            bag[0] to list
        }.toMap()
//    val cache = inputs.keys.map<String, Pair<String, Boolean?>> { it to null }.toMap().toMutableMap()
    println("shiny gold".countChildren(inputs) - 1)
}

data class BagCount(val bag: String, val count: Int)

fun String.containsGold(map: Map<String, List<BagCount>>, cache: MutableMap<String, Boolean?>): Boolean {
    val l = map[this] ?: error("Should not be fired")
    val result = if(l.isEmpty())
        return false
    else
        l.any { it.bag == "shiny gold" } || l.any { it.bag.containsGold(map, cache) }
    cache[this] = result
    return result
}

fun String.countChildren(map: Map<String, List<BagCount>>): Int {
    return 1 + (map[this] ?: error("Should not be fired")).fold(0){ acc, bagCount ->
        acc + bagCount.count * bagCount.bag.countChildren(map)
    }
}

fun String.toBagCount(): BagCount? {
    val words = this.split(" ")
    if(this == "no other bags")
        return null
    return BagCount(words[1] + " " + words[2], words[0].toInt())
}
