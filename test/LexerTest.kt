import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class LexerTest {
    @Test fun testNextToken() {
        val input = """let five = 5;
        let ten = 10;

        let add = fn(x, y) {
            x + y;
        };

        let result = add(five, ten);
        !-/*5;
        5 < 10 > 5;

        if (5 < 10) {
            return true;
        } else {
            return false;
        }

        10 == 10
        10 != 9"""

        val lexer = Lexer(input)
        val expectedTokens = arrayOf(
                Pair(TokenType.LET, "let"),
                Pair(TokenType.IDENT, "five"),
                Pair(TokenType.ASSIGN, "="),
                Pair(TokenType.INT, "5"),
                Pair(TokenType.SEMICOLON, ";"),
                Pair(TokenType.LET, "let"),
                Pair(TokenType.IDENT, "ten"),
                Pair(TokenType.ASSIGN, "="),
                Pair(TokenType.INT, "10"),
                Pair(TokenType.SEMICOLON, ";"),
                Pair(TokenType.LET, "let"),
                Pair(TokenType.IDENT, "add"),
                Pair(TokenType.ASSIGN, "="),
                Pair(TokenType.FUNCTION, "fn"),
                Pair(TokenType.LPAREN, "("),
                Pair(TokenType.IDENT, "x"),
                Pair(TokenType.COMMA, ","),
                Pair(TokenType.IDENT, "y"),
                Pair(TokenType.RPAREN, ")"),
                Pair(TokenType.LBRACE, "{"),
                Pair(TokenType.IDENT, "x"),
                Pair(TokenType.PLUS, "+"),
                Pair(TokenType.IDENT, "y"),
                Pair(TokenType.SEMICOLON, ";"),
                Pair(TokenType.RBRACE, "}"),
                Pair(TokenType.SEMICOLON, ";"),
                Pair(TokenType.LET, "let"),
                Pair(TokenType.IDENT, "result"),
                Pair(TokenType.ASSIGN, "="),
                Pair(TokenType.IDENT, "add"),
                Pair(TokenType.LPAREN, "("),
                Pair(TokenType.IDENT, "five"),
                Pair(TokenType.COMMA, ","),
                Pair(TokenType.IDENT, "ten"),
                Pair(TokenType.RPAREN, ")"),
                Pair(TokenType.SEMICOLON, ";"),
                Pair(TokenType.BANG, "!"),
                Pair(TokenType.MINUS, "-"),
                Pair(TokenType.SLASH, "/"),
                Pair(TokenType.ASTERISK, "*"),
                Pair(TokenType.INT, "5"),
                Pair(TokenType.SEMICOLON, ";"),
                Pair(TokenType.INT, "5"),
                Pair(TokenType.LT, "<"),
                Pair(TokenType.INT, "10"),
                Pair(TokenType.GT, ">"),
                Pair(TokenType.INT, "5"),
                Pair(TokenType.SEMICOLON, ";"),
                Pair(TokenType.IF, "if"),
                Pair(TokenType.LPAREN, "("),
                Pair(TokenType.INT, "5"),
                Pair(TokenType.LT, "<"),
                Pair(TokenType.INT, "10"),
                Pair(TokenType.RPAREN, ")"),
                Pair(TokenType.LBRACE, "{"),
                Pair(TokenType.RETURN, "return"),
                Pair(TokenType.TRUE, "true"),
                Pair(TokenType.SEMICOLON, ";"),
                Pair(TokenType.RBRACE, "}"),
                Pair(TokenType.ELSE, "else"),
                Pair(TokenType.LBRACE, "{"),
                Pair(TokenType.RETURN, "return"),
                Pair(TokenType.FALSE, "false"),
                Pair(TokenType.SEMICOLON, ";"),
                Pair(TokenType.RBRACE, "}"),
                Pair(TokenType.INT, "10"),
                Pair(TokenType.EQ, "=="),
                Pair(TokenType.INT, "10"),
                Pair(TokenType.INT, "10"),
                Pair(TokenType.NOT_EQ, "!="),
                Pair(TokenType.INT, "9"),
                Pair(TokenType.EOF, "")
        )

        for (expectedToken in expectedTokens) {
            val token = lexer.nextToken()
            assertEquals(expectedToken.first, token.type)
            assertEquals(expectedToken.second, token.literal)
        }
    }
}