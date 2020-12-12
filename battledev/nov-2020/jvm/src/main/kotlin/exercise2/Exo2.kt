package exercise2

fun main() {
    val input = generateSequence(::readLine)
    val lines = input.toList()
    System.err.println(lines)
    println(
        if((lines.drop(1)
                .map{val x = it.split(":");Time(x[0].toInt(), x[1].toInt())}
                .filter{it.inNight()}
                .size).toDouble()/(lines.size - 1) <= 0.5)
            "OK"
        else "SUSPICIOUS"
    )
}

data class Time(val hour: Int, val minute: Int) {
    fun inNight() = hour >= 20 || hour < 8
}
