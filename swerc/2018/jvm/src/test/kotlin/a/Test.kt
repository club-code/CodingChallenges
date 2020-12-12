package a

import org.clubcode.library.test.GenericTest
import org.junit.Test


class Test: GenericTest() {

    @Test
    fun testSample(){
        genericTest("/a/sample01.in", "/a/sample01.ans", ::main)
    }

    @Test
    fun testLarge01(){
        genericTest("/a/large01.in", "/a/large01.ans", ::main)
    }

    @Test
    fun testLarge02(){
        genericTest("/a/large02.in", "/a/large02.ans", ::main)
    }

    @Test
    fun testLarge03(){
        genericTest("/a/large03.in", "/a/large03.ans", ::main)
    }

    @Test
    fun testLimits01(){
        genericTest("/a/limits01.in", "/a/limits01.ans", ::main)
    }

    @Test
    fun testLimits02(){
        genericTest("/a/limits02.in", "/a/limits02.ans", ::main)
    }

    @Test
    fun testOne01(){
        genericTest("/a/one01.in", "/a/one01.ans", ::main)
    }

    @Test
    fun testPrimes01(){
        genericTest("/a/primes01.in", "/a/primes01.ans", ::main)
    }

}