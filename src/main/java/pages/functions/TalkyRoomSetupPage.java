package pages.functions;

import org.openqa.selenium.WebDriver;

import framework.utils.CommonFunctions;

public class TalkyRoomSetupPage {

	private CommonFunctions objCommonFunctions;
	private String joinCallbtn = "//button[text()='Join Call']";
	private String allowCameraBtn = "//*[text()='Allow camera access']";
	private String allowMicrophoneBtn = "//*[text()='Allow microphone access']";

	public TalkyRoomSetupPage(WebDriver driver) {
		objCommonFunctions = new CommonFunctions(driver);
	}
	
	public boolean isPageDisplayed() {
		if(objCommonFunctions.waitTillElementIsDisplayed(joinCallbtn))
			return true;
		return false;
	}
	
	public boolean allowCameraAccess() {
		if(objCommonFunctions.waitTillElementIsDisplayed(allowCameraBtn))
			return true;
		return false;
	}
	
	public boolean allowMicrophoneAccess() {
		if(objCommonFunctions.waitTillElementIsDisplayed(allowMicrophoneBtn))
			return true;
		return false;
	}
	
	public boolean clickOnJoinCall() {
		if(objCommonFunctions.clickOnElement(joinCallbtn)) {
			return true;
		}
		return false;
	}
}
