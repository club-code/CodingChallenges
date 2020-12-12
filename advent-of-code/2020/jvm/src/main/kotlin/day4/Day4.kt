package day4

import java.lang.IllegalStateException

fun main() {
    val input = generateSequence(::readLine)
        .fold(mutableListOf<MutableList<String>>(mutableListOf())) { l, it ->
            if (it.isEmpty()) l.add(mutableListOf()) else l[l.size - 1].addAll(it.split(" "))
            l
        }
    println(input.count { it.associate { str -> val s = str.split(":"); s[0] to s[1] }.valid() })
}

fun mainPart2() {
    val input = generateSequence(::readLine)
        .fold(mutableListOf<MutableList<String>>(mutableListOf())) { l, it ->
            if (it.isEmpty()) l.add(mutableListOf()) else l[l.size - 1].addAll(it.split(" "))
            l
        }
    println(input.count { it.associate { str -> val s = str.split(":"); s[0] to s[1] }.validPart2() })
}

fun Map<String, String>.valid(): Boolean {
    val keys = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")
    return keys.all { this[it] != null }
}

fun Map<String, String>.validPart2(): Boolean {
    val keys = listOf(
        Check("byr", "\\d{4}") { it.toInt() in 1920..2002 },
        Check("iyr", "\\d{4}") { it.toInt() in 2010..2020 },
        Check("eyr", "\\d{4}") { it.toInt() in 2020..2030 },
        Check("hgt", "\\d+(cm|in)") {
            val number = it.dropLast(2)
            when(it.takeLast(2)) {
                "cm" -> number.toInt() in 150..193
                "in" -> number.toInt() in 59..76
                else -> throw IllegalStateException("ça ne doit pas arriver par la regex")
            }
        },
        Check("hcl", "#[0-9a-f]{6}") { true },
        Check("ecl", "[a-z]{3}") { it in listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth") },
        Check("pid", "\\d{9}") { true }
    )
    return keys.all { it.isValid(this) }
}

data class Check(val str: String, val regex: String, val isValid: (String) -> Boolean) {
    fun isValid(map: Map<String, String>): Boolean {
        val value = map[str] ?: return false
        return Regex(regex).matches(value) && isValid(value)
    }
}