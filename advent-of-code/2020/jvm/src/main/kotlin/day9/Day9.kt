package day9

fun mainSample() {
    val inputs = generateSequence(::readLine).map { it.toLong() }.toList()
    println(inputs.findFirst(5))
}

fun main() {
    val inputs = generateSequence(::readLine).map { it.toLong() }.toList()
    println(inputs.findFirst(25))
}

fun mainPart2() {
    val inputs = generateSequence(::readLine).map { it.toLong() }.toList()
    println(inputs.contiguous(inputs.findFirst(25)))
}

fun mainSamplePart2() {
    val inputs = generateSequence(::readLine).map { it.toLong() }.toList()
    println(inputs.contiguous(inputs.findFirst(5)))
}

fun List<Long>.contiguous(value: Long): Long {
    for (i in 0 until this.size-1) {
        var end = i
        var sum = this[i]

        while (sum < value && end in this.indices) {
            end++
            sum += this[end]
        }

        if(sum == value)
            return this.subList(i, end+1).max()!! + this.subList(i, end+1).min()!!
    }
    return -1L
}

fun List<Long>.findFirst(size: Int): Long {
    val windowed = this.windowed(size).map { it.toSet() }
    for (i in size until this.size) {
        if (!windowed[i - size].findPair(this[i]))
            return this[i]
    }
    return -1
}

fun Set<Long>.findPair(value: Long): Boolean {
    return this.any{ this.contains(value - it) }
}
