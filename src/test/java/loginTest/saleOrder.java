package loginTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class saleOrder {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		loginBrowser test2 = new loginBrowser();
        WebDriver driver = test2.getDriver("chrome");
        test2.login(driver);
	  
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40)); 
        WebElement Salesmodule = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[./div[text()='Sales']]"))); 
  	     Salesmodule.click();
  	     
  	    WebElement Order = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-hotkey='1']")));
  	    Order.click();
  	    WebElement Quotation = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Quotations']")));
  	    Quotation.click();
  	    WebElement new_Quotation = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-hotkey='c']")));
  	    new_Quotation.click();
  	    
  	    WebElement customer = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='partner_id_0']")));
  	    customer.click();
  	    WebElement customer_selection = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='AOQI MULTIMEDIA SDN BHD']")));
  	    customer_selection.click();
  	  
  	    Thread.sleep(2000);
        WebElement ATTN = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='attn_0']")));
        ATTN.click();
        WebElement ATTN_selection = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='AOQI MULTIMEDIA SDN BHD, KC Lee']")));
        ATTN_selection.click();
        
        WebElement expiration_date = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='validity_date_0']")));
        expiration_date.click();
        WebElement date_picker = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[span[text()='11']]")));
        date_picker.click();
        
        
        
  	     
  	     
  	     
  	     
  	     
  	     
  	     
  	     
  	     
  	     
  	     
  	     
  	     
  	     
  	     
  	     
  	     
  	     
  	     
  	     
  	     

		 
/*		 // quotation creation in lead
	     WebElement newQuotation = waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[span/text()='New Quotation']")));
	     newQuotation.click();
	     
	     //required fields in quotation
	  // Find all input fields inside divs with class 'o_required_modifier' (which indicates mandatory fields)
	     WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		 WebElement mandatoryFields = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'o_required_modifier')]//input")));
	     List<WebElement> requiredFields = driver.findElements(By.xpath("//div[contains(@class, 'o_required_modifier')]//input"));
	               
	     System.out.println("Total required fields: " + requiredFields.size());

	     for (WebElement field : requiredFields) {
	         String fieldName = field.getAttribute("id");
	         String fieldValue = field.getAttribute("value");

	         // Check if the field is filled or not
	         if (fieldValue == null || fieldValue.trim().isEmpty()) {
	             // If the field is empty, print the field name and send keys
	             System.out.println("Field " + fieldName + " is empty. Filling it with test data.");
	             
	             // Send keys to the field (you can modify this to send specific values)
	             field.sendKeys("Test Data for " + fieldName);
	         } else {
	             // If the field is filled, print the field name and its current value
	             System.out.println("Field " + fieldName + " is already filled with value: " + fieldValue);
	         }
	     }
		 //selecting products in quotation
	     
	     WebElement productLineItem = driver.findElement(By.xpath("//a[text()='Add a product']"));
	     productLineItem.click();
	     Thread.sleep(1000);
	     WebElement productList = driver.findElement(By.xpath("//input[@class='o-autocomplete--input o_input pe-3' and @placeholder='Search a product']"));
	     productList.click();
	     Thread.sleep(1000);
	     WebElement searchMoreProducts = driver.findElement(By.xpath("//*[@id=\"autocomplete_0_8\"and text()='Search More...']"));
	     searchMoreProducts.click();
	     Thread.sleep(1000);
	     
	     List<WebElement> productNames = driver.findElements(By.xpath("//tr[@class='o_data_row o_row_draggable']//td[@name='name']"));

	  // Ensure that there are products available
	  if (!productNames.isEmpty()) {
	      // Generate a random index to select a random product
	      Random rand = new Random();
	      int randomIndex = rand.nextInt(productNames.size());
	      
	      // Get the WebElement of the randomly selected product
	      WebElement randomProduct = productNames.get(randomIndex);
	      
	      // Print the selected product's name
	      System.out.println("Randomly selected product: " + randomProduct.getText());
	      
	      // Click on the selected product
	      randomProduct.click();
	  } else {
	      System.out.println("No products found.");
	  }
	     
	     
	*/	 
		 
		 
		 
	}
	
	
	



		
	
		
		
		
		
		
		
	}


