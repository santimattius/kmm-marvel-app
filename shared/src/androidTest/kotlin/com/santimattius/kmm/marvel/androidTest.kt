package com.santimattius.kmm.marvel

import org.junit.Assert.assertTrue
import org.junit.Test

class AndroidSharedTest {

    @Test
    fun testExample() {
        assertTrue("Check Android is mentioned", Shared().title().contains("Android"))
    }
}