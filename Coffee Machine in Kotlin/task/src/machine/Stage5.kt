//package machine
//
//package machine
//
//var currentCash = 550
//var currentWater = 400
//var currentMilk = 540
//var currentBeans = 120
//var currentCups = 9
//var stayInLoop = true
//fun main() {
//
//    while(stayInLoop) {
//        printStatus()
//        println("Write action (buy, fill, take, remaining, exit):")
//        when (readLine().toString().toLowerCase()) {
//            "buy" -> buy()
//            "fill" -> fill()
//            "take" -> take()
//            "remaining" -> remainingItems()
//            "exit" -> exitLoop()
//            else -> return
//        }
//    }
//
//
//    printStatus()
//}
//
//fun buy() {
//    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu")
//    when (readLine()) {
//        "1" -> buyEspresso()
//        "2" -> buyLatte()
//        "3" -> buyCappuccino()
//        else -> return
//    }
//
//}
//
//fun printStatus() {
//    println("The coffee machine has:")
//    println("$currentWater of water")
//    println("$currentMilk of milk")
//    println("$currentBeans of coffee beans")
//    println("$currentCups of disposable cups")
//    println("$currentCash of money")
//}
//
//fun buyEspresso() {
//    val espresso = Espresso()
//    if (canWeMakeIT(espresso.water, 0, espresso.coffee)) {
//        currentBeans -= espresso.coffee
//        currentWater -= espresso.water
//        currentCash += espresso.cash
//        currentCups--
//        printSuccess()
//    }
//}
//
//fun buyLatte() {
//    val latte = Latte()
//    if (canWeMakeIT(latte.water, latte.milk, latte.coffee)) {
//        currentBeans -= latte.coffee
//        currentWater -= latte.water
//        currentMilk -= latte.milk
//        currentCash += latte.cash
//        currentCups--
//        printSuccess()
//    }
//}
//
//fun buyCappuccino() {
//    val cappuccino = Cappuccino()
//    if(canWeMakeIT(cappuccino.water, cappuccino.milk, cappuccino.coffee)) {
//        currentBeans -= cappuccino.coffee
//        currentMilk -= cappuccino.milk
//        currentWater -= cappuccino.water
//        currentCash += cappuccino.cash
//        currentCups--
//        printSuccess()
//    }
//}
//
//class Espresso {
//    val water: Int = 250
//    val coffee: Int = 16
//    val cash: Int = 4
//}
//
//class Latte {
//    val water: Int = 350
//    val milk: Int = 75
//    val coffee: Int = 20
//    val cash: Int = 7
//}
//
//class Cappuccino {
//    val water: Int = 200
//    val milk: Int = 100
//    val coffee: Int = 12
//    val cash: Int = 6
//}
//fun take() {
//    println("I gave you $$currentCash")
//    currentCash=0
//}
//
//fun fill() {
//    println("Write how many ml of water do you want to add:")
//    val waterAdd = readLine()?.toInt()
//    currentWater += waterAdd!!
//    println("Write how many ml of milk do you want to add:")
//    val milkAdd = readLine()?.toInt()
//    currentMilk += milkAdd!!
//    println("Write how many grams of coffee beans do you want to add:")
//    val addCoffee = readLine()?.toInt()
//    currentBeans += addCoffee!!
//    println("Write how many disposable cups of coffee do you want to add:")
//    val addCups = readLine()?.toInt()
//    currentCups += addCups!!
//}
//fun exitLoop() {
//    stayInLoop = false
//}
//fun remainingItems() {
//    printStatus()
//}
//fun canWeMakeIT(water : Int, milk: Int, coffee: Int) : Boolean{
//    if (water > currentWater) {
//        println("Not enough water")
//        return false
//    }
//    else if (milk > currentMilk) {
//        println("Not enough milk")
//        return false
//    }
//    else if (coffee > currentBeans) {
//        println("Not enough beans")
//        return false
//    }
//    else if(currentCups==0) {
//        println("Not enough cups")
//        return false
//    }
//    else {
//        return true
//    }
//}
//fun printSuccess() {
//    println("I have enough resources. Making you a coffee")
//}
//
