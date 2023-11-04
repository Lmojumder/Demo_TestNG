package Pkg_Extent;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.junit.Assert;
import org.testng.annotations.AfterTest;

public class NewTest_2 {
  @Test
  public void f() {
  }
  @BeforeTest
  public void BTest() {
	  System.out.println("beforeTest");
	  Assert.assertTrue(true);
  }

  @AfterTest
  public void ATest() {
	  System.out.println("afterTest");
	  Assert.assertTrue(true);
	  
  }

  @Test
  public void test1() {
	  System.out.println("test1");
	  Assert.assertTrue(false);
	  
  }
  
  
  @Test
  public void test2() {
	  System.out.println("test2");
	  Assert.assertTrue(false);
  }
  
  
  @Test
  public void test3() {
	  System.out.println("test3");
	  Assert.assertTrue(false);
  }
  
  
  
  @Test
  public void test4() {
	  System.out.println("test4");
	  Assert.assertTrue(false);
  }
  
  
  
}
