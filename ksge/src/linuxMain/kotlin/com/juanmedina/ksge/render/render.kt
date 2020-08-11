package com.juanmedina.ksge.render

import kotlinx.cinterop.cValue
import raylib.BeginDrawing
import raylib.BeginMode2D
import raylib.Camera2D
import raylib.ClearBackground
import raylib.Color
import raylib.DrawText
import raylib.EndDrawing
import raylib.EndMode2D
import raylib.GetFPS
import raylib.InitWindow
import raylib.SetTargetFPS
import raylib.WindowShouldClose

actual fun initRender(width: Int, height: Int, title: String) {
    InitWindow(width, height, "test")
    SetTargetFPS(60)
}

actual fun loop(init: () -> Unit) {
    val background = cValue<Color> {
        r = 0u
        g = 0u
        b = 0u
        a = 255u
    }

    val foreground = cValue<Color> {
        r = 255u
        g = 255u
        b = 255u
        a = 255u
    }

    val camera2D = cValue<Camera2D> {
        zoom = 1.0f
        rotation = 0.0f
        zoom = 1.0f
        offset.x = 1920 / 2.0f
        offset.y = 1080 / 2.0f
        target.x = 0.0f
        target.y = 0.0f
    }

    while (!WindowShouldClose()) {
        BeginDrawing()
        ClearBackground(background)
        BeginMode2D(camera2D)
        init()
        EndMode2D()

        val fps = GetFPS()
        DrawText("FPS $fps", 20, 20, 20, foreground)
        EndDrawing()
    }
}
