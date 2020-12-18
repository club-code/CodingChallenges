package day18

class Parser(private val tokens: List<Token>) {
    private var i = 0

    private val current
        get() = tokens[i]

    fun parse(): AST {
        return expr()
    }

    fun parsePart2(): AST {
        return exprPart2()
    }

    /**
     * factor: VALUE | ( expr )
     */
    private fun factor(): AST {

        return when (current.type) {
            Value -> {
                val node = current
                eat(Value)
                Num(node.value.toLong())
            }
            OpenParenthesis -> {
                eat(OpenParenthesis)
                val node = expr()
                eat(CloseParenthesis)
                node
            }
            else -> error("Syntax error: current ${current.type}, should be Value or OpenParenthesis")
        }
    }

    private fun factorPart2(): AST {

        return when (current.type) {
            Value -> {
                val node = current
                eat(Value)
                Num(node.value.toLong())
            }
            OpenParenthesis -> {
                eat(OpenParenthesis)
                val node = exprPart2()
                eat(CloseParenthesis)
                node
            }
            else -> error("Syntax error: current ${current.type}, should be Value or OpenParenthesis")
        }
    }

    /**
     * term: factor (PLUS factor)*
     */
    private fun term(): AST {
        var node = factorPart2()

        while (current.type is Plus) {
            eat(Plus)
            node = PlusOp(node, factorPart2())
        }

        return node
    }

    private fun allTogether(): AST {
        var node = factor()

        while (current.type in listOf(Plus, Times)) {
            when (current.type) {
                Plus -> {
                    eat(Plus)
                    node = PlusOp(node, factor())
                }
                Times -> {
                    eat(Times)
                    node = TimesOp(node, factor())
                }
            }
        }

        return node
    }

    private fun expr(): AST {
        return allTogether()
    }


    /**
     * expr: term (TIMES term)*
     */
    private fun exprPart2(): AST {
        var node = term()
        while (current.type is Times) {
            eat(Times)
            node = TimesOp(node, term())
        }
        return node
    }



    private fun eat(tokenType: TokenType) {
        if (current.type != tokenType)
            error("Syntax error: current ${current.type}, should be $tokenType")
        i++
    }
}

interface AST {
    fun value(): Long
}

abstract class BinOp(val left: AST, val right: AST): AST

class PlusOp(left: AST, right: AST) : BinOp(left, right) {
    override fun value(): Long = left.value() + right.value()
    override fun toString(): String {
        return "PlusOp($left, $right)"
    }
}

class TimesOp(left: AST, right: AST) : BinOp(left, right) {
    override fun value(): Long = left.value() * right.value()
    override fun toString(): String {
        return "TimesOp($left, $right)"
    }
}

class Num(val value: Long) : AST {
    override fun value() = value
    override fun toString(): String {
        return "$value"
    }
}
