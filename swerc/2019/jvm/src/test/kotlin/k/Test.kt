package k

import org.clubcode.library.test.GenericTest
import org.junit.Assert.assertEquals
import org.junit.Test

class Test: GenericTest() {


    @Test
    fun testHand01(){
        genericTest("/k/hand01.in", "/k/hand01.ans", ::main)
    }

    @Test
    fun testHand02(){
        genericTest("/k/hand02.in", "/k/hand02.ans", ::main)
    }

    @Test
    fun testHand03(){
        genericTest("/k/hand03.in", "/k/hand03.ans", ::main)
    }

    @Test
    fun testHand04(){
        genericTest("/k/hand04.in", "/k/hand04.ans", ::main)
    }

    @Test
    fun testSample(){
        genericTest("/k/sample01.in", "/k/sample01.ans", ::main)
    }

    @Test
    fun testSample2(){
        genericTest("/k/sample02.in", "/k/sample02.ans", ::main)
    }

    @Test
    fun test01(){
        genericTest("/k/test01.in", "/k/test01.ans", ::main)
    }

    @Test
    fun test02(){
        genericTest("/k/test02.in", "/k/test02.ans", ::main)
    }

    @Test
    fun test03(){
        genericTest("/k/test03.in", "/k/test03.ans", ::main)
    }

    @Test
    fun test04(){
        genericTest("/k/test04.in", "/k/test04.ans", ::main)
    }

    @Test
    fun test05(){
        genericTest("/k/test05.in", "/k/test05.ans", ::main)
    }

    @Test
    fun test06(){
        genericTest("/k/test06.in", "/k/test06.ans", ::main)
    }

    @Test
    fun test07(){
        genericTest("/k/test07.in", "/k/test07.ans", ::main)
    }

    @Test
    fun test08(){
        genericTest("/k/test08.in", "/k/test08.ans", ::main)
    }

}