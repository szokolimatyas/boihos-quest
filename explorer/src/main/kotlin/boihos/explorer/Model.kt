package boihos.explorer

import boihos.explorer.components.Input
import boihos.explorer.components.Player
import boihos.explorer.components.Position
import boihos.explorer.components.Sprite
import boihos.explorer.display.GameScreen
import boihos.explorer.input.InteractionKeyListener
import boihos.explorer.systems.InputSystem
import boihos.explorer.systems.PlayerControlSystem
import boihos.explorer.systems.SpriteDisplaySystem
import boihos.explorer.systems.SpriteRefreshSystem
import com.github.quillraven.fleks.World
import com.github.quillraven.fleks.configureWorld

class Model(
    private var interactionKeyListener: InteractionKeyListener,
    private var gameScreen: GameScreen
) {
    private val world: World

    init {
        world = configureWorld {
            systems {
                add(InputSystem())
                add(PlayerControlSystem())
                add(SpriteRefreshSystem())
                add(SpriteDisplaySystem())
            }

            injectables {
                add(interactionKeyListener)
                add(gameScreen)
            }
        }
        world.entity {
            it += Player("boihos")
            it += Input(null)
            it += Position(5, 5)
            it += Sprite('@')
        }
        world.entity {
            it += Position(3, 3)
            it += Sprite('g')
        }
        world.entity {
            it += Position(9, 3)
            it += Sprite('O')
        }
    }

    fun step(deltaTime: Float) {
        world.update(deltaTime)
    }
}