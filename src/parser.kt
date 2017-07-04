package monkey

class Parser (
    private val lexer: Lexer,
    private var currentToken: Token = lexer.nextToken(),
    private var peekToken: Token = lexer.nextToken(),
    private val errors: Array<String> = emptyArray()
) {
    fun parseProgram() : Program {
        val program = Program()
        while (currentToken.type != TokenType.EOF) {
            nextToken()
        }
        return program
    }

    fun nextToken() {
        currentToken = peekToken
        peekToken = lexer.nextToken()
    }
}