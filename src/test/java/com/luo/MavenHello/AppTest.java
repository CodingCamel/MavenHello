package com.luo.MavenHello;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


import static org.easymock.EasyMock.*;
import org.easymock.*;
/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase 
{
    IStudent student;  
    App application;  
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        //•使用 EasyMock 生成 Mock 对象；  
        student=EasyMock.createMock(IStudent.class);  
        //设定 Mock 对象的预期行为和输出  
        EasyMock.expect(student.doMethod1()).andReturn("a").times(1);  
        EasyMock.expect(student.doMethod2()).andReturn("b").times(1);  
        EasyMock.expect(student.doMethod3()).andReturn("c").times(1);  
        //将 Mock 对象切换到 Replay 状态  
        EasyMock.replay(student);  
        //调用 Mock 对象方法进行单元测试  
        application=new App(student);  
        String getStr=application.doMethod();  
        //对 Mock 对象的行为进行验证  
        String cstr="abc";//正确的字符串  
        assertEquals(cstr, getStr);  
        EasyMock.verify(student);  
        assertTrue(true);


    }
}
