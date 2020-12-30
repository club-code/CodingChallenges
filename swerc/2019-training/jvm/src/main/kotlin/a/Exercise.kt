package a

@ExperimentalUnsignedTypes
fun main() {
    readLine()
    val numbers = readLine()!!.split(" ").map { it.toLong() }
    println(resolveMatrix(numbers))
}

@ExperimentalUnsignedTypes
fun resolveMatrix(numbers: List<Long>): Long {
    val matrix = LongArray(numbers.size*numbers.size)

    for (j in 1 until numbers.size) {
        for (i in 0 until (numbers.size - j)) {
            matrix[i*numbers.size+(j + i)] = if (j == 1) {
                numbers[i] + numbers[i + 1]
            } else {
                (i..(i + j)).splits().map {
                    matrix[it.first.first*numbers.size+it.first.last] + matrix[it.second.first*numbers.size+it.second.last]
                }.minOrNull()!! + numbers.subList(i, i + j + 1).sum()
            }
        }
    }

    return matrix[numbers.size - 1]
}

fun IntRange.splits(): List<Pair<IntRange, IntRange>> {
    val result = mutableListOf<Pair<IntRange, IntRange>>()

    for (i in (this.first + 1)..this.last) {
        result.add(this.first until i to i..this.last)
    }

    return result
}
