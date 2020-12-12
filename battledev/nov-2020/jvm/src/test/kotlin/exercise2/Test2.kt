package exercise2

import org.clubcode.library.test.GenericTest
import org.junit.Test

class Test2 : GenericTest() {

    @Test
    fun testSample() {
        genericTest("/exercise2/sample.in", "/exercise2/sample.ans", ::main)
    }

    @Test
    fun testSample2() {
        genericTest("/exercise2/sample2.in", "/exercise2/sample2.ans", ::main)
    }

}