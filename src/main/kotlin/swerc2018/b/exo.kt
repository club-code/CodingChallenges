package swerc2018.b

import java.util.*

fun main(){
    val input = Scanner(System.`in`)

    val N = input.nextInt()
    val abs = mutableListOf<Pair<Int, Int>>()
    repeat(N){
        val a = input.nextInt()
        val b = input.nextInt()
        abs.add(a to b)
    }


}