@file:Suppress("EXPERIMENTAL_API_USAGE")

package com.juanmedina.ksge.render

import com.juanmedina.ksge.components.Color
import com.juanmedina.ksge.components.Position
import com.juanmedina.ksge.components.Text
import kotlinx.cinterop.CValue
import kotlinx.cinterop.cValue
import kotlinx.cinterop.useContents
import raylib.BeginDrawing
import raylib.BeginMode2D
import raylib.Camera2D
import raylib.ClearBackground
import raylib.DrawText
import raylib.EndDrawing
import raylib.EndMode2D
import raylib.GetFPS
import raylib.GetMousePosition
import raylib.InitWindow
import raylib.SetTargetFPS
import raylib.WindowShouldClose

actual fun initRender(width: Int, height: Int, title: String) {
    InitWindow(width, height, title)
    SetTargetFPS(60)
}

actual fun beginFrame(clear: Color) {
    BeginDrawing()

    ClearBackground(clear.toRayColor())
}

actual fun endFrame() {
    EndDrawing()
}

actual fun begin2D(width: Int, height: Int) {
    val camera2D = cValue<Camera2D> {
        zoom = 1.0f
        rotation = 0.0f
        zoom = 1.0f
        offset.x = width / 2.0f
        offset.y = height / 2.0f
        target.x = 0.0f
        target.y = 0.0f
    }

    BeginMode2D(camera2D)
}

actual fun end2D() {
    EndMode2D()
}

actual fun drawText(pos: Position, text: Text, color: Color) {
    DrawText(text.string, pos.x.toInt(), pos.y.toInt(), text.size, color.toRayColor())
}

actual fun getMousePosition(): Position {
    val position = Position(0.0f, 0.0f)
    GetMousePosition().useContents {
        position.x = x
        position.y = y
    }
    return position
}

actual fun shouldClose(): Boolean {
    return WindowShouldClose()
}

actual fun getFPS() = GetFPS()

fun Color.toRayColor(): CValue<raylib.Color> = cValue {
    r = this@toRayColor.r.toUByte()
    g = this@toRayColor.g.toUByte()
    b = this@toRayColor.b.toUByte()
    a = this@toRayColor.a.toUByte()
}
