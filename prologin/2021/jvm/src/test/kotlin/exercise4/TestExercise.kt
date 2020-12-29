package exercise4

import org.clubcode.library.test.GenericTest
import org.junit.Test

class TestExercise : GenericTest() {

    @Test
    fun testSample() {
        genericTest("/exercise4/sample.in", "/exercise4/sample.ans", ::main)
    }

    @Test
    fun testSample2() {
        genericTest("/exercise4/sample2.in", "/exercise4/sample2.ans", ::main)
    }

    @Test
    fun testSampleNone() {
        genericTest("/exercise4/sampleNone.in", "/exercise4/sampleNone.ans", ::main)
    }

}