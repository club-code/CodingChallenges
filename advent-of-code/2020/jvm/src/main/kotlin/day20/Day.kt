package day20

import library.Vector2
import org.clubcode.library.collection.split

fun main() {
    val inputs = generateSequence(::readLine).split { it.isEmpty() }.map { it.toTile() }.toList()
    val solutions = inputs.filter { it.getPotentialNeighbours(inputs).size == 2 }
        .fold(1L){ acc, tile -> acc*tile.id }

    println(solutions)
}

fun mainPart2() {
    val inputs = generateSequence(::readLine).split { it.isEmpty() }.map { it.toTile() }.toList()
    val solutions = inputs.map { it.id to it.getPotentialNeighbours(inputs) }.toMap()

    val inputsMap = inputs.map{it.id to it}.toMap()
    val corners = solutions.filter { it.value.size == 2 }.keys.toList()
    val sides = solutions.filter { it.value.size == 3 }.keys
    val others = solutions.keys-corners-sides

    val map = mutableMapOf<Int, Pair<Int, Int>>()
    val size = sides.size/4+2

    map[corners[0]] = 0 to 0

    var tile = solutions[corners[0]]!![0]
    var previous = map[corners[0]]!!

    while (true) {
        map[tile.id] = previous.incr(size-1)
        previous = map[tile.id]!!

        val new = solutions[tile.id].also { if (it == null) System.err.println("$solutions $tile") }!!.getSideOrCorner(sides, corners)
        if (new.all { map[it]!= null })
            break
        tile = if (map[new[0]] == null) inputsMap[new[0]]!! else inputsMap[new[1]]!!
    }

    System.err.println(map)
}

fun List<Tile>.getSideOrCorner(sides: Set<Int>, corners: List<Int>): List<Int> {
    return this.map { it.id }.filter{ it in sides || it in corners }
}

fun Pair<Int, Int>.incr(max: Int): Pair<Int, Int> {
    return when {
        this.first < max && this.second == 0 -> (this.first+1) to 0
        this.first == max && this.second < max -> max to (this.second+1)
        this.first > 0 && this.second == max -> (this.first-1) to max
        this.first == 0 && this.second > 0 -> 0 to (this.second-1)
        else -> error("Impossible incr")
    }

}

fun fill(map: MutableMap<Tile, Pair<Int, Int>>, solutions: Map<Int, List<Tile>>, others: Set<Tile>) {
    val final = others.toMutableSet()
    while (true) {
        for (tile in final) {
            val el = solutions[tile]!!.filter { map[it] != null }
            if (el.size >= 3) {

            }
        }
    }
}

//fun List<Pair<Int, Int>>.findTripleCase(): Pair<Int, Int> {
//    val x = this.take(3).map { it.toVector2() }
//    val x1 = x[0]
//    val x2 = x[1]
//    val x3 = x[2]
//    if(x1.getManhattanDistance(x2) == 2) {
//        if (x1.x == x2.x) {
//            (x3.x+1) to x3.y
//        }
//        if (x1.y == x2.y) {
//            (x3.y+1) to x3.x
//        }
//            x3.
//    } else if(x1.getManhattanDistance(x3) == 2) {
//
//    } else { //x2 x3
//
//    }
//
//}

fun Pair<Int, Int>.toVector2(): Vector2 {
    return Vector2(this.first, this.second)
}

const val SIZE = 10

data class Tile(val id: Int, val elements: List<String>) {
    private val edgeTop = elements.first()
    private val edgeBottom = elements.last()
    private val edgeLeft = elements.map { it.first() }.joinToString("")
    private val edgeRight = elements.map { it.last() }.joinToString("")

    operator fun get(i: Int, j: Int) = elements[i][j]

    fun getColumn(j: Int) = elements.map { it[j] }.joinToString("")

    fun checkNeighbor(neighbor: Tile, dir: Direction) =
        when (dir) {
            Direction.NORTH -> edgeTop == neighbor.edgeBottom
            Direction.EAST -> edgeLeft == neighbor.edgeRight
            Direction.WEST -> edgeRight == neighbor.edgeLeft
            Direction.SOUTH -> edgeBottom == neighbor.edgeTop
        }

    fun flipH() = Tile(id, elements.reversed())
    fun flipV() = Tile(id, elements.map { it.reversed() })

    fun rotate(quarter: Int): Tile {
        return when (quarter % 4) {
            0 -> this
            1 -> Tile(id, elements.indices.map { getColumn(it).reversed() })
            2 -> Tile(id, elements.reversed().map { it.reversed() })
            3 -> Tile(id, elements.indices.reversed().map { getColumn(it) })
            else -> throw IllegalStateException("impossible")
        }
    }

    val rotations by lazy {
        setOf(
            rotate(1),
            rotate(2),
            rotate(3),
            flipH(),
            flipV(),
            rotate(1).flipH(),
            rotate(1).flipV()
        )
    }

    fun getPotentialNeighbours(all: List<Tile>): List<Tile> {
        val others = all-this
        return (rotations + this).map { others.mapNotNull { o ->
            val rots = (o.rotations + o).toList()
            rots.indices.mapNotNull { i ->
                val dir = it.matchesInAnyDirection(rots[i])
                if (dir == null)
                    null
                else
                    rots[i]
            }.firstOrNull()
        } }.maxByOrNull { it.size }!!.also { System.err.println("$this rotations: $it") }
    }

    fun matchesInAnyDirection(other: Tile): Direction? {
        return Direction.values().firstOrNull { this.checkNeighbor(other, it) }
    }

    override fun toString(): String {
        return "Tile($id)"
    }

}

fun List<String>.toTile(): Tile {
    val id = this[0].dropLast(1).split(" ")[1].toInt()
    return Tile(id, this.drop(1))
}

enum class Direction {
    NORTH, EAST, SOUTH, WEST
}

