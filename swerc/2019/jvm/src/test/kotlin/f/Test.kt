package f

import org.clubcode.library.test.GenericTest
import org.junit.Test

class Test: GenericTest() {

    @Test
    fun testSample(){
        genericTest("/f/sample01.in", "/f/sample01.ans", ::main)
    }

    @Test
    fun testSample2(){
        genericTest("/f/sample02.in", "/f/sample02.ans", ::main)
    }

    @Test
    fun test1(){
        genericTest("/f/test1.in", "/f/test1.ans", ::main)
    }

    @Test
    fun test2(){
        genericTest("/f/test2.in", "/f/test2.ans", ::main)
    }

    @Test
    fun test3(){
        genericTest("/f/test3.in", "/f/test3.ans", ::main)
    }

    @Test
    fun test4(){
        genericTest("/f/test4.in", "/f/test4.ans", ::main)
    }

    @Test
    fun test5(){
        genericTest("/f/test5.in", "/f/test5.ans", ::main)
    }

    @Test
    fun test6(){
        genericTest("/f/test6.in", "/f/test6.ans", ::main)
    }

    @Test
    fun test7(){
        genericTest("/f/test7.in", "/f/test7.ans", ::main)
    }

    @Test
    fun test8(){
        genericTest("/f/test8.in", "/f/test8.ans", ::main)
    }

    @Test
    fun test9(){
        genericTest("/f/test9.in", "/f/test9.ans", ::main)
    }

    @Test
    fun test10(){
        genericTest("/f/test10.in", "/f/test10.ans", ::main)
    }

    @Test
    fun test11(){
        genericTest("/f/test11.in", "/f/test11.ans", ::main)
    }

    @Test
    fun test12(){
        genericTest("/f/test12.in", "/f/test12.ans", ::main)
    }

    @Test
    fun test13(){
        genericTest("/f/test13.in", "/f/test13.ans", ::main)
    }
}