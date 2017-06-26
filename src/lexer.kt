data class Token(val type: TokenType, val literal: String)

data class Lexer(
        private val input: String,
        private var position: Int = 0,
        private var readPosition: Int = 0,
        private var character: Char = '0'
) {

    init {
        readChar()
    }

    private fun readChar() {
        character = input[readPosition]
        position = readPosition
        readPosition += 1
    }

    fun nextToken(): Token {
        return when (character) {
            '+' -> Token(TokenType.PLUS, character.toString())
            else -> {
                Token(TokenType.ILLEGAL, "")
            }
        }
    }
}