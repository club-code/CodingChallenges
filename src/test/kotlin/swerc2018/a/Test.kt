package swerc2018.a

import GenericTest
import org.junit.Test


class Test: GenericTest() {

    @Test
    fun testSample(){
        genericTest("/swerc2018/a/sample01.in", "/swerc2018/a/sample01.ans", ::main)
    }

    @Test
    fun testLarge01(){
        genericTest("/swerc2018/a/large01.in", "/swerc2018/a/large01.ans", ::main)
    }

    @Test
    fun testLarge02(){
        genericTest("/swerc2018/a/large02.in", "/swerc2018/a/large02.ans", ::main)
    }

    @Test
    fun testLarge03(){
        genericTest("/swerc2018/a/large03.in", "/swerc2018/a/large03.ans", ::main)
    }

    @Test
    fun testLimits01(){
        genericTest("/swerc2018/a/limits01.in", "/swerc2018/a/limits01.ans", ::main)
    }

    @Test
    fun testLimits02(){
        genericTest("/swerc2018/a/limits02.in", "/swerc2018/a/limits02.ans", ::main)
    }

    @Test
    fun testOne01(){
        genericTest("/swerc2018/a/one01.in", "/swerc2018/a/one01.ans", ::main)
    }

    @Test
    fun testPrimes01(){
        genericTest("/swerc2018/a/primes01.in", "/swerc2018/a/primes01.ans", ::main)
    }

}