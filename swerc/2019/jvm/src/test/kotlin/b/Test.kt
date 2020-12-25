package b

import org.clubcode.library.test.GenericTest
import org.junit.Test

class Test: GenericTest() {

    @Test
    fun testSample(){
        genericTest("/b/sample01.in", "/b/sample01.ans", ::main)
    }

    @Test
    fun testSample2(){
        genericTest("/b/sample02.in", "/b/sample02.ans", ::main)
    }

    @Test
    fun test01(){
        genericTest("/b/test01.in", "/b/test01.ans", ::main)
    }

    @Test
    fun test02(){
        genericTest("/b/test02.in", "/b/test02.ans", ::main)
    }

    @Test
    fun test03(){
        genericTest("/b/test03.in", "/b/test03.ans", ::main)
    }

    @Test
    fun test04(){
        genericTest("/b/test04.in", "/b/test04.ans", ::main)
    }

    @Test
    fun test05(){
        genericTest("/b/test05.in", "/b/test05.ans", ::main)
    }

    @Test
    fun test06(){
        genericTest("/b/test06.in", "/b/test06.ans", ::main)
    }

    @Test
    fun test07(){
        genericTest("/b/test07.in", "/b/test07.ans", ::main)
    }

    @Test
    fun test08(){
        genericTest("/b/test08.in", "/b/test08.ans", ::main)
    }

    @Test
    fun test09(){
        genericTest("/b/test09.in", "/b/test09.ans", ::main)
    }

    @Test
    fun test10(){
        genericTest("/b/test10.in", "/b/test10.ans", ::main)
    }

    @Test
    fun test11(){
        genericTest("/b/test11.in", "/b/test11.ans", ::main)
    }
}