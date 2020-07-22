package assignment.test;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import framework.utils.CommonFunctions;
import junit.framework.Assert;
import pages.functions.TalkyPage;
import pages.functions.TalkyRoomCallPage;
import pages.functions.TalkyRoomSetupPage;

public class TestScript {
	WebDriver driver, driver1;
	CommonFunctions objCommonFunctions;

	@BeforeMethod
	public void beforeMethod(Method m) {
		this.driver = new CommonFunctions().initDriver();
		objCommonFunctions = new CommonFunctions(driver);
	}

	@Test
	public void verifyUsersConnectivity() {
		Assert.assertTrue(objCommonFunctions.launchEnv("https://talky.io"));

		TalkyPage objTalkyPage = new TalkyPage(driver);
		Assert.assertTrue(objTalkyPage.isPageDisplayed());
		Assert.assertTrue(objTalkyPage.enterRoomName("test0001"));
		Assert.assertTrue(objTalkyPage.clickOnStartChat());

		TalkyRoomSetupPage objTalkyRoomSetupPage = new TalkyRoomSetupPage(driver);
		Assert.assertTrue(objTalkyRoomSetupPage.isPageDisplayed());
		Assert.assertTrue(objTalkyRoomSetupPage.clickOnJoinCall());

		TalkyRoomCallPage objTalkyRoomCallPage = new TalkyRoomCallPage(driver);
		Assert.assertTrue(objTalkyRoomCallPage.isPageDisplayed());
		Assert.assertTrue(objTalkyRoomCallPage.setUserName("tester1"));

		driver1 = new CommonFunctions().initDriverIncognito();
		CommonFunctions objCommonFunctions1 = new CommonFunctions(driver1);

		Assert.assertTrue(objCommonFunctions1.launchEnv("https://talky.io"));

		objTalkyPage = new TalkyPage(driver1);
		Assert.assertTrue(objTalkyPage.isPageDisplayed());
		Assert.assertTrue(objTalkyPage.enterRoomName("test0001"));
		Assert.assertTrue(objTalkyPage.clickOnStartChat());

		objTalkyRoomSetupPage = new TalkyRoomSetupPage(driver1);
		Assert.assertTrue(objTalkyRoomSetupPage.isPageDisplayed());
		Assert.assertTrue(objTalkyRoomSetupPage.clickOnJoinCall());

		objTalkyRoomCallPage = new TalkyRoomCallPage(driver1);
		Assert.assertTrue(objTalkyRoomCallPage.isPageDisplayed());
		Assert.assertTrue(objTalkyRoomCallPage.verifyUserHasJoined("tester1"));

	}

	@AfterMethod
	public void afterMethod() {
		this.driver.close();
		this.driver1.close();
	}
}
