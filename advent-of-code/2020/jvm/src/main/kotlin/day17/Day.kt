package day17

import kotlin.math.max
import kotlin.math.min

fun main() {
    val inputs = generateSequence(::readLine).toList()
    val space = Space()

    for (line in inputs.withIndex()) {
        for (c in line.value.withIndex()) {
            if (c.value == '#') {
                space.setActive(Vector3(c.index, line.index, 0))
            }
        }
    }


    repeat(6) {
        space.cycle()
    }

    println(space.actives)
}

fun mainPart2() {
    val inputs = generateSequence(::readLine).toList()
    val space = Space4()

    for (line in inputs.withIndex()) {
        for (c in line.value.withIndex()) {
            if (c.value == '#') {
                space.setActive(Vector4(c.index, line.index, 0, 0))
            }
        }
    }


    repeat(6) {
        space.cycle()
    }

    println(space.actives)
}

class Space(private var elements: MutableSet<Vector3> = mutableSetOf()) {
    val actives: Int
        get() = elements.size

    var bounds = Bounds()

    private fun setActive(elements: MutableSet<Vector3>, bounds: Bounds, o: Vector3) {
        elements.add(o)
        bounds.update(o)
    }

    fun setActive(o: Vector3) {
        setActive(elements, bounds, o)
    }

    fun activeNeighbours(o: Vector3): List<Vector3> {
        val result = mutableListOf<Vector3>()

        for (i in -1..1) {
            for (j in -1..1) {
                for (k in -1..1) {
                    val n = Vector3(o.x + i, o.y + j, o.z + k)
                    if (!(i == 0 && j == 0 && k == 0) && isActive(n)) {
                        result.add(n)
                    }
                }
            }
        }

        return result
    }

    fun isActive(o: Vector3) = o in elements

    fun cycle() {
        val newElements = mutableSetOf<Vector3>()
        val newBounds = Bounds()

        for (i in (bounds.minX - 1)..(bounds.maxX + 1)) {
            for (j in (bounds.minY - 1)..(bounds.maxY + 1)) {
                for (k in (bounds.minZ - 1)..(bounds.maxZ + 1)) {
                    val point = Vector3(i, j, k)
                    val neighbors = activeNeighbours(point)
                    if (isActive(point) && neighbors.size in 2..3 ||
                        !isActive(point) && neighbors.size == 3
                    ) {
                        setActive(newElements, newBounds, point)
                    }
                }
            }
        }

        elements = newElements
        bounds = newBounds
    }

}

data class Bounds(var inferior: Vector3 = Vector3(0, 0, 0), var superior: Vector3 = Vector3(0, 0, 0)) {
    val minX: Int
        get() = inferior.x
    val minY: Int
        get() = inferior.y
    val minZ: Int
        get() = inferior.z

    val maxX: Int
        get() = superior.x
    val maxY: Int
        get() = superior.y
    val maxZ: Int
        get() = superior.z

    fun update(o: Vector3) {
        inferior = Vector3(min(inferior.x, o.x), min(inferior.y, o.y), min(inferior.z, o.z))
        superior = Vector3(max(superior.x, o.x), max(superior.y, o.y), max(superior.z, o.z))
    }
}

data class Vector3(val x: Int, val y: Int, val z: Int)

class Space4(private var elements: MutableSet<Vector4> = mutableSetOf()) {
    val actives: Int
        get() = elements.size

    var bounds = Bounds4()

    private fun setActive(elements: MutableSet<Vector4>, bounds: Bounds4, o: Vector4) {
        elements.add(o)
        bounds.update(o)
    }

    fun setActive(o: Vector4) {
        setActive(elements, bounds, o)
    }

    fun activeNeighbours(o: Vector4): List<Vector4> {
        val result = mutableListOf<Vector4>()

        for (i in -1..1) {
            for (j in -1..1) {
                for (k in -1..1) {
                    for (l in -1..1) {
                        val n = Vector4(o.x + i, o.y + j, o.z + k, o.w + l)
                        if (!(i == 0 && j == 0 && k == 0 && l == 0) && isActive(n)) {
                            result.add(n)
                        }
                    }
                }
            }
        }

        return result
    }

    fun isActive(o: Vector4) = o in elements

    fun cycle() {
        val newElements = mutableSetOf<Vector4>()
        val newBounds = Bounds4()

        for (i in (bounds.minX - 1)..(bounds.maxX + 1)) {
            for (j in (bounds.minY - 1)..(bounds.maxY + 1)) {
                for (k in (bounds.minZ - 1)..(bounds.maxZ + 1)) {
                    for (l in (bounds.minW - 1)..(bounds.maxW + 1)) {
                        val point = Vector4(i, j, k, l)
                        val neighbors = activeNeighbours(point)
                        if (isActive(point) && neighbors.size in 2..3 ||
                            !isActive(point) && neighbors.size == 3
                        ) {
                            setActive(newElements, newBounds, point)
                        }
                    }
                }
            }
        }

        elements = newElements
        bounds = newBounds
    }

}

data class Bounds4(
    var inferior: Vector4 = Vector4(0, 0, 0, 0),
    var superior: Vector4 = Vector4(0, 0, 0, 0)
) {
    val minX: Int
        get() = inferior.x
    val minY: Int
        get() = inferior.y
    val minZ: Int
        get() = inferior.z
    val minW: Int
        get() = inferior.w

    val maxX: Int
        get() = superior.x
    val maxY: Int
        get() = superior.y
    val maxZ: Int
        get() = superior.z
    val maxW: Int
        get() = superior.w

    fun update(o: Vector4) {
        inferior = Vector4(min(inferior.x, o.x), min(inferior.y, o.y), min(inferior.z, o.z), min(inferior.w, o.w))
        superior = Vector4(max(superior.x, o.x), max(superior.y, o.y), max(superior.z, o.z), max(superior.w, o.w))
    }
}

data class Vector4(val x: Int, val y: Int, val z: Int, val w: Int)
