package boihos.quest.boihos.quest.combat.data

//@doc Change something about the status of an enemy
sealed class Effect {
    data class Damage(val amount: Int): Effect()

    data class Heal(val amount: Int): Effect()

    data class DamageArmor(val amount: Int): Effect()

}