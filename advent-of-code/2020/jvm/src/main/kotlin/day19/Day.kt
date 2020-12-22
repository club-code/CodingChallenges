package day19

import org.clubcode.library.collection.split

fun main() {
    val inputs = generateSequence(::readLine).split { it.isEmpty() }
    val rules = inputs[0].map {
        val r = it.split(": ")
        r[0].toInt() to r[1].toRegexable()
    }.toMap()
    val strings = inputs[1]

    val r = mutableMapOf<Int, String>()
    (rules to r).toConstraint()
    val regex = Regex(r[0]!!)
    println(strings.count { regex.matchEntire(it) != null })
}

fun mainPart2() {
    val inputs = generateSequence(::readLine).split { it.isEmpty() }
    val rules = inputs[0].map {
        val r = it.split(": ")
        val i = r[0].toInt()
        when (i) {
            8 -> i to ReferenceRegex(listOf(listOf(42), listOf(42, 8)))
            11 -> i to ReferenceRegex(listOf(listOf(42, 31), listOf(42, 11, 31)))
            else -> i to r[1].toRegexable()
        }
    }.toMap()
    val strings = inputs[1]

    val r = mutableMapOf<Int, String>()
    (rules to r).toConstraint()
    val regex = Regex(r[0]!!)
    System.err.println(r[0])
    System.err.println(r[42])
    System.err.println(r[31])
    println(strings.count {
        val a = regex.matchEntire(it)
        if (a != null)
            System.err.println(a.groupValues[1])
        a != null
    })
}

fun String.foundParentheses() {

}

fun String.toRegexable(): Regexable {
    return if (this[0] == '"')
        StringRegex(this[1].toString())
    else
        ReferenceRegex(this.split(" | ").map { it.split(" ").map { n -> n.toInt() } })
}

fun Set<String>.prefix(l: Set<String>): Set<String> {
    val result = mutableSetOf<String>()

    for (str in this) {
        for (s in l) {
            result.add(str+s)
        }
    }

    return result
}

fun Pair<Map<Int, Regexable>, MutableMap<Int, Set<String>>>.toConstraint(id: Int = 0): Set<String> {
    val x = this.second[id]
    if (x != null)
        return x

    val y = this.first[id]!!
    this.second[id] = when (y) {
        is StringRegex -> setOf(y.str)
        is ReferenceRegex -> {
            y.rules.asSequence().map { it.asSequence().map { e -> this.toConstraint(e) }.reduce { acc, set -> acc.prefix(set) } }
                .reduce { acc, set -> acc+set }
        }
    }
    return this.second[id]!!
}


fun Pair<Map<Int, Regexable>, MutableMap<Int, String>>.toConstraint(id: Int = 0): String {
    val x = this.second[id]
    if (x != null)
        return x

    val y = this.first[id]!!
    when (id) {
        !in listOf(8, 11) -> {
            this.second[id] = when (y) {
                is StringRegex -> y.str
                is ReferenceRegex -> {
                    y.rules.asSequence().map {
                        it.joinToString("") { e ->
                            val r = this.toConstraint(e)
                            if (r.length == 1) r else "(?:$r)"
                        }
                    }.joinToString("|")
                }
            }
        }
        8 -> {
            this.second[id] = "(?:(?:${this.toConstraint(42)})+)"
        }
        11 -> {
            this.second[id] = "((?:${this.toConstraint(42)}){1}(?:${this.toConstraint(31)}){1}|(?:${this.toConstraint(42)}){2}(?:${this.toConstraint(31)}){2}|(?:${this.toConstraint(42)}){3}(?:${this.toConstraint(31)}){3}|(?:${this.toConstraint(42)}){4}(?:${this.toConstraint(31)}){4})"
        }
    }
    return this.second[id]!!
}

sealed class Regexable

class ReferenceRegex(val rules: List<List<Int>>) : Regexable()

class StringRegex(val str: String) : Regexable()
