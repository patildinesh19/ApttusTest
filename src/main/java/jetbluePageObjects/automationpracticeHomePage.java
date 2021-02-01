package jetbluePageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class automationpracticeHomePage 
{	public WebDriver driver;

	@FindBy(css="img.logo.img-responsive")
	private WebElement Logo;
	
	@FindBy(css="a.login")
	private WebElement Signinlink;
	
	@FindBy(css="div.cat-title + ul > li")
	private List<WebElement> Categories;
	
	@FindBy(css="a.account > span")
	private WebElement accountname;
	
	public automationpracticeHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement logoicon()
	{
		return Logo;
	}
	public WebElement signin_link()
	{
		return Signinlink;
	}
	public List<WebElement> type_of_Categories()
	{
		return Categories;
	}
	public WebElement verifyaccountname()
	{
		return accountname;
		
	}

	
}
