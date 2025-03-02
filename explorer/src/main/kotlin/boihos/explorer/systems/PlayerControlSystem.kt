package boihos.explorer.systems

import boihos.explorer.components.Input
import boihos.explorer.components.Player
import boihos.explorer.components.Position
import com.github.quillraven.fleks.Entity
import com.github.quillraven.fleks.IteratingSystem
import com.github.quillraven.fleks.World.Companion.family

class PlayerControlSystem : IteratingSystem ( family { all(Input, Position, Player)} ) {
    override fun onTickEntity(entity: Entity) {
        val key = entity[Input].key ?: return

        var dx = 0
        var dy = 0

        when (key.keyChar) {
            'w' -> { dy = -1}
            'a' -> { dx = -1}
            's' -> { dy = 1}
            'd' -> { dx = 1}
            else -> return
        }
        //todo bounds check etc
        entity.configure { it[Position].x += dx; it[Position].y += dy; it[Input].key = null }
    }
}