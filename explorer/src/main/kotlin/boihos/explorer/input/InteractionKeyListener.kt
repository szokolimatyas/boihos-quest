package boihos.explorer.input

import java.awt.event.KeyEvent
import java.awt.event.KeyListener

// I know, I know: pressing multiple keys breaks
class InteractionKeyListener: KeyListener {
    private var keyPressed: KeyEvent? = null

    override fun keyTyped(e: KeyEvent?) {
     //   TODO("Not yet implemented")
    }

    override fun keyPressed(e: KeyEvent?) {
        this.keyPressed = e
    }

    override fun keyReleased(e: KeyEvent?) {
        this.keyPressed = null
    }

    fun popPressedKeyEvent() : KeyEvent? {
        val ret = keyPressed
        keyPressed = null
        return ret
    }
}