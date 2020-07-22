package pages.functions;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.utils.CommonFunctions;

public class TalkyRoomCallPage {
	private CommonFunctions objCommonFunctions;
	private String inviteBtn = "//span[text()='Invite']";
	private String otherUserConfirmBtns = "//li/button";
	private String userNameTextField = "//input[@placeholder]";
	private String connectedUserNameList = "//li";
	
	public TalkyRoomCallPage(WebDriver driver) {
		objCommonFunctions = new CommonFunctions(driver);
	}

	public boolean isPageDisplayed() {
		if(objCommonFunctions.waitTillElementIsDisplayed(inviteBtn))
			return true;
		return false;
	}
	
	public boolean verifyOtherUserHasJoined() {
		if(objCommonFunctions.getWebElementsList(otherUserConfirmBtns)!=null)
			return true;
		return false;
	}
	
	public boolean setUserName(String userName) {
		if(objCommonFunctions.clearAndEnterValueInTextFeild(userNameTextField, userName))
			return true;
		return false;
	}
	
	public boolean verifyUserHasJoined(String username) {
		if(verifyOtherUserHasJoined()) {
			List<WebElement> webElementList = objCommonFunctions.getWebElementsList(connectedUserNameList);
			Iterator<WebElement> it = webElementList.iterator();
			while(it.hasNext()) 
				if(it.next().getText().equals(username))
					return true;
		}
		return false;
	}
}
