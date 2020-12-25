package f

import org.clubcode.library.collection.split
import org.clubcode.library.math.LongVector2
import kotlin.math.abs
import kotlin.math.absoluteValue

fun main() {
    val inputs = generateSequence(::readLine)
    val polygons = inputs.drop(2).split { Regex("^\\d+$").matches(it) }.map {
        Polygon(it.map { s ->
            val split = s.split(" ")
            LongVector2(split[0].toLong(), split[1].toLong())
        })
    }
    println(polygons.map { it.areaTrapeze() }.sum().toLong())
}

class Polygon(val points: List<LongVector2>) {
    fun areaTriangle(): Double {
        val start = points[0]
        return points.drop(1).windowed(2).map { (listOf(start)+it).toTriple().areaTriangle() }.sum()
    }

    fun areaTrapeze(): Double {
        return (points.windowed(2).map { it[0] to it[1] }+listOf(points.last() to points.first()))
            .map { it.signedAreaTrapeze() }.sum().absoluteValue
    }
}

fun <T> List<T>.toPair(): Pair<T, T> {
    require(this.size == 2)
    return this[0] to this[1]
}

fun <T> List<T>.toTriple(): Triple<T, T, T> {
    require(this.size == 3)
    return Triple(this[0], this[1], this[2])
}

fun Triple<LongVector2, LongVector2, LongVector2>.areaTriangle(): Double {
    return abs((this.second-this.first).crossNorm(this.third-this.first).toDouble())/2
}

fun Pair<LongVector2, LongVector2>.signedAreaTrapeze(): Double {
    return (this.first.y+this.second.y).toDouble()*(this.second.x-this.first.x).toDouble()/2
}
