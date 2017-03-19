package com.cucumberJunit.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cucumberJunit.util.SeleniumUtil;

public class Login {
	
	public static final String SIGNINTITLE="Gmail - Free Storage and Email from Google";
	public static final String SIGNIN_XPATH="//a[contains(text(),'Sign In')]";
	public static final String LOGINTITLE="Gmail";
	public static final String EMAIL_ID="Email";
	public static final String PASSWORD_ID="Passwd";
	public static final String SIGNINBUTTON_ID="signIn";
	
	public static void  loginToApplication(WebDriver driver,String userName,String password){
		if (userName!=null){
			SeleniumUtil.getWebElement(driver, By.id(EMAIL_ID)).sendKeys(userName);;
		}
		if (password!=null){
			SeleniumUtil.getWebElement(driver, By.id(PASSWORD_ID)).sendKeys(password);
		}
		
		SeleniumUtil.getWebElement(driver, By.id(SIGNINBUTTON_ID)).click();
	}
	
	public static boolean checkSigninTitle(WebDriver driver){
		 return SeleniumUtil.checkPageTitle(driver, SIGNINTITLE);
		
	}

}


