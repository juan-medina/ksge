package com.juanmedina.ksge.render

expect fun initRender(width: Int, height: Int, title: String)

expect fun loop(init: () -> Unit)
