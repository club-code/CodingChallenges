package exercise4

import org.clubcode.library.test.GenericTest
import org.junit.Test

class Test4 : GenericTest() {

    @Test
    fun testSample() {
        genericTest("/exercise4/sample.in", "/exercise4/sample.ans", ::main)
    }

}