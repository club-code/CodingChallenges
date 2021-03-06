@file:Suppress("EXPERIMENTAL_API_USAGE")
package a

import org.clubcode.library.test.GenericTest
import org.junit.Test

class TestExercise: GenericTest() {

    @Test
    fun testSample() {
        genericTest("/a/1.in", "/a/1.out", ::main)
    }

}