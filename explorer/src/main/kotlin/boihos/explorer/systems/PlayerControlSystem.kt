package boihos.explorer.systems

import boihos.explorer.components.Input
import boihos.explorer.components.Player
import boihos.explorer.components.Position
import boihos.explorer.input.KeyPressManager
import com.github.quillraven.fleks.Entity
import com.github.quillraven.fleks.IteratingSystem
import com.github.quillraven.fleks.World.Companion.family
import com.github.quillraven.fleks.World.Companion.inject

//we can slow this system down
class PlayerControlSystem(
    private var keyPressManager: KeyPressManager = inject()
) : IteratingSystem ( family { all(Input, Position, Player)} ) {
    override fun onTickEntity(entity: Entity) {

        var dx = 0
        var dy = 0

        if(keyPressManager.isKeyPressed('w')) {
            dy = -1
        }
        if(keyPressManager.isKeyPressed('a')) {
            dx = -1
        }
        if(keyPressManager.isKeyPressed('s')) {
            dy = 1
        }
        if(keyPressManager.isKeyPressed('d')) {
            dx = 1
        }


        //todo bounds check etc
        entity.configure { it[Position].x += dx; it[Position].y += dy }
    }
}