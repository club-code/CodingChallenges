package i

import java.util.*
import kotlin.math.floor

fun main(){
    val input = Scanner(System.`in`)

    val line = input.nextLine()
    val values = line.split(" ").map { it.toInt() }

    val n1 = values[0].toDouble()
    val n2 = values[1].toDouble()
    val n12 = values[2].toDouble()

    val result = floor((n1+1)*(n2+1)/(n12+1)-1).toInt()

    println(result)
}

