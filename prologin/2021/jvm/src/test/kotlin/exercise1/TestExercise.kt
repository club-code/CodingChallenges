package exercise1

import org.clubcode.library.test.GenericTest
import org.junit.Test

class TestExercise : GenericTest() {

    @Test
    fun testSample() {
        genericTest("/exercise1/sample.in", "/exercise1/sample.ans", ::main)
    }

    @Test
    fun testSample2() {
        genericTest("/exercise1/sample2.in", "/exercise1/sample2.ans", ::main)
    }

    @Test
    fun testSample3() {
        genericTest("/exercise1/sample3.in", "/exercise1/sample3.ans", ::main)
    }
}