package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.Myaccountpage;
import testbase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="Datadriven")
	public void verify_loginDDT(String email,String pwd,String exp ) 
	{ logger.info("*starting DDtesting*");
		
		try {
		
		HomePage hp=new HomePage(driver);
		hp.clickMyaccount();
		hp.clickLogin();
		//LoginPage
		LoginPage lp=new LoginPage(driver);
		
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		//Myaccountpage
				Myaccountpage macc=new Myaccountpage(driver);
				
				boolean targetpage=macc.isMyAccountPageExist();
		
		if( exp.equalsIgnoreCase("Valid")) {
			
			if(targetpage==true) {
				macc.clickLogout();
				Assert.assertTrue(true);
				
			}
			
			else {
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid")) {
			if(targetpage==true) {
				
			macc.clickLogout();	
			Assert.assertTrue(false);
			}
		}else {
			Assert.assertTrue(true);
		}
		
		}catch(Exception e) {
			
			Assert.fail();
		}
		logger.info("* finished DD testing*");
		
	}
	
	
	
	

}
