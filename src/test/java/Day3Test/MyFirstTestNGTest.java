package Day3Test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstTestNGTest {
		@Test(priority =1)
		public void login() {
			//Assert.assertTrue(false);
			System.out.println("User has loggedIn");
		}
		
		@Test(priority = 4)
		public void logout() {
			String s= "User has logged out";
			String e ="User has logged out";
			Assert.assertEquals(s, e);
		}
		@Test(priority = 2)
		public void createAccount(){
			System.out.println("Account has been created");
		}
		@Test(priority = 3)
		public void deleteAccount() {
			System.out.println("Account has been deleted");
		}
}
