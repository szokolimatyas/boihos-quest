package boihos.explorer.display

import asciiPanel.AsciiPanel

class GameScreen(
    private val terminal: AsciiPanel
) : Screen {
    private var changeListener: ((AsciiPanel) -> Unit)? = null

    override fun clear() {
        terminal.clear()
    }

    override fun changeAt(char: Char, x: Int, y: Int) {
        terminal.write(char, x, y)
        changeListener?.invoke(terminal)
    }

    override fun registerChangeListener(listener: (AsciiPanel) -> Unit) {
        changeListener = listener
    }
}