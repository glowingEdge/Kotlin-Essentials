fun main() {
    val a = 10
    var b = "abc"
    println(a)  // 10
    println(b)  // abc
    //a = 12    // val 은 read-only
    //b = 123   // 형변환은 불가능
    b = "ABC"
    println(b)

    val valCamel: Int = 10
    var varCamel: String = "ABC"
    println(valCamel)
    println(varCamel)
    varCamel = "abc"
    println(varCamel)
}