package com.juanmedina.ksge.platform

import kotlin.test.Test
import kotlin.test.assertEquals

internal class PlatformMingwTest {
    @Test
    fun `we can get linux platform`() {
        val platform = getPlatformName()

        assertEquals("mingwX64", platform)
    }
}
