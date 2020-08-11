package com.juanmedina.ksge.platform

import kotlin.test.Test
import kotlin.test.assertTrue

internal class PlatformTest {
    @Test
    fun `we can get platform`() {
        val platform = getPlatformName()

        assertTrue(platform.isNotEmpty())
        assertTrue(platform.isNotBlank())
    }
}
