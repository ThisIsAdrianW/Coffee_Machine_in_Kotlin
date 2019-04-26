package machine

var currentCash = 550
var currentWater = 1200
var currentMilk = 540
var currentBeans = 120
var currentCups = 9
fun main() {
    printStatus()
    println("Write action (buy, fill, take):")
    val userPrompt = readLine().toString()
    when (userPrompt) {
        "buy" -> buy()
        "fill" -> fill()
        "take" -> take()
    }
    printStatus()
}

fun buy() {
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: 3")
    when (readLine()?.toInt()) {
        1 -> buyEspresso()
        2 -> buyLatte()
        3 -> buyCappuccino()
    }
    currentCups--
}

fun printStatus() {
    println("The coffee machine has:")
    println("$currentWater of water")
    println("$currentMilk of milk")
    println("$currentBeans of coffee beans")
    println("$currentCups of disposable cups")
    println("$currentCash of money")
}

fun buyEspresso() {
    val espresso = Espresso()
    currentBeans - espresso.coffee
    currentWater - espresso.water
    currentCash + espresso.cash
}

fun buyLatte() {
    val latte = Latte()
    currentBeans - latte.coffee
    currentWater - latte.water
    currentMilk - latte.milk
    currentCash + latte.cash
}

fun buyCappuccino() {
    val cappuccino = Cappuccino()
    currentBeans - cappuccino.coffee
    currentMilk - cappuccino.milk
    currentWater - cappuccino.water
    currentCash + cappuccino.cash
}

class Espresso {
    val water: Int = 250
    val coffee: Int = 16
    val cash: Int = 4
}

class Latte {
    val water: Int = 350
    val milk: Int = 75
    val coffee: Int = 25
    val cash: Int = 7
}

class Cappuccino {
    val water: Int = 200
    val milk: Int = 100
    val coffee: Int = 12
    val cash: Int = 6
}
fun take() {
    println("I gave you $" + "$currentCash")
    currentCash=0
}

fun fill() {
    println("Write how many ml of water do you want to add:")
    val waterAdd = readLine()?.toInt()
    currentWater + waterAdd!!
    println("Write how many ml of milk do you want to add:")
    val milkAdd = readLine()?.toInt()
    currentMilk + milkAdd!!
    println("Write how many grams of coffee beans do you want to add:")
    val addCoffee = readLine()?.toInt()
    currentBeans + addCoffee!!
    println("Write how many disposable cups of coffee do you want to add:")
    val addCups = readLine()?.toInt()
    currentCups + addCups!!
}
