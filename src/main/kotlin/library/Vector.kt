package library

import kotlin.math.*

data class Vector(val x:Int, val y:Int){
    fun getManhattanDistance(v: Vector) = abs(x-v.x) + abs(y-v.y)

    fun getEuclideanDistance(v: Vector) = sqrt((x-v.x).toDouble().pow(2.0)+(y-v.y).toDouble().pow(2.0))

    fun getDistance(v: Vector) = getEuclideanDistance(v)

    fun getDistance(v: Vector, alpha: Double) =  ((x-v.x).toDouble().pow(alpha)+(y-v.y).toDouble().pow(alpha)).pow(1/alpha)

    fun getAngle(v: Vector) = acos((x*v.x+y*v.y)/(norm*v.norm))

    operator fun minus(v: Vector) = Vector(x-v.x,y-v.y)

    operator fun plus(v: Vector) = Vector(x+v.x,y+v.y)

    val norm: Double by lazy {
        sqrt(x.toDouble().pow(2.0) + y.toDouble().pow(2.0))
    }
}
