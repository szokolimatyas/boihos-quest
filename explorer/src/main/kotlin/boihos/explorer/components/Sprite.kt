package boihos.explorer.components

import com.github.quillraven.fleks.Component
import com.github.quillraven.fleks.ComponentType

data class Sprite(
    var char: Char
) : Component<Sprite> {
    override fun type() = Sprite

    companion object: ComponentType<Sprite>()

}
