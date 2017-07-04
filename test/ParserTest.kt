package monkey

import org.testng.annotations.Test
import kotlin.test.fail

class ParserTest {
    @Test
    fun testLetStatements() {
        val input = """
	    let x = 5;
	    let y = 10;
	    let foobar = 838383;"""

        val lexer = Lexer(input)
        val parser = Parser(lexer)

        val program = parser.parseProgram()
        if (program.statements.size != 3) {
            //fail("program.statements does not contain three statements")
        }
    }
}