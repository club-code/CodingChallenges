package g

import org.clubcode.library.test.GenericTest
import org.junit.Test

class Test: GenericTest() {

    @Test
    fun testSample(){
        genericTest("/g/sample01.in", "/g/sample01.ans", ::main)
    }

    @Test
    fun test02(){
        genericTest("/g/test02.in", "/g/test02.ans", ::main)
    }

    @Test
    fun test03(){
        genericTest("/g/test03.in", "/g/test03.ans", ::main)
    }

    @Test
    fun test04(){
        genericTest("/g/test04.in", "/g/test04.ans", ::main)
    }

    @Test
    fun test05(){
        genericTest("/g/test05.in", "/g/test05.ans", ::main)
    }

    @Test
    fun test06(){
        genericTest("/g/test06.in", "/g/test06.ans", ::main)
    }

    @Test
    fun test07(){
        genericTest("/g/test07.in", "/g/test07.ans", ::main)
    }

    @Test
    fun test08(){
        genericTest("/g/test08.in", "/g/test08.ans", ::main)
    }

    @Test
    fun test09(){
        genericTest("/g/test09.in", "/g/test09.ans", ::main)
    }
}