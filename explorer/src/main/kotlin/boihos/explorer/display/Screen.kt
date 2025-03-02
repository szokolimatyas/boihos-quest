package boihos.explorer.display

import asciiPanel.AsciiPanel

interface Screen {
    fun clear()

    fun changeAt(char: Char, x: Int, y: Int)

    fun registerChangeListener(listener: (AsciiPanel) -> Unit)
}