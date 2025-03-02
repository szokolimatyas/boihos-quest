package boihos.explorer.components

import com.github.quillraven.fleks.Component
import com.github.quillraven.fleks.ComponentType
import java.awt.event.KeyEvent

//this should be a marker instead, and we directly poll an input manager
data class Input(var key: KeyEvent?) : Component<Input> {
    override fun type() = Input
    companion object: ComponentType<Input>()
}
