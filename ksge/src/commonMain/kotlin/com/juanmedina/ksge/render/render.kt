package com.juanmedina.ksge.render

import com.juanmedina.ksge.components.Color
import com.juanmedina.ksge.components.Position
import com.juanmedina.ksge.components.Text

expect fun initRender(width: Int, height: Int, title: String)

expect fun beginFrame(clear: Color)

expect fun endFrame()

expect fun begin2D(width: Int, height: Int)

expect fun end2D()

expect fun drawText(pos: Position, text: Text, color: Color)

expect fun getMousePosition(): Position

expect fun shouldClose(): Boolean

expect fun getFPS(): Int
