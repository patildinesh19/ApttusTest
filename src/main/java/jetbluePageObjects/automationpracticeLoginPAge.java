package jetbluePageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class automationpracticeLoginPAge 
{
	public WebDriver driver;

	@FindBy(id="email")
	private WebElement usernameeditbox;
	
	@FindBy(id="passwd")
	private WebElement passwordeditbox;
	
	@FindBy(id="SubmitLogin")
	private WebElement loginbutton;
	
	public automationpracticeLoginPAge(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement username()
	{
		return usernameeditbox;
	}
	public WebElement password()
	{
		return passwordeditbox;
	}
	public WebElement submitbutton()
	{
		return loginbutton;
	}
}
