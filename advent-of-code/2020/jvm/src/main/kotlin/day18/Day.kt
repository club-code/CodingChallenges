package day18

fun main() {
    val inputs = generateSequence(::readLine)
    val lexer = Lexer(listOf(Whitespace, OpenParenthesis, CloseParenthesis, Plus, Times, Value))

    println(
        inputs
            .map { Parser(lexer.parse(it).filterNot { t -> t.type is Whitespace }).parse().value() }
            .reduce { acc, i -> acc+i }
    )
}

fun mainPart2() {
    val inputs = generateSequence(::readLine)
    val lexer = Lexer(listOf(Whitespace, OpenParenthesis, CloseParenthesis, Plus, Times, Value))

    println(
        inputs
            .map { Parser(lexer.parse(it).filterNot { t -> t.type is Whitespace }).parsePart2().value() }
            .reduce { acc, i -> acc+i }
    )
}




