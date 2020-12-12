package a

import org.clubcode.library.test.GenericTest
import org.junit.Test

class Test: GenericTest() {

    @Test
    fun testSample(){
        genericTest("/a/sample01.in", "/a/sample01.ans", ::main)
    }

    @Test
    fun test01(){
        genericTest("/a/test1.in", "/a/test1.ans", ::main)
    }

    @Test
    fun test02(){
        genericTest("/a/test2.in", "/a/test2.ans", ::main)
    }

    @Test
    fun test03(){
        genericTest("/a/test3.in", "/a/test3.ans", ::main)
    }

    @Test
    fun test04(){
        genericTest("/a/test4.in", "/a/test4.ans", ::main)
    }

    @Test
    fun test05(){
        genericTest("/a/test5.in", "/a/test5.ans", ::main)
    }

    @Test
    fun test06(){
        genericTest("/a/test6.in", "/a/test6.ans", ::main)
    }

    @Test
    fun test07(){
        genericTest("/a/test7.in", "/a/test7.ans", ::main)
    }

    @Test
    fun test08(){
        genericTest("/a/test8.in", "/a/test8.ans", ::main)
    }

    @Test
    fun test09(){
        genericTest("/a/test9.in", "/a/test9.ans", ::main)
    }

    @Test
    fun test10(){
        genericTest("/a/test70.in", "/a/test70.ans", ::main)
    }


}