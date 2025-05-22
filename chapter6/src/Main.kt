import org.testng.AssertJUnit.assertEquals
import org.testng.annotations.Test
import kotlin.reflect.typeOf

fun main() {
    println(square(10.0))   // 100.0

    someFun(5)

    println(funReturnUnit())    // kotlin.Unit
    println(funReturnUnit() is Unit)
    println(funReturnUnit2())    // kotlin.Unit
    println(funReturnUnit3())    // kotlin.Unit
    println(funReturnUnit4())    // kotlin.Unit

    funVararg(1)
    funVararg(1,2,3,4,5)
    println(listOf(1,3,5))
    println(listOf("A", "AB", "ABC"))
    println(concatenate("A", "AB", "ABC"))

    val list1 = listOf(1,2,3,4)
    println(list1.joinToString())
    println(list1.joinToString(separator = "-"))
    println(list1.joinToString(limit = 2))

    // default argument
    funDefaultArg() // Hello1
    funDefaultArg("Hi, ")   // Hi, 1
    funDefaultArg(list = mutableListOf(1,2,3))  // Hello1, 2, 3, 1

    // function overloading
    fun ov(a: Any) = "Any"
    fun ov(a: Int) = "Int"
    fun ov(a: Long) = "Long"
//    fun ov(a: Int): Int {}    // 매개변수가 다른 경우에만 오버로딩
    println(ov("A"))    // Any
    println(ov(123))    // Int
    println(ov(10L))    // Long
}

// 단일 표현식이라도 리턴타입 명시하는게 가독성에 좋다.
fun square(x: Double): Double = x * x

fun someFun(i: Int) {
    println(i)  // 5
//    i = i + 10  // parameter is read-only
//    val i = i + 10  // possible, but bad way
//    println(i)  // 15
    val j = i + 10  // use different name
    println(j)
}

fun funReturnUnit() {}
fun funReturnUnit2(): Unit {}
fun funReturnUnit3(): Unit {
    return
}
fun funReturnUnit4(): Unit {
    return Unit
}
//fun funReturnUnit5(): Int {
//    return    // return Unit 과 같으므로 error
//}

fun funVararg(vararg params: Int) {}
fun concatenate(vararg strings: String): String {
    println(strings is String)   // false
    println(strings is Array<String>)   // true
    var accumulator = ""
    for (s in strings) accumulator += s
    return accumulator
}

// 기본값이 정적이지 않다. list와 같이 변경 가능한 값도 위험하지 않음
fun funDefaultArg(say: String = "Hello", list: MutableList<Int> = mutableListOf()) {
    list.add(1)
    println(say + list.joinToString())
}

fun formatPersonDisplay(
    name: String? = null,
    surname: String? = null,
    age: Int? = null,
): String {
    var ret = ""
    if (name != null) {
        ret += name
    }
    if (surname != null) {
        ret += " $surname"
    }
    if (age != null) {
        ret += " ($age)"
    }
    return ret.trim()
}

class PersonDisplayTest {
    @Test
    fun testFormatPersonDisplay() {
        val name = "John"
        val surname = "Smith"
        val age = 42
        val expected = "John Smith (42)"
        assertEquals(expected, formatPersonDisplay(name, surname, age))
    }

    @Test
    fun testFormatPersonDisplayWithoutAge() {
        val name = "Alex"
        val surname = "Simonson"
        val expected = "Alex Simonson"
        assertEquals(expected, formatPersonDisplay(name, surname))
    }

    @Test
    fun testFormatPersonDisplayWithoutSurname() {
        val name = "Peter"
        val age = 25
        val expected = "Peter (25)"
        assertEquals(expected, formatPersonDisplay(name = name, age = age))
    }

    @Test
    fun testFormatPersonDisplayWithoutName() {
        val surname = "Johnson"
        val age = 18
        val expected = "Johnson (18)"
        assertEquals(expected, formatPersonDisplay(surname = surname, age = age))
    }

    @Test
    fun testFormatPersonDisplayWithoutNameAndSurname() {
        val age = 18
        val expected = "(18)"
        assertEquals(expected, formatPersonDisplay(age = age))
    }

    @Test
    fun testFormatPersonDisplayWithoutParameters() {
        val expected = ""
        assertEquals(expected, formatPersonDisplay())
    }

    @Test
    fun testFormatPersonDisplayWithNullName() {
        val name: String? = null
        val surname = "Smith"
        val age = 42
        val expected = "Smith (42)"
        assertEquals(expected, formatPersonDisplay(name, surname, age))
    }

    @Test
    fun testFormatPersonDisplayWithNullSurname() {
        val name = "John"
        val surname: String? = null
        val age = 42
        val expected = "John (42)"
        assertEquals(expected, formatPersonDisplay(name, surname, age))
    }
}