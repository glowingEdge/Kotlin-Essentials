fun main() {
    var user: Users? = null
    user?.cheer()
    println(user?.cheer())  // null
    println(user?.name) // null
    println(user?.name?.length) // null
    user = Users("Cookie")
    user?.cheer()   // Hello Cookie
    println(user?.cheer())  // Hello Cookie / kotlin.Unir
    println(user.name)  // Cookie
    println(user?.name?.length) // 6

    // not null exception
    println(user!!.name)
    user = null
//    println(user!!.name.length)   // exception
//    requireNotNull(user)    // IllegalArgumentException
//    checkNotNull(user)  // IllegalStateException


    // elvis operator
    println("A" ?: "B") // A
    println(null ?: "B")    // B
    println("A" ?: null)    // A
    println(null ?: null)   // null

    user = null
    printName(user) // default
    printName(Users("Cookie"))    // Cookie

    // nullable receiver
    checkName("ABC")    // ABC ABC false false
    checkName(null)     // null "" true true
    checkName("")       // "" "" true true
    checkName("  ")     // "  " "  " true false

    // lateinit
    println(text)   // UninitializedPropertyAccessException
    if (::text.isInitialized) println(text)

}

lateinit var text: String

class Users(val name: String) {
    fun cheer() {
        println("Hello $name")
    }
}

// smart casting
fun printLengthIfNotNull(str: String?) {
//    (1)
//    if (str != null) {
//        println(str.length)
//    }

//    (2)
//    if (str == null) return
//    println(str.length)

//    (3)
//    if (str == null) throw Error()
//    println(str.length)

//    (4)
    if (str != null && str.length > 0) {
        println(str.length)
    }
}

fun printName(user: Users?) {
    val name: String =  user?.name ?: "default"
    println(name)
}

fun checkName(str: String?) {
    println("str: \"$str\"")
    println("str: \"${str.orEmpty()}\"")
    println("str: \"${str.isNullOrBlank()}\"")
    println("str: \"${str.isNullOrEmpty()}\"")
}