package pages.functions;


import org.openqa.selenium.WebDriver;

import framework.utils.CommonFunctions;

public class TalkyPage {

	private CommonFunctions objCommonFunctions;
	private String startChatBtn = "//button[@type='submit']";
	private String chatNameTextBox = "//input[contains(@class,'create-room')]";

	public TalkyPage(WebDriver driver) {
		objCommonFunctions = new CommonFunctions(driver);
	}
	
	public boolean isPageDisplayed() {
		if(objCommonFunctions.waitTillElementIsDisplayed(startChatBtn))
			return true;
		return false;
	}
	
	public boolean enterRoomName(String roomName) {
		if(objCommonFunctions.clickAndEnterValueInTextFeild(chatNameTextBox, roomName))
			return true;
		return false;
	}
	
	public boolean clickOnStartChat() {
		if(objCommonFunctions.clickOnElement(startChatBtn))
			return true;
		return false;
	}
	
}
