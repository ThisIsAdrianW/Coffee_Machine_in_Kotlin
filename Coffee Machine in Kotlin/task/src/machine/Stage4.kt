package machine
var currentCash = 550
var currentWater = 1200
var currentMilk = 540
var currentBeans = 120
var currentCups = 9
fun main() {
    println("Write action (buy, fill, take):")
    val userPrompt = readLine()
}
fun buy () {
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: 3")
    when(readLine()?.toInt()) {
        1 -> buyEspresso()
        2 -> buyLatte()
        3 -> buyCappuccino()
    }
}
fun buyEspresso {
    val espresso = Espresso()
    currentBeans - espresso.coffee
    currentWater - espresso.water
    currentCash + espresso.cash
}
class Espresso () {
    val water : Int = 250
    val coffee : Int = 16
    val cash : Int = 4
}
class Latte () {
    val water : Int = 350
    val milk : Int = 75
    val coffee : Int = 25
    val cash : Int = 7
}
class Cappuccino {
    val water : Int = 200
    val milk : Int = 100
    val coffee : Int = 12
    val cash : Int = 6
}
