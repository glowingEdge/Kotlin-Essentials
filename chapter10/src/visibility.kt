open class A {
    public val a = 20
    private val ap = 30
    public fun b() {
        println(a)
    }
    private  fun bp() {
        println(ap)
    }
}

public val c = 20
private val cp = 30
public fun d() {}
private fun dp() {}

class B : A() {
    fun e() {
        println(a)
//        println(ap)   // error
        println(b())
//        println(bp()) // error
    }
}

fun main() {
    println(A().a)
    println(A().b())
    println(c)
    println(d())

//    println(A().ap)   // error
//    println(A().bp()) // error
    println(cp)
    println(dp())
}