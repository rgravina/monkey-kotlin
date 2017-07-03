package monkey

import java.io.InputStream
import java.io.PrintStream

val PROMPT = ">>"

data class Repl(
        val inputStream: InputStream,
        val out: PrintStream
) {
    init {
        while (true) {
            print(PROMPT)
            val line = readLine()
            val lexer = Lexer(line.toString())
            var token = lexer.nextToken()
            while (token.type != TokenType.EOF) {
                println("${token.type} ${token.literal}")
                token = lexer.nextToken()
            }
        }
    }
}