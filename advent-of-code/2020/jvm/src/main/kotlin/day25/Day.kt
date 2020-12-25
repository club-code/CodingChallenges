package day25

const val subjectNumber = 7

fun main() {
    val inputs = generateSequence(::readLine).map { it.toInt() }.toList()
    val cardLoopSize = findTransform(inputs[0])
//    val doorLoopSize = findTransform(inputs[1])
    println(transform(inputs[1], cardLoopSize))
}

fun mainPart2() {

}

fun f(x: Int, subject: Int = subjectNumber) = ((x.toLong() * subject.toLong()) % 20201227).toInt()

fun findTransform(publicKey: Int): Int {
    var x = 1
    var i = 0

    while (x != publicKey) {
        x = f(x)
        i++
    }

    return i
}

fun transform(subject: Int, count: Int): Int {
    var x = 1

    repeat(count) {
        x = f(x, subject)
    }

    return x
}
