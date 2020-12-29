package exercise5

import org.clubcode.library.test.GenericTest
import org.junit.Test

class TestExercise : GenericTest() {

    @Test
    fun testSample() {
        genericTest("/exercise5/sample.in", "/exercise5/sample.ans", ::main)
    }

    @Test
    fun testSample2() {
        genericTest("/exercise5/sample2.in", "/exercise5/sample2.ans", ::main)
    }

    @Test
    fun testSample3() {
        genericTest("/exercise5/sample3.in", "/exercise5/sample3.ans", ::main)
    }

    @Test
    fun tryMax() {
        genericTry("/exercise5/sampleMax.in", ::main)
    }

}