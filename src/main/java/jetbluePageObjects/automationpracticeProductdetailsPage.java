package jetbluePageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class automationpracticeProductdetailsPage
{	public WebDriver driver;
	public WebDriverWait Wait;
	
	
	@FindBy(name="Submit")
	private WebElement addtocardbutton;
	
	@FindBy(css="span.cross + h2")
	private WebElement sucessmessage;

	@FindBy(id="layer_cart_product_title")
	private WebElement addedproductname;
	
	@FindBy(id="layer_cart_product_attributes")
	private WebElement productcolor;
	
	@FindBy(id="layer_cart_product_quantity")
	private WebElement productquantity;
	
	@FindBy(id="layer_cart_product_price")
	private WebElement productprice;
	
	@FindBy(css="a.btn.btn-default.button.button-medium")
	private WebElement checkoutbutton;
	public automationpracticeProductdetailsPage(WebDriver driver)
	{
		this.driver=driver;		
		PageFactory.initElements(driver, this);
	}
	public WebElement addtocart()
	{
		return addtocardbutton;
	}
	public WebElement vrifyproductaddedmessage()
	{
		return sucessmessage;
	}
	public WebElement verifyaddedproductname()
	{
		return addedproductname;
	}
	public WebElement verifyproductcolor()
	{
		return productcolor;
	}
	public WebElement verifyproductquantity()
	{
		return productquantity;
	}
	public WebElement verifyproductprice()
	{
		return productprice;
		
	}
	public WebElement checkoutbutton()
	{
		return checkoutbutton;
	}

}
