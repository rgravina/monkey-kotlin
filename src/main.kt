package monkey

import java.lang.System

fun main(args: Array<String>) {
    val username = System.getProperty("user.name")
    println("Hello ${username}! This is the Monkey programming language!\n")
    Repl(System.`in`, System.out)
}
