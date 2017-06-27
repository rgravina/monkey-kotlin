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
        skipWhitespace()
        val token = when (character) {
            '=' -> Token(TokenType.ASSIGN, character.toString())
            '+' -> Token(TokenType.PLUS, character.toString())
            '-' -> Token(TokenType.MINUS, character.toString())
            '!' -> Token(TokenType.BANG, character.toString())
            '/' -> Token(TokenType.SLASH, character.toString())
            '*' -> Token(TokenType.ASTERISK, character.toString())
            '<' -> Token(TokenType.LT, character.toString())
            '>' -> Token(TokenType.GT, character.toString())
            '(' -> Token(TokenType.LPAREN, character.toString())
            ')' -> Token(TokenType.RPAREN, character.toString())
            '{' -> Token(TokenType.LBRACE, character.toString())
            '}' -> Token(TokenType.RBRACE, character.toString())
            ',' -> Token(TokenType.COMMA, character.toString())
            ';' -> Token(TokenType.SEMICOLON, character.toString())
            else -> {
                if (isLetter()) {
                    val ident = readIdentifier()
                    return Token(TokenType.lookupIdent(ident), ident)
                } else if (isDigit()) {
                    return Token(TokenType.INT, readNumber())
                } else {
                    Token(TokenType.ILLEGAL, "")
                }
            }
        }
        readChar()
        return token
    }

    private fun readNumber(): String {
        val startPosition = position
        while (isDigit()) readChar()
        return input.substring(startPosition, position)
    }

    private fun isDigit(): Boolean = character in '0'..'9'

    private fun skipWhitespace() {
        while (character == ' ' ||
                character == '\t' ||
                character == '\n' ||
                character == '\r')
            readChar()
    }

    private fun readIdentifier(): String {
        val startPosition = position
        while (isLetter()) readChar()
        return input.substring(startPosition, position)
    }

    private fun isLetter() =
            character in 'a'..'z' ||
                    character in 'A'..'Z' ||
                    character == '_'
}