package jetblueScenarious;

import java.io.IOException;

import jetbluePageObjects.automationpracticeHomePage;
import jetbluePageObjects.automationpracticeLoginPAge;
import jetbluePageObjects.automationpracticeProductdetailsPage;
import jetbluePageObjects.automationpracticeTshirtPage;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Resources.Base;

public class Scenario1 extends Base
{	public WebDriver driver;
	@Test(priority = 0)
	public void launchautomationpractice() throws IOException
	{
			try 
			{
				driver=lunchapplication();
				driver.manage().window().maximize();
			}
			catch (NullPointerException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
	}
	@Test(priority = 1, dataProvider="Logindetails")
	public void loginintoautomationpractice(String usewrname, String password,String accountname) throws InterruptedException
	{
		// navigate to loginpage
		try
		{
		automationpracticeHomePage home= new automationpracticeHomePage(driver);
		home.signin_link().click();		
		automationpracticeLoginPAge login= new automationpracticeLoginPAge(driver);
		
		login.username().sendKeys(usewrname);
		login.password().sendKeys(password);
		login.submitbutton().click();
		Thread.sleep(1000);
		Assert.assertTrue(home.verifyaccountname().isDisplayed());
		}
		catch (NoSuchElementException e)
		{
			System.out.println("Element not found for login");
		}			
	}
	@DataProvider(name="Logindetails")
	public Object[][] gelogintdata()
	{
		return new Object[][] {{"jetblue@grr.la","jetblue","Dinesh patil"}};
	}
	
	@Test(priority = 2, dataProvider="category&productname")
	public void selectcategoryandproduct(String category, String productname)
	{	try
		{
			automationpracticeHomePage home= new automationpracticeHomePage(driver);
			for(int i=0;i<home.type_of_Categories().size();i++)
			{	System.out.println("category name"+home.type_of_Categories().get(i).getText());
				if(home.type_of_Categories().get(i).getText().equals(category))
				{
					home.type_of_Categories().get(i).click();
					break;
				}
			}
			automationpracticeTshirtPage tshirtproduct=new automationpracticeTshirtPage(driver);
			for(int i=0;i<tshirtproduct.productnmae().size();i++)
			{	System.out.println("Product name"+tshirtproduct.productnmae().get(i).getText());
				if(tshirtproduct.productnmae().get(i).getText().equals(productname))
				{
					tshirtproduct.productnmae().get(i).click();
					break;
				}
			}
		}
		catch (NoSuchElementException e)
		{
			System.out.println("Element not found for category selection");
		}	
	}
	@DataProvider(name="category&productname")
	public Object[][] getcategorydata()
	{
		return new Object[][] {{"T-SHIRTS", "Faded Short Sleeve T-shirts"}};
	}
	@Test(priority = 3)
	public void additemtocart()
	{	try
		{
			automationpracticeProductdetailsPage productdetails= new automationpracticeProductdetailsPage(driver);
			productdetails.addtocart().click();
		
		}
		catch (NoSuchElementException e)
		{
			System.out.println("Element not found on productdetailspage");
		}	
		
	}
	@Test(priority = 4, dataProvider="verifyaddedproductdetails")
	public void verifyaddtocardproduct(String verifymessage,String productname,String colour,String quantity,String Price) throws InterruptedException
	{
		try
		{
		automationpracticeProductdetailsPage productdetails = new automationpracticeProductdetailsPage(driver);
		Thread.sleep(2000);
		System.out.println("MESSAGE="+productdetails.vrifyproductaddedmessage().getText());
		//------------Verify Product Details--------------
		Assert.assertEquals(productdetails.vrifyproductaddedmessage().getText(), verifymessage);
		Assert.assertEquals(productdetails.verifyaddedproductname().getText(), productname);
		Assert.assertEquals(productdetails.verifyproductcolor().getText(), colour);
		Assert.assertEquals(productdetails.verifyproductquantity().getText(), quantity);
		Assert.assertEquals(productdetails.verifyproductprice().getText(), Price);
		
		//------Click on Checkout button----------
		productdetails.checkoutbutton().click();
		}
		catch (NoSuchElementException e)
		{
			System.out.println("Element not found on productdetailspage");
		}	
	}
	@DataProvider(name="verifyaddedproductdetails")
	public Object[][] verifyaddedproductdetails()
	{
		return new Object[][] {{"Product successfully added to your shopping cart","Faded Short Sleeve T-shirts", "Orange, S","1","$16.51"}};
	}
	
	@AfterTest
	public void quitebrowser()
	{
		driver.quit();
	}
}
