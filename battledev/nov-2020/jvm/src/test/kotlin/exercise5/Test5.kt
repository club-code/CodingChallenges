package exercise5

import org.clubcode.library.test.GenericTest
import org.junit.Assert.assertEquals
import org.junit.Test

@kotlin.ExperimentalUnsignedTypes
class Test5: GenericTest() {

    @Test
    fun findFirstTest() {
        val result = findFirst()
        System.err.println(result)
        assertEquals(0u, result.toHash())
    }

    @Test
    fun testSample() {
//        genericTest("/exercise5/sample.in", "/exercise5/sample.ans", ::main)
    }

}