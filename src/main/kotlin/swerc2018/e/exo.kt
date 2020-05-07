package swerc2018.e

import java.util.*
import kotlin.math.max
import kotlin.math.min
import kotlin.math.round

fun main(){
    val input = Scanner(System.`in`)

    val N = input.nextInt()

    val values = mutableListOf<Pair<String, Int>>()
    repeat(N){
        val name = input.next()
        val value = input.nextInt()
        values.add(name to value)
    }

    if(N == 1){
        if(values[0].second == 100)
            println("${values[0].first} 100.00 100.00")
        else
            println("IMPOSSIBLE")
        return
    }
    val sum = values.map{it.second}.reduce { acc, it -> acc+it }
    val delta = 100 - sum
    val dmax = delta - (N-1)*0.49
//    val emax = (0.49+delta)/(N-1)
    if(dmax in -0.50..0.49)
        values.map {
            val min = "%.2f".format(Locale.ENGLISH, (max(0.0, it.second + dmax)).round(2))
            val max = "%.2f".format(Locale.ENGLISH, (min(100.0,it.second + (delta-dmax)/(N-1))).round(2))
            println("${it.first} $min $max")
        }
    else if(delta < 0){
        println("cas à prévoir")
    } else
        println("IMPOSSIBLE")
}


fun Double.round(decimals: Int): Double {
    var multiplier = 1.0
    repeat(decimals) { multiplier *= 10 }
    return round(this * multiplier) / multiplier
}
