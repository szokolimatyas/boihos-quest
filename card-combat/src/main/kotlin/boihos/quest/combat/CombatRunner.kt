package boihos.quest.boihos.quest.combat

import boihos.quest.boihos.quest.combat.data.Stage
import boihos.quest.boihos.quest.combat.data.allCards
import java.util.*

class CombatRunner {
    fun run(): Unit {
        var newSimpleStage = Stage.newSimpleStage()
        val scanner = Scanner(System.`in`)
        val allCards = allCards()
        scanner.useDelimiter("\n");
        //ik, this is not final
        while (!newSimpleStage.enemies.isEmpty()) {
            val size = newSimpleStage.enemies.size
            newSimpleStage.playerCards = emptyList()
            for (i in 0 until size) {
                println("Select a card for enemy " + i)
                val selectedCard = scanner.nextInt()
                val card = allCards[selectedCard]
                newSimpleStage.playerCards += card
            }
        }
    }
}