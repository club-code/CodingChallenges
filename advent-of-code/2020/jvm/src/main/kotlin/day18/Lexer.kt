package day18

class Lexer(private val tokenTypes: List<TokenType>) {
    fun parse(expression: String): List<Token> {
        val result = mutableListOf<Token>()
        var i = 0

        while (i < expression.length) {
            var found = false

            for (type in tokenTypes) {
                val find = type.regex.find(expression.subSequence(i, expression.length))
                if (find != null) {
                    val value = find.groupValues[1]
                    result.add(Token(type, value, i))
                    i += value.length
                    found = true
                }
            }
            if(!found)
                throw NoSuchElementException("no token could be find next $expression ${expression.subSequence(i, expression.length)}")
        }

        result.add(Token(EOF, "", i))

        return result
    }
}