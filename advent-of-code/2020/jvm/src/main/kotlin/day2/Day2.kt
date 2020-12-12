package day2

fun main() {
    val input = generateSequence(::readLine).map { it.toInput() }
    println(input.count { it.isOkay() })
}

fun mainPart2() {
    val input = generateSequence(::readLine).map { it.toInput() }
    println(input.count { it.isOkay2() })
}

fun String.toInput(): Input {
    val elements = this.split(" ")
    val range = elements[0].split("-")
    return Input(range[0].toInt(), range[1].toInt(), elements[1][0], elements[2])
}

data class Input(val min: Int, val max: Int, val c: Char, val str: String) {
    fun isOkay() = str.count { it == c } in min..max

    fun isOkay2() = (str[min-1] == c) xor (str[max-1] == c)
}