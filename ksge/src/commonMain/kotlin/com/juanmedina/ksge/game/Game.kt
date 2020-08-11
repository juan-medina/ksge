package com.juanmedina.ksge.game

import com.juanmedina.kecs.dsl.add
import com.juanmedina.kecs.dsl.world
import com.juanmedina.ksge.components.Color
import com.juanmedina.ksge.components.GameStatus
import com.juanmedina.ksge.systems.EventSystem
import com.juanmedina.ksge.systems.RenderingSystem

class Game(
    private val width: Int,
    private val height: Int,
    private val title: String,
    private val clear: Color,
    private val text: Color
) {
    val world = world {
        +RenderingSystem(width, height, title, clear, text)
        +EventSystem()
    }

    fun run() {
        world.add {
            +GameStatus.Initializing
        }

        while (world.component<GameStatus>() != GameStatus.Stopped) {
            world.update()
        }
    }
}
