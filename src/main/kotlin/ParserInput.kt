class ProblemInput {
    val lines : MutableList<Line> = mutableListOf()

    fun line(init: Line.() -> Unit): Line {
        val line = Line()
        line.init()
        lines.add(line)
        return line
    }

//    fun parse(input: String) {
//        val lines = input.split("\n")
//    }

}

class Line {
    val elements : MutableList<Value<*>> = mutableListOf()

    operator fun <T> Value<T>.unaryPlus() {
        elements.add(this)
    }
}

interface Value<T> {
    fun toType(s: String): T
}

class IntValue : Value<Int> {
    override fun toType(s: String) = s.toInt()
}

fun main() {
    val input = problemInput {
        line {
            +IntValue()
            +IntValue()
        }
    }

    val i = input.lines[0].elements[0].toType("1")
    println(i)
}


fun problemInput(init: ProblemInput.() -> Unit): ProblemInput {
    val input = ProblemInput()
    input.init()
    return input
}





//
//
//interface Line {
//    fun cut(line: String, separator: String) = line.split(separator)
//}
//
//interface UniformLine<T> : Line {
//
//    fun toType(input: String): T
//
//    fun parse(line: String) = cut(line, " ").map { toType(it) }
//}
//
//class LineInt : UniformLine<Int>{
//    override fun toType(input: String) = input.toInt()
//}
//
//class LineString : UniformLine<String>{
//    override fun toType(input: String) = input
//}
//
//class LineDouble : UniformLine<Double>{
//    override fun toType(input: String) = input.toDouble()
//}
