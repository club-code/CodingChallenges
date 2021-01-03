package problem102

import org.clubcode.library.vector.IntVector2

fun main() {
    val inputs = generateSequence(::readLine).map { it.split(",").map { i -> i.toInt() }.toTriangle() }
    println(inputs.count { it.contains(IntVector2(0, 0)) })
}

fun List<Int>.toTriangle(): Triangle {
    return Triangle(
        IntVector2(this[0], this[1]),
        IntVector2(this[2], this[3]),
        IntVector2(this[4], this[5])
    )
}

data class Triangle(val a: IntVector2, val b: IntVector2, val c: IntVector2) {
    fun contains(x: IntVector2): Boolean {
        val area = 1.0 / 2 * (-b.y * c.x + a.y * (-b.x + c.x) + a.x * (b.y - c.y) + b.x * c.y)
        val sign = if (area < 0) -1 else 1
        val s = (a.y * c.x - a.x * c.y + (c.y - a.y) * x.x + (a.x - c.x) * x.y) * sign
        val t = (a.x * b.y - a.y * b.x + (a.y - b.y) * x.x + (b.x - a.x) * x.y) * sign

        return s > 0 && t > 0 && s + t < 2 * area * sign
    }
}
