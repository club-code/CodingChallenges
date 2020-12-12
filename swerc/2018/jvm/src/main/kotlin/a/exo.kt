package a

import java.util.*
import kotlin.math.max

fun main(){
    val input = Scanner(System.`in`)

    val N = input.nextInt()
    val lights = BooleanArray(N){true}

    var maxi = 0
    var current = 0

    val k = input.nextInt()
    repeat(k) {
        val i = input.nextInt()
        var j = i
        while(j <= N){
            lights[j-1] = ! lights[j-1]
            if(lights[j-1]){
                current --
            } else {
                current ++
            }
            j+=i
        }
        maxi = max(maxi, current)
    }

    println(maxi)
}