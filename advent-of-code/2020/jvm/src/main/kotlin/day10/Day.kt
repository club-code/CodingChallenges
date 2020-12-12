package day10

fun main() {
    val inputs = generateSequence(::readLine).map { it.toInt() }.sorted().toList()
    println(inputs.jumps().toOutput())
}

fun mainPart2() {
    val inputs = generateSequence(::readLine).map { it.toInt() }.sorted().toList()
    println(inputs.arrangements())
}

fun List<Int>.jumps(): Jump {
    val jumps = Array(3){0}
    var previous = 0

    for (i in this) {
        jumps[i-previous-1]++
        previous = i
    }

    jumps[2]++

    return Jump(jumps)
}

fun List<Int>.arrangements(): Long {
    val list = (listOf(0) + this)
    System.err.println(list)
    var previous = 0
    var previousIndex = 0

    val packed = list.foldIndexed(mutableListOf<List<Int>>()) { i, l, it ->
        if (it != previous+1) {
            l.add(list.subList(previousIndex, i))
            previousIndex = i
        }
        if (i == list.size-1) {
            l.add(list.subList(previousIndex, i+1))
        }
        previous = it
        l
    }

    System.err.println(packed)

    val result = packed.map {
        val trueSize = it.size-2
        if(trueSize >= 1 ) fibonacciThree(trueSize).first else 1
    }

    System.err.println(result)

    return result.map { it.toLong() }.reduce { acc, i -> acc*i }
}

fun fibonacciThree(n: Int): Triple<Int, Int, Int> {
    return when (n) {
        0 -> Triple(1, 0, 0)
        1 -> Triple(2, 1, 0)
        2 -> Triple(4, 2, 1)
        else -> {
            val values = fibonacciThree(n-1)
            Triple(values.first+values.second+values.third, values.first, values.second)
        }
    }
}

class Jump(val jumps: Array<Int>) {
    fun toOutput() = jumps[0].toLong() * jumps[2].toLong()
}
