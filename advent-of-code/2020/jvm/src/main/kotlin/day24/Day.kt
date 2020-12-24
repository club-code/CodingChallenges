package day24

fun main() {
    val inputs = generateSequence(::readLine).map { it.toDirection().toVector() }.toList()
    println(inputs.toUniqueSet().size)
}

fun mainPart2() {
    val inputs = generateSequence(::readLine).map { it.toDirection().toVector() }.toList()
    var set = inputs.toUniqueSet()

    repeat(100) {
        set = set.executeDay()
    }
    println(set.size)
}

fun Set<Vector3>.executeDay(): Set<Vector3> {
    val all = this+this.map { it.hexagonalNeighbors() }.reduce { acc, set -> acc+set }

    return all.filter {
        val blackNeighbors = it.hexagonalNeighbors().filter { v -> v in this }.size
        if (it in this)
            blackNeighbors in 1..2
        else
            blackNeighbors == 2
    }.toSet()
}



fun Vector3.hexagonalNeighbors(): Set<Vector3> {
    return Direction.values().map { this+it.vector }.toSet()
}

fun List<Vector3>.toUniqueSet(): Set<Vector3> {
    return this.fold(mutableSetOf()){ acc, vec ->
        if (vec in acc)
            acc.remove(vec)
        else
            acc.add(vec)
        acc
    }
}

fun List<Direction>.toVector(): Vector3 {
    return this.fold(Vector3(0,0,0)) { acc, direction -> acc+direction.vector }
}

fun String.toDirection(): List<Direction> {
    val result = mutableListOf<Direction>()
    var i = 0

    while (i < this.length) {
        for (dir in Direction.values()) {
            val find = dir.regex.find(this.subSequence(i, this.length))
            if (find != null) {
                val value = find.groupValues[1]
                result.add(dir)
                i += value.length
            }
        }
    }

    return result
}

enum class Direction(str: String, val vector: Vector3) {
    E("e", Vector3(1, -1, 0)),
    SE("se", Vector3(0, -1, 1)),
    SW("sw", Vector3(-1, 0, 1)),
    W("w", Vector3(-1, 1, 0)),
    NW("nw", Vector3(0, 1, -1)),
    NE("ne", Vector3(1, 0, -1));

    val regex = Regex("^($str)")
}

data class Vector3(val x: Int, val y: Int, val z: Int) {
    operator fun plus(o: Vector3): Vector3 {
        return Vector3(x + o.x, y + o.y, z + o.z)
    }
}