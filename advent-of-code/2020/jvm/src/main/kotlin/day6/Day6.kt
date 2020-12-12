package day6

import org.clubcode.library.collection.split

fun main() {
    val inputs: List<List<String>> = generateSequence(::readLine)
        .split { it.isEmpty() }
    println(inputs.sumBy { it.questions() })
}

fun mainPart2() {
    val inputs: List<List<String>> = generateSequence(::readLine)
        .split { it.isEmpty() }
    println(inputs.sumBy { it.questionsPart2() })
}

fun List<String>.questions(): Int {
    val map = mutableMapOf<Char, Int>()
    for(str in this) {
        for(c in str) {
            map[c] = map.getOrDefault(c, 0) + 1
        }
    }
    return map.size
}

fun List<String>.questionsPart2(): Int {
    val map = mutableMapOf<Char, Int>()
    for(str in this) {
        for(c in str) {
            map[c] = map.getOrDefault(c, 0) + 1
        }
    }
    return map.filter { it.value == this.size }.size
}

