package a

import kotlin.math.max

fun main() {
    val inputs = generateSequence(::readLine).toList()

    val N = inputs[0].toInt()
    val elements = inputs.drop(2).map { it.toInt() }
    val lights = BooleanArray(N) { true }

    var maxi = 0
    var current = 0

    for (i in elements) {
        for (j in i..N step i) {
            lights[j - 1] = !lights[j - 1]
            if (lights[j - 1])
                current--
            else
                current++
        }
        maxi = max(maxi, current)
    }

    println(maxi)
}
