package monkey

class Parser (
    private val lexer: Lexer,
    private val currentToken: Token? = null,
    private val peekToken: Token? = null,
    private val errors: Array<String> = emptyArray()
) {
    fun parseProgram() {
    }
}