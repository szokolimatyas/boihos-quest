package boihos.explorer.input

import java.awt.event.KeyEvent
import java.awt.event.KeyListener

class KeyPressManager: KeyListener {
    private var pressedKeys: Set<Char> = HashSet()

    override fun keyTyped(e: KeyEvent?) {
     //   TODO("Not yet implemented")
    }

    override fun keyPressed(e: KeyEvent?) {
        e?.apply { pressedKeys += e.keyChar }
    }

    override fun keyReleased(e: KeyEvent?) {
        e?.apply { pressedKeys -= e.keyChar }
    }

    fun isDownThenPop(c: Char): Boolean {
        val contains = pressedKeys.contains(c)
        pressedKeys -= c
        return contains
    }

    fun isKeyPressed(c: Char) = pressedKeys.contains(c)
}