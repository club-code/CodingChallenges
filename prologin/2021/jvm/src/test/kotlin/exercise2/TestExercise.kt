package exercise2

import org.clubcode.library.test.GenericTest
import org.junit.Test

class TestExercise : GenericTest() {

    @Test
    fun testSample() {
        genericTest("/exercise2/sample.in", "/exercise2/sample.ans", ::main)
    }

}