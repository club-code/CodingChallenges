package c

import org.clubcode.library.vector.IntVector2
import kotlin.math.*

fun main() {
    val inputs = generateSequence(::readLine).drop(1).map {
        val v = it.split(" ")
        IntVector2(v[0].toInt(), v[1].toInt())
    }.toList()

    var total = 0
    val u = IntVector2(1,0)
    for(i in inputs){
        for(j in inputs){
            if(i != j && i.y > j.y){
                val angle =  u.getAngle(i-j)
                val vue = PI/6
                if(angle in vue..PI-vue){
                    total++
                }
            }
        }
    }

    println(total)
}


