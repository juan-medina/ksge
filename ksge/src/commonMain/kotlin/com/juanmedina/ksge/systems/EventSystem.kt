package com.juanmedina.ksge.systems

import com.juanmedina.kecs.dsl.add
import com.juanmedina.kecs.system.System
import com.juanmedina.kecs.world.World
import com.juanmedina.ksge.components.GameStatus
import com.juanmedina.ksge.components.Mouse
import com.juanmedina.ksge.components.Position
import com.juanmedina.ksge.render.getMousePosition
import com.juanmedina.ksge.render.shouldClose

class EventSystem : System() {
    override fun update(delta: Float, total: Float, world: World) {
        if (shouldClose()) {
            world.entity<GameStatus>().set(GameStatus.Stopped)
        } else {
            if (!world.hasComponent<Mouse>()) {
                world.add {
                    +Mouse()
                    +Position(0f, 0f)
                }
            } else {
                world.entity<Mouse>().set(getMousePosition())
            }
        }
    }
}
