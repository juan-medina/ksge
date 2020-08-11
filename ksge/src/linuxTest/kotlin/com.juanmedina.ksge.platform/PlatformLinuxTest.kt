package com.juanmedina.ksge.platform

import kotlin.test.Test
import kotlin.test.assertEquals

internal class PlatformLinuxTest {
    @Test
    fun `we can get linux platform`() {
        val platform = getPlatformName()

        assertEquals("linuxX64", platform)
    }
}
