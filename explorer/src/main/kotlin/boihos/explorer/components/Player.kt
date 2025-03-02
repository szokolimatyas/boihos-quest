package boihos.explorer.components

import com.github.quillraven.fleks.Component
import com.github.quillraven.fleks.ComponentType

data class Player(
    var name: String
) : Component<Player> {
    override fun type() = Player

    companion object : ComponentType<Player>()

}
