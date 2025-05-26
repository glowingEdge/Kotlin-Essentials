fun main() {
    val a: A = A("", "")
    val b: A = A("", "")
    println(a)  // A@ + ref: ex) A@4f023edb
    a.printMe() // A@4f023edb

    // custom getter
    val c: A = A("", "")
    c.name = "abc"
    println(c.name) // ABC

    // custom setter
    val user = A("", "")
    user.name = "bob"
    user.name = " "
    user.name = ""
    println(user.name)  // BOB

    val user2 = A("first", "second")
    println(user2.fullName1)    // first second
    println(user2.fullName2)    // first second
    user2.lastName = "third"
    println(user2.fullName1)    // first third
    println(user2.fullName2)    // first second

    // property call timing
    val h2 = Holder()   // calculate v2
    println(h2.v1)  // calculate v1  99
    println(h2.v1)  // calculate v1  99
    println(h2.v2)  // 99
    println(h2.v2)  // 99

    // constructor
    val skipParam = MainConstructor("aa")
    println("${skipParam.name} ${skipParam.surname}")   // aa bbb

    // inner class
    val puppy = Puppy("Cookie")
//    val innerPuppy = puppy.InnerPuppy()   // impossible
    val innerPuppy = Puppy.InnerPuppy()
    val innerClassPuppy = puppy.InnerClassPuppy()
    innerClassPuppy.think()
}

class A (
    var firstName: String,
    var lastName: String,
){
    var name = ""
        get() = field.uppercase()
//        get() = name.uppercase()  // infinite loop - stack overflow
        set(value) {
            if (value.isNotBlank()) {
                field = value
            }
        }
    val fullName1: String
        get() = "$firstName $lastName"
    val fullName2: String = "$firstName $lastName"

    fun printMe() {
        println(this)
    }
}

class Holder {
    val v1: Int get() = calc("v1")
    val v2: Int = calc("v2")

    private fun calc(propertyName: String): Int {
        println("calculate $propertyName")
        return 99
    }
}

class MainConstructor(
    var name: String = "",
    var surname: String = "bbb",
)

class Puppy(val name: String) {
    class InnerPuppy() {
        fun think() {
            // cannot access 'name'
            println("inner puppy is thinking")
        }
    }

    inner class InnerClassPuppy() {
        fun think() {
            println("inner class puppy is thinking of $name")
        }
    }
}