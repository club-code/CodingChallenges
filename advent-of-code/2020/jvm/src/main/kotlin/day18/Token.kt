package day18

data class Token(
    val type: TokenType,
    val value: String,
    val index: Int
)

sealed class TokenType(r: String) {
    val regex = Regex("^($r)")
}

object Whitespace : TokenType("[\t\n ]+")
object Value : TokenType("\\d+")
object OpenParenthesis : TokenType("\\(")
object CloseParenthesis : TokenType("\\)")
object Plus : TokenType("\\+")
object Times : TokenType("\\*")

object EOF : TokenType("")