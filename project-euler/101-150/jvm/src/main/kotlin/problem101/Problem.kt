package problem101

import org.clubcode.library.polynomial.Polynomial
import org.clubcode.library.polynomial.toLagrangePolynomial
import org.clubcode.library.vector.Vector2
import kotlin.math.roundToLong

fun main(polynomial: Polynomial): Long {
    val values = (1..(polynomial.degree+1)).map { polynomial[it.toDouble()] }

    var p = Polynomial(1.0)
    var i = 1
    var result = 0L
    while (p != polynomial) {
        result += p[(i+1).toDouble()].roundToLong()
        p = Polynomial(*values.subList(0, i+1).mapIndexed { index, d ->
            Vector2((index+1).toDouble(), d)
        }.toLagrangePolynomial().coefficients.map { it.roundToLong().toDouble() }.toDoubleArray())
        i++
    }
    return result
}
