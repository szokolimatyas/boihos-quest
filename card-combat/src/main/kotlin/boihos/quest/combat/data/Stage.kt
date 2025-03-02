package boihos.quest.boihos.quest.combat.data

class Stage(
    val enemies: List<Enemy>,
    var playerCards: List<Card>,
    val player: Player
) {
    companion object {
        fun newSimpleStage(): Stage =
            Stage(listOf(Enemy(5), Enemy(5), Enemy(5)), emptyList(), Player(30))
    }
}