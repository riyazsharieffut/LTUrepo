package pageobjectOfAssigment1;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonBasePage implements EcomBaseInterface{

	public WebDriver driver;
	
	//Data Members
	
		@FindBy(id="twotabsearchtextbox")
		private WebElement searchTextField;
		
		@FindBy(xpath="(//img[@class='s-image'])[1]")
		private WebElement selectItemLink;
		
		@FindBy(xpath="//*[@id=\"corePrice_desktop\"]/div/table/tbody/tr[2]/td[2]/span[1]/span[2]")
		private WebElement itemPrice;
		
		
		//Initializing the  Constructor
	    public AmazonBasePage(WebDriver driver)
	    {
	    	this.driver=driver;
	    	PageFactory.initElements(driver, this);
	    }
	   //---------------------------- 
		
	
	@Override
		public void search(String search) {
			
		searchTextField.sendKeys(search);
		searchTextField.sendKeys(Keys.ENTER);
		
		}
		
	@Override
		public void selectItem() {
		selectItemLink.click();
			
		}
		
	@Override
		public String fetchItemPrice() {
		return itemPrice.getText();
			
		}

		
		
}
