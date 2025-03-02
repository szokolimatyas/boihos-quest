package boihos.explorer.systems

import boihos.explorer.components.Position
import boihos.explorer.components.Sprite
import boihos.explorer.display.GameScreen
import com.github.quillraven.fleks.Entity
import com.github.quillraven.fleks.IteratingSystem
import com.github.quillraven.fleks.World.Companion.family
import com.github.quillraven.fleks.World.Companion.inject

class SpriteDisplaySystem(
    private var screen: GameScreen = inject()
) : IteratingSystem( family { all(Sprite, Position) } ) {
    override fun onTickEntity(entity: Entity) {
        screen.changeAt(entity[Sprite].char, entity[Position].x, entity[Position].y)
    }
}