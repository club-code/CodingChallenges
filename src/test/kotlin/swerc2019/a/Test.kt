package swerc2019.a

import GenericTest
import org.junit.Test

class Test: GenericTest() {

    @Test
    fun testSample(){
        genericTest("/swerc2019/a/sample01.in", "/swerc2019/a/sample01.ans", ::main)
    }

    @Test
    fun test01(){
        genericTest("/swerc2019/a/test1.in", "/swerc2019/a/test1.ans", ::main)
    }

    @Test
    fun test02(){
        genericTest("/swerc2019/a/test2.in", "/swerc2019/a/test2.ans", ::main)
    }

    @Test
    fun test03(){
        genericTest("/swerc2019/a/test3.in", "/swerc2019/a/test3.ans", ::main)
    }

    @Test
    fun test04(){
        genericTest("/swerc2019/a/test4.in", "/swerc2019/a/test4.ans", ::main)
    }

    @Test
    fun test05(){
        genericTest("/swerc2019/a/test5.in", "/swerc2019/a/test5.ans", ::main)
    }

    @Test
    fun test06(){
        genericTest("/swerc2019/a/test6.in", "/swerc2019/a/test6.ans", ::main)
    }

    @Test
    fun test07(){
        genericTest("/swerc2019/a/test7.in", "/swerc2019/a/test7.ans", ::main)
    }

    @Test
    fun test08(){
        genericTest("/swerc2019/a/test8.in", "/swerc2019/a/test8.ans", ::main)
    }

    @Test
    fun test09(){
        genericTest("/swerc2019/a/test9.in", "/swerc2019/a/test9.ans", ::main)
    }

    @Test
    fun test10(){
        genericTest("/swerc2019/a/test70.in", "/swerc2019/a/test70.ans", ::main)
    }


}