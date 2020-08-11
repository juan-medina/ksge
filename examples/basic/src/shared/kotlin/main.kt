
import com.juanmedina.kecs.dsl.entity
import com.juanmedina.kecs.system.System
import com.juanmedina.kecs.world.World
import com.juanmedina.ksge.components.Color
import com.juanmedina.ksge.components.Mouse
import com.juanmedina.ksge.components.Position
import com.juanmedina.ksge.components.Text
import com.juanmedina.ksge.game.Game

val myText = entity {
    +Position(100.0f, 100.0f)
    +Text("hello world", 60)
    +Color(255, 255, 255)
}

class MouseMoveSystem : System() {
    override fun update(delta: Float, total: Float, world: World) {
        val mouse = world.entity<Mouse>()
        myText.get<Text>().string = "mouse at ${mouse.get<Position>()}"
    }
}

fun main() {
    val game = Game(1920, 1080, "basic", Color.BLACK, Color.WHITE)

    game.world.add(myText)
    game.world.add(MouseMoveSystem())

    game.run()
}
