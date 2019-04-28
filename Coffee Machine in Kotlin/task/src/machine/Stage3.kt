package machine

fun main() {
    println("Write how many ml of water the coffee machine has:")
    val water = readLine()?.toInt()
    println("Write how many ml of milk the coffee machine has:")
    val milk = readLine()?.toInt()
    println("Write how many grams of coffee beans the coffee machine has:")
    val beans = readLine()?.toInt()
    println("Write how many cups of coffee you will need:")
    val cups = readLine()?.toInt()
    val cupsMax = canWeMakeIT(water, milk, beans)
    if (cupsMax > cups!!) {
        println("Yes, I can make that amount of coffee (and even ${cupsMax - cups} more than that)")
    } else if (cupsMax == cups) {
        println("Yes, I can make that amount of coffee ")
    } else {
        println("No, I can make only $cupsMax cups of coffee")
    }

}

fun canWeMakeIT(water: Int?, milk: Int?, beans: Int?): Int {
    val waterCups = water?.div(200)
    val milkCups = milk?.div(50)
    val beansNumber = beans?.div(15)
    return minOf(waterCups!!, milkCups!!, beansNumber!!)
}

//fun out() {
//    println("Write how many cups of coffee you will need: ")
//    val coffeeNumber = readLine()
//    coffeeNumber?.toInt()
//    println("For $coffeeNumber cups of coffee you will need:")
//    println("${coffeeNumber?.toInt()?.times(200)} ml of water")
//    println("${coffeeNumber?.toInt()?.times(50)} ml of milk")
//    println("${coffeeNumber?.toInt()?.times(15)} g of coffee beans")
//}