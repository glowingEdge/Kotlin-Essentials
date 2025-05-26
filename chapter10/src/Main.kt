fun main() {
    val dog = Dog()
    dog.makeVoice()
    println(dog.haveHairOrFur)
    dog.feedYoung()

    val mammal: Mammal = dog
    mammal.canFeed = true
    mammal.feedYoung()

    // override
    val cat = Cat()
    cat.feedYoung()
    // override with super. call
    val bordercollie = BorderCollie()
    dog.seeFriend()
    bordercollie.seeFriend()

    // override with super
    val alex = Alex()
    alex.cheer()
    val ben = Ben()
    ben.cheer()
}

// abstract는 반드시 상속해야만 객체 생성 가능
// 모두 open 되어 있음
abstract class Mammal() {
    val haveHairOrFur = true
    val warmBlood = true
    var canFeed = false

    abstract fun feedYoung()
}

open class Dog : Mammal() {
    fun makeVoice() {
        println("Bark Bark")
    }

    open fun seeFriend() {
        println("Wave its tail")
    }

    override fun feedYoung() {
        println("can feed with milk")
    }
}

class Cat : Mammal() {
    override fun feedYoung() {
        if (canFeed) {
            println("Feeding young with milk")
        } else {
            println("Feeding young with milk from bottle")
        }
    }
}

class BorderCollie : Dog() {
    override fun seeFriend() {
        super.seeFriend()
        println("Lie down")
    }
}

// multiple impl
interface Drinkable {
    val name: String
    fun Drink()
}

interface Spillable {
    fun Spill()
}

class Mug : Drinkable, Spillable {
    override var name = "default    "
    override fun Spill() {
        println("Ow, ow")
    }

    override fun Drink() {
        println("Umm")
    }
}

// override with super
interface NicePerson {
    fun cheer() {
        println("Hello")
    }
}

class Alex : NicePerson
class Ben : NicePerson {
    override fun cheer() {
        super.cheer()
        println("My name is Ben")
    }
}