package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.Myaccountpage;
import testbase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	
	@Test(groups= {"sanity","Master"})
	
	public void verify_login() {
		
		logger.info("***Starting TC002_LoginTest***** ");
	     
		//HomePage
		
		HomePage hp=new HomePage(driver);
		hp.clickMyaccount();
		hp.clickLogin();
		//LoginPage
		LoginPage lp=new LoginPage(driver);
		
		lp.setEmail(p.getProperty("emailadress"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//Myaccountpage
		Myaccountpage macc=new Myaccountpage(driver);
		
		boolean targetpage=macc.isMyAccountPageExist();
		
		Assert.assertTrue(targetpage);
		logger.info("***Finished TC002_LoginTest ");
	}
	
}
