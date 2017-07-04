package monkey

import org.testng.annotations.Test

class ParserTest {
    @Test fun testLetStatements() {
        val input = """
	    let x = 5;
	    let y = 10;
	    let foobar = 838383;"""

        val lexer = Lexer(input)
        val parser = Parser(lexer)

        parser.parseProgram()
    }
}