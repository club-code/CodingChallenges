package day14

import org.clubcode.library.number.pow

fun main() {
    val inputs = generateSequence(::readLine).map { it.split(" = ") }.toList()
    println(inputs.execute())
}

fun mainPart2() {
    val inputs = generateSequence(::readLine).map { it.split(" = ") }.toList()
    println(inputs.executePart2())
}

fun Long.changeBit(i: Int, value: Char): Long {
    val binary = this.toString(2)
    val str = StringBuilder("0".repeat(36 - binary.length) + binary)
    str[i] = value
    return str.toString().toLong(2)
}

class Mask(val mask: String) {
    fun apply(input: Long): Long {
        var result = input
        for (i in mask.indices) {
            if (mask[i] != 'X') {
                result = result.changeBit(i, mask[i])
            }
        }
        return result
    }

    fun applyPart2(input: Long): List<Long> {
        val xs = mutableSetOf<Int>()
        var base = input

        for (i in mask.indices) {
            when (mask[i]) {
                'X' -> xs.add(i)
                '1' -> base = base.changeBit(i, mask[i])
            }
        }

        val result = base.variations(xs.toList(), 0)

        assert(2.pow(xs.size) == result.size)
        return result
    }
}

fun Long.variations(s: List<Int>, i: Int): List<Long> {
    return if(i == s.size) {
        listOf(this)
    } else {
        val x = s[i]
        this.changeBit(x, '0').variations(s, i+1) + this.changeBit(x, '1').variations(s, i+1)
    }
}

val memRegex = Regex("""mem\[(\d+)]""")

fun List<List<String>>.executePart2(): Long {
    val map = mutableMapOf<Long, Long>()
    var mask = Mask("")

    for (instruction in this) {
        when (instruction[0]) {
            "mask" -> mask = Mask(instruction[1])
            else -> {
                val index = memRegex.matchEntire(instruction[0])!!.groupValues[1].toLong()
                val value = instruction[1].toLong()
                mask.applyPart2(index).forEach { map[it] = value }
            }
        }
    }

    return map.values.reduce { acc, l -> acc + l }
}

fun List<List<String>>.execute(): Long {
    val map = mutableMapOf<Int, Long>()
    var mask = Mask("")

    for (instruction in this) {
        when (instruction[0]) {
            "mask" -> mask = Mask(instruction[1])
            else -> {
                val index = memRegex.matchEntire(instruction[0])!!.groupValues[1].toInt()
                val value = instruction[1].toLong()
                map[index] = mask.apply(value)
            }
        }
    }

    return map.values.reduce { acc, l -> acc + l }
}