package com.santimattius.kmm.marvel

import kotlin.test.Test
import kotlin.test.assertTrue

class IosGreetingTest {

    @Test
    fun testExample() {
        assertTrue(Shared().title().contains("iOS"), "Check iOS is mentioned")
    }
}