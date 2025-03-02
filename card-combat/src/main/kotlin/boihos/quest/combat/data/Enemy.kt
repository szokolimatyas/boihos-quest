package boihos.quest.boihos.quest.combat.data

class Enemy(
    private var health: Int,
) {
    //@doc Returns true if the enemy should be destroyed
    fun damage(amount: Int): Boolean {
        health -= amount;
        return health <= 0;
    }
}