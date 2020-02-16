package b

import java.text.FieldPosition
import kotlin.math.*

data class Vector(val x:Int, val y:Int){
    fun getDistanceManhattan(v: Vector) = abs(x-v.x)+abs(y-v.y)
}

data class Hiding(val position: Vector)

fun exo(inputs: Array<Vector>): Hiding{
    val hidings = inputs.map { Hiding(it) }
    val costs = Array(inputs.size){0.0}
    for(i in hidings.indices){
        var total = 0
        for(j in hidings.indices){
            if(i != j)
                total += hidings[j].position.getDistanceManhattan(hidings[i].position)
        }
        val average = total.toDouble()/hidings.size.toDouble()
        costs[i] = (average)
    }
    var min = Double.MAX_VALUE
    var mini: Hiding? = null
    for(i in costs.indices){
        if(costs[i] < min){
            min = costs[i]
            mini = hidings[i]
        } else if(costs[i] == min && mini != null){
            mini = if(mini.position.x < hidings[i].position.x){
                mini
            } else if(mini.position.x > hidings[i].position.x){
                hidings[i]
            } else {
                if(mini.position.y < hidings[i].position.y){
                    mini
                } else {
                    hidings[i]
                }
            }
        }
    }
    return mini!!

}
