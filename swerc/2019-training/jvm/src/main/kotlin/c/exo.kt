package c

import library.Vector2
import kotlin.math.*

fun exo(inputs: Array<Vector2>): Int{
    var total = 0
    val u = Vector2(1,0)
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
    return total
}


