package TestNg;

import org.testng.Assert;
import org.testng.annotations.*;


public class  TestNgTest {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before class TestNG");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After class TestNG");
    }

    @BeforeMethod
    public static void beforeMethod() {
        System.out.println("Before method TestNG");
    }

    @AfterMethod
    public static void afterMethod() {
        System.out.println("After method TestNG");
    }

//    @Test (expectedExceptions = ArithmeticException.class)
    @Test
    public void testNG() {
        System.out.println("test");
        Assert.assertEquals("Expected value", "expected res", "actual res");
    }




}
