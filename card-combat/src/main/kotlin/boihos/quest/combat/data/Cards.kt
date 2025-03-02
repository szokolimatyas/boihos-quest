package boihos.quest.boihos.quest.combat.data

open class SimpleSword: Card {

    override fun getEffect(targetIndex: Int, enemies: List<Enemy>): Map<Enemy, List<Effect>> {
        assert(targetIndex < enemies.size)
        val target = enemies[targetIndex]
        return mapOf(target to listOf(Effect.Damage(-calculateDamage())))
    }

    protected fun calculateDamage(): Int = 4
}

open class Cleaver: Card {

    override fun getEffect(targetIndex: Int, enemies: List<Enemy>): Map<Enemy, List<Effect>> {
        assert(targetIndex < enemies.size && targetIndex >= 0)
        val start: Int = targetIndex - 1
        val end: Int = targetIndex + 1

        return buildMap {
            for ((index, enemy) in enemies.withIndex()) {
                if(index == targetIndex) {
                  put(enemy, listOf(Effect.Damage(-calculateDamage())))
                } else if(index in start..end) {
                    put(enemy, listOf(Effect.Damage(-calculateSideDamage())))
                }
            }
        }
    }

    protected fun calculateDamage(): Int = 2
    protected fun calculateSideDamage(): Int = 1

}