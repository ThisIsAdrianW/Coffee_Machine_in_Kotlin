package machine

var stayInLoop = true
fun main() {
    var coffeStart = CoffeMaker()
    while (stayInLoop) {
        coffeStart.helloMessage()
        var input = readLine().toString().toLowerCase()
        coffeStart.setFunction(input)
    }
}

class Espresso {
    val water: Int = 250
    val coffee: Int = 16
    val cash: Int = 4
}

class Latte {
    val water: Int = 350
    val milk: Int = 75
    val coffee: Int = 20
    val cash: Int = 7
}

class Cappuccino {
    val water: Int = 200
    val milk: Int = 100
    val coffee: Int = 12
    val cash: Int = 6
}

fun exitLoop() {
    stayInLoop = false
}

enum class FillStatus {
    START, WATER, COFFEE, MILK, CUPS, BEANS;
}

enum class MachineState(val state: String) {
    START("start"),
    BUY("buy"),
    FILL("fill"),
    TAKE("take"),
    REMAINING("remaining"),
    EXIT("exit");

    companion object {
        fun from(findValue: String): MachineState = MachineState.values().first { it.state == findValue }
    }
}

class CoffeMaker() {
    private var currentCash = 550
    private var currentWater = 400
    private var currentMilk = 540
    private var currentBeans = 120
    private var currentCups = 9
    private var currentState = MachineState.START
    private var fillState = FillStatus.START
    fun setFunction(input: String) {
        when (input) {
            "buy" -> {
                buy()
                changeState(input)
            }
            "fill" -> {
                fill(input)
                changeState(input)
            }
            "take" -> {
                take()
                changeState(input)
            }
            "remaining" -> {
                remainingItems()
                changeState(input)
            }
            "exit" -> {
                exitLoop()
                changeState(input)
            }
            else -> {
                if (currentState == MachineState.BUY) {
                    when (input) {
                        "1" -> buyEspresso()
                        "2" -> buyLatte()
                        "3" -> buyCappuccino()
                        else -> return
                    }
                    currentState = MachineState.START
                } else if (currentState == MachineState.FILL) {
                    fill(input)
                }
            }
        }
    }

    private fun buyEspresso() {
        val espresso = Espresso()
        if (canWeMakeIT(espresso.water, 0, espresso.coffee)) {
            currentBeans -= espresso.coffee
            currentWater -= espresso.water
            currentCash += espresso.cash
            currentCups--
            printSuccess()
        }
    }

    private fun canWeMakeIT(water: Int, milk: Int, coffee: Int): Boolean {
        if (water > currentWater) {
            println("Not enough water")
            return false
        } else if (milk > currentMilk) {
            println("Not enough milk")
            return false
        } else if (coffee > currentBeans) {
            println("Not enough beans")
            return false
        } else if (currentCups == 0) {
            println("Not enough cups")
            return false
        } else {
            return true
        }
    }

    private fun buyLatte() {
        val latte = Latte()
        if (canWeMakeIT(latte.water, latte.milk, latte.coffee)) {
            currentBeans -= latte.coffee
            currentWater -= latte.water
            currentMilk -= latte.milk
            currentCash += latte.cash
            currentCups--
            printSuccess()
        }
    }

    private fun printSuccess() {
        println("I have enough resources. Making you a coffee")
    }

    private fun take() {
        println("I gave you $$currentCash")
        currentCash = 0
        currentState = MachineState.START
    }

    private fun fill(input: String) {
        if (fillState == FillStatus.START) {
            println("Write how many ml of water do you want to add:")
            fillState = FillStatus.WATER
        } else if (fillState == FillStatus.WATER) {
            currentWater += input.toInt()
            println("Write how many ml of milk do you want to add:")
            fillState = FillStatus.MILK
        } else if (fillState == FillStatus.MILK) {
            currentMilk += input.toInt()
            println("Write how many grams of coffee beans do you want to add:")
            fillState = FillStatus.BEANS
        } else if (fillState == FillStatus.BEANS) {
            currentBeans += input.toInt()
            println("Write how many disposable cups of coffee do you want to add:")
            fillState = FillStatus.CUPS
        } else if (fillState == FillStatus.CUPS) {
            currentCups += input.toInt()
            fillState = FillStatus.START
            currentState = MachineState.START
        }

    }

    private fun buyCappuccino() {
        val cappuccino = Cappuccino()
        if (canWeMakeIT(cappuccino.water, cappuccino.milk, cappuccino.coffee)) {
            currentBeans -= cappuccino.coffee
            currentMilk -= cappuccino.milk
            currentWater -= cappuccino.water
            currentCash += cappuccino.cash
            currentCups--
            printSuccess()
        }
    }

    private fun buy() {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu")
    }

    private fun remainingItems() {
        printStatus()
        currentState = MachineState.START
    }

    private fun changeState(input: String) {
        currentState = MachineState.from(input)
    }

    private fun printStatus() {
        println("The coffee machine has:")
        println("$currentWater of water")
        println("$currentMilk of milk")
        println("$currentBeans of coffee beans")
        println("$currentCups of disposable cups")
        println("$currentCash of money")
    }

    fun helloMessage() {
        if (currentState == MachineState.START) {
            println("Write action (buy, fill, take, remaining, exit):")
        }
    }
}



