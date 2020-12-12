package exercise3

import org.clubcode.library.test.GenericTest
import org.junit.Test

class Test3 : GenericTest() {

    @Test
    fun testSample() {
        genericTest("/exercise3/sample.in", "/exercise3/sample.ans", ::main)
    }

}