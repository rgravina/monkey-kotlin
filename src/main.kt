package monkey

import java.lang.System.getProperty

fun main(args: Array<String>) {
    val username = getProperty("user.name")
    println("Hello ${username}! This is the Monkey programming language!\n")
}
