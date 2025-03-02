package boihos.explorer

import asciiPanel.AsciiPanel
import boihos.explorer.display.GameScreen
import boihos.explorer.display.Screen
import boihos.explorer.input.KeyPressManager
import javax.swing.JFrame

//const val framesPerSecond = 60;
//const val timesPerLoop = 10000000000 / framesPerSecond

fun main() {
    val applicationMain = ApplicationMain()
    applicationMain.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    applicationMain.isVisible = true

    var isRunning = true
    //TODO i also think this might be blocking ui updates, game should run on a separate thread
    while (isRunning) {
        applicationMain.step(50f)
        try {
            Thread.sleep(50)
        } catch (e: Exception) {
            isRunning = false
        }
    }
}

class ApplicationMain: JFrame() {
    private val screen: Screen
    private val keyPressManager = KeyPressManager()
    private val model: Model

    init {
        val terminal = AsciiPanel()
        terminal.setSize(40, 40)
        screen = GameScreen(terminal)
        screen.registerChangeListener { repaint() }
        addKeyListener(keyPressManager)
        add(terminal)
        model = Model(keyPressManager, screen)
        isResizable = false
        pack()
        repaint()
    }

    fun step(delta: Float) {
        model.step(delta)
    }
}