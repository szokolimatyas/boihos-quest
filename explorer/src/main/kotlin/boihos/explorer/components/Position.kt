package boihos.explorer.components

import com.github.quillraven.fleks.Component
import com.github.quillraven.fleks.ComponentType

data class Position(
    var x: Int,
    var y: Int
) : Component<Position> {
    override fun type() = Position

    companion object: ComponentType<Position>()

}
