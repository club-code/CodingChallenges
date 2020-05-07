package swerc2018.d

import java.util.*
import kotlin.collections.HashMap
import kotlin.math.abs


fun main(){
    val input = Scanner(System.`in`)
    val X = input.nextInt()
    val Y = input.nextInt()
    val N = input.nextInt()

    val coords = hashMapOf<Int, Pair<Int, Int>>()
    repeat(N){
        val x = input.nextInt()
        val y = input.nextInt()
        val minMax = coords[x]
        if(minMax == null)
            coords[x] = y to y
        else {
            if(y > minMax.second)
                coords[x] = minMax.first to y
            if(y < minMax.first)
                coords[x] = y to minMax.second
        }
    }

    println((0 until Y).map { distance(X, it, coords) }.min())
}

fun distance(X:Int, y: Int, l: HashMap<Int,Pair<Int, Int>>) =
    (0 until X).map {
        val minMax = l[it]
        if(minMax != null) {
            when {
                y < minMax.first -> 2 * (abs(minMax.second - y))
                y > minMax.second -> 2 * (abs(minMax.first - y))
                else -> 2 * (abs(minMax.first - y) + abs(minMax.second - y))
            }
        } else {
            0
        }
    }.reduce {
            acc, i -> acc+i
    }+X-1



