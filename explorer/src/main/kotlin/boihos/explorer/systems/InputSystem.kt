package boihos.explorer.systems

import boihos.explorer.input.InteractionKeyListener
import boihos.explorer.components.Input
import com.github.quillraven.fleks.Entity
import com.github.quillraven.fleks.IteratingSystem
import com.github.quillraven.fleks.World.Companion.family
import com.github.quillraven.fleks.World.Companion.inject

//TBD make Input a simple, marker, and inject an inputManager instead
//actual good input handling, not this dummy code
class InputSystem(
    private val keyListener: InteractionKeyListener = inject()
): IteratingSystem( family { all(Input) }) {

    override fun onTickEntity(entity: Entity) {
        keyListener.popPressedKeyEvent()?.let { keyEvent ->
            entity.configure {
                it += Input(keyEvent)
            }
        }
    }

}