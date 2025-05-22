import org.testng.AssertJUnit.assertEquals
import org.testng.annotations.Test

fun main() {
    val list = listOf("A", "B", "C")
    for (str in list) {
        println(str)
    }
    for (str: String in list) {
        println(str)
    }

    for (i in 1..5) {
        println(i)
    }
    for (i in 1..<5) {
        println()
    }
    for (i in 1 until 5) {
        println(i)
    }
    for (i in 5 downTo 1) {
        println(1)
    }
    for (i in 1..10 step 3) {
        println(i)
    }

    // break continue
    for (i in 1..5) {
        if (i ==3) break
        println(i)
    }
    for (i in 1..5) {
        if (i ==3) continue
        println(i)
    }

    // bad example
    val names = listOf("Alex", "Bob","Charlie")
    for (i in 0..<names.size) {
        println("[$i] ${names[i]}")
    }
    // kotlin-way
    for (i in names.indices) {
        println("[$i] ${names[i]}")
    }
    // better kotlin-way
    for ((i, name) in names.withIndex()) {
        println("[$i] $name")
    }
    // most kotlin-way
    names.forEachIndexed{ i, name ->
        println("[$i] $name")
    }

    // for map
    val orders = mapOf(
        "a" to "abc",
        "b" to "bcd",
        "c" to "cde",
    )
    for ((k, v) in orders) {
        println("$k : $v")
    }
    orders.forEach { k, v ->
        println("$k : $v")
    }
}

fun calculateSumOfSquares(n: Int): Int {
    var res = 0
    for (i in 1..n) {
        res += i * i
    }
    return res
}

fun calculateSumOfEven(n: Int): Int {
    var res = 0
    for (i in 2..n step 2) {
        res += i
    }
    return res
}

fun countDownByStep(
    start: Int,
    end: Int,
    step: Int
): String {
    var res = ""
    for (i in start downTo end step step) {
        res += i
        if (i != end) {
            res += ", "
        }
    }
    return res
}

class LoopsTest {

    @Test
    fun testCalculateSumOfSquares() {
        assertEquals(1, calculateSumOfSquares(1))
        assertEquals(5, calculateSumOfSquares(2))
        assertEquals(14, calculateSumOfSquares(3))
        assertEquals(30, calculateSumOfSquares(4))
        assertEquals(385, calculateSumOfSquares(10))
        assertEquals(0, calculateSumOfSquares(0))
        assertEquals(0, calculateSumOfSquares(-1))
        assertEquals(0, calculateSumOfSquares(-1))
        assertEquals(0, calculateSumOfSquares(-3))
    }

    @Test
    fun testCalculateSumOfEven() {
        assertEquals(0, calculateSumOfEven(0))
        assertEquals(0, calculateSumOfEven(1))
        assertEquals(2, calculateSumOfEven(2))
        assertEquals(2, calculateSumOfEven(3))
        assertEquals(6, calculateSumOfEven(5))
        assertEquals(30, calculateSumOfEven(10))
        assertEquals(42, calculateSumOfEven(12))
        assertEquals(110, calculateSumOfEven(20))
        assertEquals(240, calculateSumOfEven(30))
        assertEquals(0, calculateSumOfEven(-1))
    }

    @Test
    fun testCountDownByStep() {
        assertEquals("1", countDownByStep(1, 1, 1))
        assertEquals("5, 3, 1", countDownByStep(5, 1, 2))
        assertEquals("10, 7, 4, 1", countDownByStep(10, 1, 3))
        assertEquals("15, 10, 5", countDownByStep(15, 5, 5))
        assertEquals("20, 17, 14, 11, 8, 5, 2", countDownByStep(20, 2, 3))
        assertEquals("10, 7, 4", countDownByStep(10, 4, 3))
        assertEquals("-1", countDownByStep(-1, -1, 1))
        assertEquals("-5, -7, -9", countDownByStep(-5, -9, 2))
        assertEquals("0", countDownByStep(0, 0, 1))
        assertEquals("0", countDownByStep(0, 0, 2))
    }
}