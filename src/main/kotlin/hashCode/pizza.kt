package hashCode

import java.util.*
import kotlin.math.max


fun exo(maxSlices: Int, pizzas: Array<Int>): Array<Int>{
    val T = Array(pizzas.size+1){Array(maxSlices+1){0}}
    for (i in 1 until T.size){
        for(c in T[i].indices){
            if(c >= pizzas[i-1]){
                T[i][c] = max(T[i-1][c], T[i-1][c-pizzas[i-1]]+pizzas[i-1])
            } else {
                T[i][c] = T[i-1][c]
            }
        }
    }

    var i = T.size-1
    var j = T[i].size-1
    var res = T[i][j]
    println("sum: $res")
    // val result = res
    val itemsSolution = LinkedList<Int>()

    while (i > 0 && res > 0) {
        if (res != T[i - 1][j]) {
            itemsSolution.addFirst(i-1)
            res -= pizzas[i - 1]
            j -= pizzas[i - 1]
        }
        i--
    }

    return itemsSolution.toTypedArray()

}

fun exoOpti(maxSlices: Int, pizzas: Array<Int>): Array<Int>{
    val T = Array(2){Array(maxSlices+1){0}}
    for (i in 1 until T.size){
        for(c in T[i].indices){
            if(c >= pizzas[i-1]){
                T[i][c] = max(T[i-1][c], T[i-1][c-pizzas[i-1]]+pizzas[i-1])
            } else {
                T[i][c] = T[i-1][c]
            }
        }
    }

    var i = T.size-1
    var j = T[i].size-1
    var res = T[i][j]
    println("sum: $res")
    // val result = res
    val itemsSolution = LinkedList<Int>()

    while (i > 0 && res > 0) {
        if (res != T[i - 1][j]) {
            itemsSolution.addFirst(i-1)
            res -= pizzas[i - 1]
            j -= pizzas[i - 1]
        }
        i--
    }

    return itemsSolution.toTypedArray()

}

fun display(array: Array<Array<Int>>){
    println("[ ")
    for(i in array.indices){
        print("  [")
        for(j in array[i].indices){
            print(" ${array[i][j]},")
        }
        println("],")
    }
    println("]")
}

