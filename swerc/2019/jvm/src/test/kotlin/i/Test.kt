package i

import org.clubcode.library.test.GenericTest
import org.junit.Test


class Test: GenericTest() {

    @Test
    fun testSample(){
        genericTest("/i/sample01.in", "/i/sample01.ans", ::main)
    }

    @Test
    fun test00(){
        genericTest("/i/test00.in", "/i/test00.ans", ::main)
    }
    @Test
    fun test01(){
        genericTest("/i/test01.in", "/i/test01.ans", ::main)
    }

    @Test
    fun test02(){
        genericTest("/i/test02.in", "/i/test02.ans", ::main)
    }

    @Test
    fun test03(){
        genericTest("/i/test03.in", "/i/test03.ans", ::main)
    }

    @Test
    fun test04(){
        genericTest("/i/test04.in", "/i/test04.ans", ::main)
    }

    @Test
    fun test05(){
        genericTest("/i/test05.in", "/i/test05.ans", ::main)
    }

    @Test
    fun test06(){
        genericTest("/i/test06.in", "/i/test06.ans", ::main)
    }

    @Test
    fun test07(){
        genericTest("/i/test07.in", "/i/test07.ans", ::main)
    }

    @Test
    fun test08(){
        genericTest("/i/test08.in", "/i/test08.ans", ::main)
    }

    @Test
    fun test09(){
        genericTest("/i/test09.in", "/i/test09.ans", ::main)
    }

    @Test
    fun test10(){
        genericTest("/i/test10.in", "/i/test10.ans", ::main)
    }


}