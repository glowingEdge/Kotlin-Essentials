fun main() {
    // If else
    var isOne = true
    val number1: Int = if (isOne) 1 else 0
    isOne = false
    val number2: Int = if (isOne) {
        1
    } else {
        0
    }
    println("$number1, $number2")

    val superUser = true
    val hasAccess: Boolean = if (superUser) {
        println("Hello, Admin")
        true
    } else {
        false
    }
    println(hasAccess)  // true

    printNumberSign(-5) // print nothing
    printNumberSign(0)  // zero
    printNumberSign(5)  // positive
    println()
    printNumberSignWhen(-5) // negative


    // When
    println(magicNumbers)
    println(describe(null))
    println(describe(1))
    println(describe(13))
    println(describe(10))
    println(describe("AAA"))
    println(describe(1L))
    println(describe(-1))
    println(describe(1.0))

    // Is
    println(5 is Int)
    println(5 is Short)
    println(5L is Long)
    println(3.14 is Double)
    println(3.14 is Float)
    println(3.14F is Float)
    println(3.14 is Number)
    println(3.14 !is String)


    // Up casting & down casting
    val i1: Int = 123
    val l1: Long = 321L
    val d1: Double = 31.4
    var number: Number = i1
    number = l1
    number = d1

    val n1: Number = 23
    // val n1: Number = 3.14    // runtime error
    val j = (n1 as Int) + 10    // down-casting 은 위험하므로 지양
    println(j)  // 33
    val n2: Number = 3.14
    val k = n2.toInt() + 10
    println(k)  // 13


    // While
    var w = 1
    while (w < 10) {
        print(w)
        w *= 2
    }   // 1248

    w = 1
    do {
        print(w)
        w *= 2
    } while (w < 10)
    // 1248

    // 함수형 프로그래밍과 함께 다시 배움
    generateSequence(1) { it * 2}
        .takeWhile {  it < 10 }
        .forEach(::print)
    println()

    // practices
    practice1()
}

fun Any?.print() {
   print(this)
}
fun printNumberSign(num: Int) {
    if (num < 0) {
        "negative"
    } else if  (num > 0) {
        "positive"
    } else {
        "zero"
    }.print()
}

fun printNumberSignWhen(num: Int) {
    when {
        num < 0 -> "negative"
        num > 0 -> "positive"
        else -> "zero"
    }.print()
}

private val magicNumbers = listOf(7, 13)
fun describe(a: Any?): String = when (a) {
    null -> "Nothing"
    1, 2, 3 -> "Small Number"
    in magicNumbers -> "Magic Number"
    in 4..100 -> "Big Number"
    is String -> "This is just $a"
    is Long, is Int -> "This is Long or Int"
    else -> "No idea, really"
}

fun convertToInt(num: Number): Int =
    if (num is Int) num
    else num.toInt()

fun lengthIfString(a: Any): Int {
    if (a is String) {
        a.length
    }
    return 0
}

fun practice1() {
    val magicNumbers = listOf(7, 13)
    fun prac1(a: Any?): String = when (a) {
        null -> "Nothing"
        1, 2, 3 -> "Small Number"
        in magicNumbers -> "Magic Number"
        in 4..100 -> "Big Number"
        is String -> "This is just $a"
        is Long, is Int -> "This is Long or Int: $a"
        else -> "No idea, really"
    }

    println(prac1(1))
    println(prac1("A"))
    println(prac1('A'))
    println(prac1(null))
    println(prac1(5))
    println(prac1(100))
    println(prac1(-1))
    println(prac1(1L))
    println(prac1(3.0))
    println(prac1(100L))
}
