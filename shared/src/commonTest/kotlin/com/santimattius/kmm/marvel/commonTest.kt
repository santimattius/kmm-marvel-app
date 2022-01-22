package com.santimattius.kmm.marvel

import kotlin.test.Test
import kotlin.test.assertTrue

class CommonSharedTest {

    @Test
    fun testExample() {
        assertTrue(Shared().title().contains("Hello"), "Check 'Hello' is mentioned")
    }
}