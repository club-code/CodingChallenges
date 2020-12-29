package exercise5

import kotlin.math.abs
import org.clubcode.library.number.lcm

fun main() {
    val n = readLine()!!.toInt()
    val k = n.countPathsMinos()
    println(k)
    println(k.lcms())
//    System.err.println((1L..6L).joinToString(",") { it.lcms().toString() })
//    System.err.println((1..15).joinToString(",") { it.countPathsMinos().toString() })
}

/**
 * Too long for bigger numbers
 * max input value 69533550916004 (
 */
fun Long.lcms() : Long {
    var result = 0L
    for (i in 1..this) {
        for (j in 1..this) {
            result += lcm(i, j)
        }
    }
    return result
}

/**
 * Also Catalan Numbers
 * @see <a href="http://oeis.org/A000108"></a>
 */
fun Int.countPathsMinos(): Long {
    var previous = LongArray(this) { 0 }
    previous[0] = 1L

    var current = LongArray(this) { 0 }
    for (i in 1 until this) {
        current[0] = 1L
        for (j in 1 until this) {
            if (!manhattanMinos(this, i, j)) {
                current[j] = previous[j] + current[j-1]
            }
        }
        previous = current
        current = LongArray(this) { 0 }
    }
    return previous.last()
}

fun manhattanMinos(n: Int, i: Int, j: Int) = abs(j-n+1) + abs(i) < n - 1
