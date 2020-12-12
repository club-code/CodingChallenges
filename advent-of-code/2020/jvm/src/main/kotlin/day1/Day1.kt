package day1

import java.util.*

fun main() {
    val input = Scanner(System.`in`)
    val elements = mutableListOf<Int>()
    while (input.hasNextLine()) {
        elements.add(input.nextLine().toInt())
    }

    println(elements.sum(2020))
}

fun mainPart2() {
    val input = Scanner(System.`in`)
    val elements = mutableListOf<Int>()
    while (input.hasNextLine()) {
        elements.add(input.nextLine().toInt())
    }

    println(elements.sumThree(2020))
}

fun mainSet1() {
    val input = Scanner(System.`in`)
    val elements = mutableListOf<Int>()
    while (input.hasNextLine()) {
        elements.add(input.nextLine().toInt())
    }

    println(elements.sumSet(2020))
}

fun mainSet2() {
    val input = Scanner(System.`in`)
    val elements = mutableListOf<Int>()
    while (input.hasNextLine()) {
        elements.add(input.nextLine().toInt())
    }

    println(elements.sumSetThree(2020))
}

fun List<Int>.sumSet(target: Int): Int {
    val set = this.toSet()
    for (element in set) {
        if (target - element in set) {
            return (target - element) * element
        }
    }
    return -1
}

fun List<Int>.sumSetThree(target: Int): Int {
    val set = this.toSet()
    for (element in set) {
        for (other in set) {
            if(other != element && target - element - other in set)
                return (target - element - other) * element * other
        }
    }
    return -1
}

fun List<Int>.sum(target: Int): Int {
    val l = this.sorted()
    var i = 0
    var j = l.size - 1
    while (i < j) {
        val sum = l[i] + l[j]

        when {
            sum == target -> {
                return l[i] * l[j]
            }
            sum < target -> {
                i++
            }
            else -> {
                j--
            }
        }
    }

    return -1
}


fun List<Int>.sumThree(target: Int): Int {
    val l = this.sorted()
    for (i in l.indices) {
        var k = i + 1
        var j = l.size - 1
        while (k < j) {
            val sum = l[k] + l[j] + l[i]
            when {
                sum == target -> {
                    return l[k] * l[j] * l[i]
                }
                sum < target -> {
                    k++
                }
                else -> {
                    j--
                }
            }
        }
    }
    return -1
}

