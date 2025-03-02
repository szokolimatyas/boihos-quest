package boihos.explorer

import asciiPanel.AsciiPanel
import boihos.explorer.display.GameScreen
import boihos.explorer.display.Screen
import boihos.explorer.input.InteractionKeyListener
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
        applicationMain.step(10f)
        try {
            Thread.sleep(10)
        } catch (e: Exception) {
            isRunning = false
        }
    }
}

class ApplicationMain: JFrame() {
    private val screen: Screen
    private val interactionKeyListener = InteractionKeyListener()
    private val model: Model

    init {
        val terminal = AsciiPanel()
        terminal.setSize(40, 40)
        screen = GameScreen(terminal)
        screen.registerChangeListener { repaint() }
        addKeyListener(interactionKeyListener)
        add(terminal)
        model = Model(interactionKeyListener, screen)
        isResizable = false
        pack()
        repaint()
    }

    fun step(delta: Float) {
        model.step(delta)
    }
}