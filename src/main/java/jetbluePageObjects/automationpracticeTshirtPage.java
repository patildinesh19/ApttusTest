package jetbluePageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class automationpracticeTshirtPage 
{
	public WebDriver driver;

	@FindBy(css="a.product-name")
	private List<WebElement> productlist;
	
	public automationpracticeTshirtPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public List<WebElement> productnmae()
	{
		return productlist;
	}
}
