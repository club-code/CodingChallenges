package e

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
    } else {
        val mins = values.map { max(0.0, it.second - 0.5) }
        val maxs = values.map { min(100.0, it.second + 0.49) }
        val minSum = mins.sum()
        val maxSum = maxs.sum()

        if (minSum > 100.0 || maxSum < 100.0) {
            println("IMPOSSIBLE")
        } else {
            val realMin = values.zip(mins).mapIndexed { index, it ->
                it.first.first to max(it.second, maxs[index] - (maxSum - 100))
            }
            val realMax = values.zip(maxs).mapIndexed { index, it ->
                it.first.first to min(it.second, mins[index] - (minSum - 100))
            }
            realMin.zip(realMax).forEach {
                println("${it.first.first} %.2f %.2f".format(Locale.ENGLISH, it.first.second, it.second.second))
            }
        }
    }

}
