package com.juanmedina.ksge.components

data class Color(val r: Int, val g: Int, val b: Int, val a: Int = 255) {
    companion object {
        val WHITE = Color(255, 255, 255, 255)
        val BLACK = Color(0, 0, 0, 255)
    }
}
