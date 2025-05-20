// Primitive types: 실제로는 모든 값이 객체이기 때문에 타입이 존재하진 않음.
// Numbers: Byte Short Int Long Float Double
// Boolean
// Char
// String

fun main() {
    // 다양한 타입 선언
    val numI = 42   // default: Int
    val numL1 = 42L // explicit: Long
    val numL2 = 123456789012345 // explicit: Long

    val numD = 3.14 // default: Double
    val numF1 = 55F // explicit: Float
    val numF2 = 3.14F   // explicit: Float


    // 명시적 선언
    val numB: Byte = 127
//    val numB2: Byte = 128  // overflow 방지에러 -> expected 'Byte', actual 'Int'
    val numS: Short = 32767
    val numL: Long = 123


    // 형변환 방법: 명시적으로 변환 함수 사용
    val b: Byte = 123
    val l: Long = 456
//    val i1: Long = b
//    val i2: Byte = l

    val i1: Long = b.toLong()
    val i2: Byte = l.toByte()


    // 큰 수에서의 밑줄
    val million = 1_000_000
    println(million)    //1000000


    // 진수
    val hexBytes = 0xA4_D6_FE_EE
    val hexBytes2 = 0xA4D6FEEE
    println(hexBytes)   // 2765553390
    println(hexBytes.equals(hexBytes2)) // true
    val binary = 0b1_111_111    // 127
    println(binary)


    // Number type - 숫자들의 상위 타입. 형변환 함수가 정의되어있음
    val numberI: Int = 123
    val numberB: Byte = 123
    val numberL: Long = 123L
    val n1: Number = numberI
    val n2: Number = numberB
    val n3: Number = numberL


    // 수 연산: + - * / %
    val int1 = 12
    val int2 = 34
    println(int1 + int2)
    println(int1 - int2)
    println(int1 * int2)
    println(int1 / int2)    // 0
    println(int1 / int2.toDouble())  // 0.35294117647058826

    var int3  = 0
    int3 += 5
    int3 -= 3
    int3 *= 2
    int3 /= 2
    println(int3)   // 2
    println(int3++) // 2
    println(int3)   // 3
    println(++int3) // 4


    // 비트 연산
    println(0b0101 and 0b0001)  // 0001 -> 1
    println(0b0101 or 0b1000)   // 1101 -> 13
    println(0b0101 shl 1)   // 1010 -> 10
    println(0b0101 shr 1)   // 0010 -> 2


    // Boolean 및 연산
    val b1: Boolean = true
    println(b1) // true
    print(true && true)
    print(true || false)
    print(!true)


    // 문자, 문자열
    println('A')
    println('A'.code)   // 65
    println('\u00A3')   // £

    val text1 = "ABC"
    println(text1)  // ABC
    val text2 = """"EFG""""
    println(text2)  // "EFG"
    val text3 = "Let\'s say:\nHooray"
    println(text3)

    val message = """
        |Hello,
        This is a Kotlin message.
        |    With some indentation.
    """.trimMargin()

    val cleaned = """
        Hello,
            This is a Kotlin message.
        With some indentation.
    """.trimIndent()
    println("---- trimMargin() ----")
    println(message)

    println("\n---- trimIndent() ----")
    println(cleaned)

    // template expression
    val name = "Cookie"
    val surname = "Depies"
    val age = 6
    val fullName = "$name ${surname.uppercase()} ($age)"
    println(fullName)   // Cookie Depies (6)

    // 문자열 연산 - 문자열 변환이 가능한 다른 타입도 가능. 항상 문자열 리턴
    var someText = "ABC"
    someText += true
    someText += 123
    println(someText)   // ABCtrue123
}