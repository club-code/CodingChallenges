package day23

fun main() {
    val inputs = readLine()!!.map { Character.getNumericValue(it) }
    println(inputs.execute(100, 9))
}

fun mainPart2() {
    val inputs = readLine()!!.map { Character.getNumericValue(it) }
    val cups = inputs + ((inputs.maxByOrNull { it }!! + 1)..1_000_000).map { it }
    println(cups.execute(10_0, 1_000_000, true))
}

fun List<Int>.execute(rounds: Int, max: Int, part2: Boolean = false): String {
    val list = this.toMutableList()
    val size = list.size

    repeat(rounds) {
        val i = it % size
        val el = list[i]

        val lastIndex = (i + 3) % size

        val nextElements = if (lastIndex > i)
            list.slice((i + 1)..lastIndex)
        else
            list.slice((i + 1) until size) + list.slice(0..lastIndex)

        assert(nextElements.size == 3)

        var n = if(el > 1) el - 1 else max
        while (n in nextElements) {
            if (--n <= 0) n = max
        }


        list.moveShift(n, el, i, nextElements)

    }
    val diff = list.indexOf(1)
    if (diff != 0) list.shiftLeft(diff)
    return if (part2)
        (list[1].toLong()*list[2].toLong()).toString()
    else
        list.subList(1, list.size).joinToString("")
}

fun MutableList<Int>.moveShift(el: Int, fixEl: Int, fixIndex: Int, elements: List<Int>) {
    this.removeAll(elements)

    this.addAll(this.indexOf(el)+1, elements)

    val diff = this.indexOf(fixEl) - fixIndex
    if(diff != 0) this.shiftLeft(diff)
}

fun MutableList<Int>.shiftLeft(count: Int) {
    val r = count%this.size
    val real = if(r < 0) r + this.size else r
    val n = (this.drop(real) + this.take(real))
    this.clear()
    this.addAll(n)
}

val IntRange.length: Int
    get() = this.last - this.first
