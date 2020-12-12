@file:Suppress("EXPERIMENTAL_API_USAGE")
package exercise5

import org.clubcode.library.number.pow

fun main()=println("%4#\"3\$?"+readLine())

fun String.toHash(): UInt {
    return this.mapIndexed { i, c -> c.toInt().toUInt() * 31.pow(this.length - 1 - i).toUInt() }
        .reduce { acc, i -> acc+i }
}

fun findFirst(): String {
    val alphabet = 33.toChar()..126.toChar()
    var str = 33.toChar().toString()
    var i = 0

    while (str.toHash() != 0.toUInt()) {
        val hash = str.toHash()
        str = if(str[i]+1 in alphabet) {
            val n = str.take(i) + (str[i] + 1) + str.drop(i+1)
            if (n.toHash() <= hash) {
                i++
                if(i == str.length) n else str
            } else {
                n
            }
        } else {
            33.toChar().toString().repeat(str.length + 1)
        }
    }

    return str
}


