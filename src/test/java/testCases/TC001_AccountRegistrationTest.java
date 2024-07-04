package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.PageAccountregistration;
import testbase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	
	@Test(groups= {"Regression","Master"})
	public void verify_account_Registration() throws InterruptedException  {
		
		logger.info("****Starting TC001_AccountRegistrationTest****");
		logger.debug("This is the debug log message");
		try {
		HomePage hp=new HomePage(driver);
		
		hp.clickMyaccount();
		logger.info("clicked on my accunt log");
		
		hp.clickRegister();
		
		logger.info("Clicked on Register link");
		PageAccountregistration regpage=new PageAccountregistration(driver);
		
		logger.info("Providing customer details");
		
		regpage.setFirstname(randomString().toUpperCase());
		regpage.setLastname(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");
		regpage.setTelephone(randomNumber());
		
		String password=randomAlphaNumeric();
		
		regpage.setpassword(password);
		regpage.setConfirmPassword(password);
		
		
		regpage.setPrivacyPolicy();
		
		regpage.ClickContinue();
		
		logger.info("Validating confomation message");
		
		String confmsg=regpage.getConformationmsg();
		
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e) {
			
			logger.error("Test failed..");
			logger.debug("debug logs..");
	       Assert.fail();
	}
		logger.info("Finished TC001_AccountRegistrationTest ");
	}
	
	
	
	

}
