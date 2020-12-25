package exercise2

fun main() {
    val nbFamilies = readLine()!!.toInt()
    val nbMembers = readLine()!!.toInt()
    val families = (0 until nbFamilies).map { readLine()!!.map { it }.toSet() }
    readLine()
    val cards = readLine()!!

    println(nbMembers - (families.map { cards.count {c -> c in it } }.maxOrNull() ?: 0))
}
