package com.juanmedina.ksge.systems

import com.juanmedina.kecs.system.System
import com.juanmedina.kecs.world.World
import com.juanmedina.ksge.components.Color
import com.juanmedina.ksge.components.GameStatus
import com.juanmedina.ksge.components.Position
import com.juanmedina.ksge.components.Text
import com.juanmedina.ksge.render.begin2D
import com.juanmedina.ksge.render.beginFrame
import com.juanmedina.ksge.render.drawText
import com.juanmedina.ksge.render.end2D
import com.juanmedina.ksge.render.endFrame
import com.juanmedina.ksge.render.getFPS
import com.juanmedina.ksge.render.initRender

class RenderingSystem(
    private val width: Int,
    private val height: Int,
    private val title: String,
    private val clear: Color,
    private val text: Color
) : System() {
    private fun begin(world: World) {
        initRender(width, height, title)
        world.entity<GameStatus>().set(GameStatus.Running)
    }

    private fun frame(world: World) {
        beginFrame(clear)

        begin2D(width, height)
        end2D()

        drawTexts(world)
        drawFPS()

        endFrame()
    }

    @Suppress("UNUSED_PARAMETER")
    private fun end(world: World) {}

    override fun update(delta: Float, total: Float, world: World) {
        when (world.component<GameStatus>()) {
            GameStatus.Initializing -> begin(world)
            GameStatus.Running -> frame(world)
            GameStatus.Stopped -> end(world)
        }
    }

    private fun drawTexts(world: World) {
        world.triples<Position, Text, Color> { (pos, text, color) ->
            drawText(pos, text, color)
        }
    }

    private fun drawFPS() {
        drawText(Position(20f, 20f), Text("FPS ${getFPS()}", 20), text)
    }
}
