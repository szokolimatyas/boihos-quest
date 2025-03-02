package boihos.quest.boihos.quest.combat.data

sealed interface Card {
    //whole stage state should be included instead
    fun getEffect(targetIndex: Int, enemies: List<Enemy>): Map<Enemy, List<Effect>>

}