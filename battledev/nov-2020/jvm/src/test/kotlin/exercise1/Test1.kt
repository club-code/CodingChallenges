package exercise1

import org.clubcode.library.test.GenericTest
import org.junit.Test

class Test1 : GenericTest() {

    @Test
    fun testSample() {
        genericTest("/exercise1/sample.in", "/exercise1/sample.ans", ::main)
    }

}