import com.juanmedina.ksge.platform.getPlatformName
import com.juanmedina.ksge.render.initRender
import com.juanmedina.ksge.render.loop

fun main() {
    println("Platform: ${getPlatformName()}")
    initRender(1920, 1080, "basic")
    loop {
    }
}
