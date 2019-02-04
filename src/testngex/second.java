package testngex;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class second {

	
	
	
	@Test
	public void Test1()
	{
		Assert.assertEquals(false, true);
		System.out.println("Running Test1");
	}
	
	@Test
	public void Test2()
	{
		//Assert.assertEq;
		System.out.println("Running Test2");	
	}
	@Test
	public void Test3()
	{
		
	}
	
	@Test
	public void Test4()
	{
		
	}
	@Test
	public void Test5()
	{
		
	}
	
	@Test
	public void Test6()
	{
		
	}
	@Test
	public void Test7()
	{
		
	}
	
	@Test
	public void Test8()
	{
		
	}
	@Test
	public void Test9()
	{
		
	}
	
	@Test
	public void Test10(ITestContext c)
	{
		System.out.println("10 Running "+c.getHost());
	}
	
	
	@BeforeMethod
	public void before(Method method)
	{
		System.out.println("Before TestCase Name is ::"+method.getName());
	}
	
	
	@AfterMethod
	public void after(ITestResult result)
	{
		System.out.println("After TestCase Name is ::"+result.getMethod().getMethodName()+" "+result.getStatus());
		
	}
	
}
