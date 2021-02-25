package e

import kotlin.math.abs

fun main() {
    val inputs = generateSequence(::readLine).toList()
    val (height, width) = inputs.first().split(" ").map { it.toInt() }
    val grid = Grid(
        width,
        inputs.drop(1).map { it.split(" ").map { s -> "B" == s } }.flatten().toBooleanArray()
    )

    val result = grid.gaussianElimination()
    System.err.println("equals to start: " + result.toggle(width).contentEquals(grid.lines))
    println(result.withIndex().joinToString("") {
        (if(it.value) "P" else "A") +
                (if((it.index+1) % width == 0) "" else " ") +
                (if(it.index != 0 && (it.index+1) % width == 0) "\n" else "")
    })
}

class Grid(val width: Int, val lines: BooleanArray) {
    init {
        require(width > 0)
        require(lines.size % width == 0)
    }

    fun gaussianElimination(): BooleanArray {
        // Create the matrix
        val contraints = lineContraints()
//
//        System.err.println(contraints.joinToString("\n"))
//        System.err.println("###")

        // Downwards
        for (j in lines.indices) {
            val u = contraints.findPivot(j)
            if (u == -1) {
                println("IMPOSSIBLE")
                continue
//                return booleanArrayOf()
            }
            if (u != j)
                contraints.swap(u, j)
            for (i in (j + 1) until lines.size) {
                if (contraints[i].isColumnPivot(j))
                    contraints[i] xor contraints[j]
            }
        }

//        System.err.println(contraints.joinToString("\n"))

        // Upwards
        val result = BooleanArray(lines.size)
        for (i in result.indices.reversed()) {
            contraints[i].resolve(i, result)
        }

        System.err.println("###")
        System.err.println(result.joinToString(" ") { if (it) "1" else "0" })

        return result
    }

    fun lineContraints(): MutableList<Line> =
        (lines.indices).map { u ->
            val c = coordToIndice(u)
            Line(u, BooleanArray(lines.size + 1) { v ->
                if (v in lines.indices)
                    coordToIndice(v).distance(c.first, c.second) <= 1
                else
                    lines[u]
            })
        }.toMutableList()

    fun indiceFromCoord(i: Int, j: Int): Int = i * width + j
    fun coordToIndice(u: Int) = u / width to u % width
}

class Line(val indice: Int, val array: BooleanArray) {
    infix fun xor(other: Line): Line {
        require(this.array.size == other.array.size)
        for (i in array.indices) {
            array[i] = array[i] xor other.array[i]
        }
        return this
    }

    fun resolve(i: Int, values: BooleanArray) {
        values[i] = values.zip(this.array).drop(i+1).map { it.first and it.second }.fold(false) { acc, v ->
            acc xor v
        } xor array.last()
//        values[i] = values.sliceArray(i + 1 until values.size)
//            .foldIndexed(false) { j, acc, v ->
//                acc xor (v and values[j + i + 1])
//            } xor array.last()
    }

    fun isColumnPivot(column: Int) = array[column]

    override fun toString(): String {
        return array.joinToString(" ") { if (it) "1" else "0" } + " x[${indice}]"
    }
}

fun <T> MutableList<T>.swap(i: Int, j: Int) {
    require(i in this.indices)
    require(j in this.indices)

    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}

fun List<Line>.findPivot(column: Int): Int {
    require(column >= 0)
    val result = this.drop(column).indexOfFirst { it.isColumnPivot(column) }
    return if (result < 0) -1 else result + column
}

fun Pair<Int, Int>.distance(i: Int, j: Int) = abs(this.first - i) + abs(this.second - j)

fun BooleanArray.toggle(width: Int): BooleanArray {
    val result = BooleanArray(this.size)
    val height = this.size/width
    for (u in this.indices) {
        if (this[u]) {
            result[u] = !result[u]
            val (i, j) = coordToIndice(width, u)
            var v = indiceFromCoord(width, i + 1, j)
            if (v in this.indices && i+1 in 0 until height && j in 0 until width)
                result[v] = !result[v]
            v = indiceFromCoord(width, i - 1, j)
            if (v in this.indices && i-1 in 0 until height && j in 0 until width)
                result[v] = !result[v]
            v = indiceFromCoord(width, i, j + 1)
            if (v in this.indices && i in 0 until height && j+1 in 0 until width)
                result[v] = !result[v]
            v = indiceFromCoord(width, i, j - 1)
            if (v in this.indices && i in 0 until height && j-1 in 0 until width)
                result[v] = !result[v]
        }
    }

    return result
}

fun indiceFromCoord(width: Int, i: Int, j: Int): Int = i * width + j
fun coordToIndice(width: Int, u: Int) = u / width to u % width