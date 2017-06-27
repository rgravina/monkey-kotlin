enum class TokenType {
    ILLEGAL,
    EOF,
    IDENT,
    INT,
    ASSIGN,
    PLUS,
    MINUS,
    BANG,
    ASTERISK,
    SLASH,
    LT,
    GT,
    EQ,
    NOT_EQ,
    COMMA,
    SEMICOLON,
    LPAREN,
    RPAREN,
    LBRACE,
    RBRACE,
    FUNCTION,
    LET,
    TRUE,
    FALSE,
    IF,
    ELSE,
    RETURN;

    companion object {
        val keywords: Map<String, TokenType> = mapOf(
                "fn" to FUNCTION,
                "let" to LET,
                "true" to TRUE,
                "false" to FALSE,
                "if" to IF,
                "else" to ELSE,
                "return" to RETURN
        )

        fun lookupIdent(ident: String): TokenType {
            return keywords.getOrDefault(ident, IDENT)
        }
    }
}
