package loginTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Product_details {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		loginBrowser test = new loginBrowser();
        WebDriver driver = test.getDriver("chrome");
        test.login(driver);
		
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40)); 
        WebElement Salesmodule = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[./div[text()='Sales']]"))); 
  	     Salesmodule.click(); 
  	      
  	     WebElement product_menu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-section='203' and text()='Products']")));
  	     product_menu.click();
  	
  	     WebElement product = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-section='204' and text()='Products']")));
  	     product.click();
  	     
   	     WebElement Product_search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search...']")));
         Product_search.click();
         Product_search.sendKeys("Product1#23");
         Product_search.sendKeys(Keys.ENTER);
         
         WebElement Product_select = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='o_content']//span[text()='Product1#23']")));
         Product_select.click();
         
      // Locate the element using XPath and extract the value
         WebElement qtyAvailableElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@name='qty_available']//span")));
         

         // Get the value from the span tag
         String qtyAvailableValue = qtyAvailableElement.getText();

         // Output the value for verification
         System.out.println("Available Quantity: " + qtyAvailableValue);
         
      // Locate the element containing the virtual available quantity value
         WebElement virtualAvailableElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@name='virtual_available']//span")));

         // Get the value from the span tag
         String virtualAvailableValue = virtualAvailableElement.getText();

         // Output the value for verification
         System.out.println("Forecasted Available Quantity: " + virtualAvailableValue);
         
         //more option clicking
         WebElement more_option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[span='More']")));
         more_option.click();
         
        // Wait until the elements are visible
         WebElement purchasedValueElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@name='purchased_product_qty']//span")));
        // Extract text values from the elements
         String purchasedValue = purchasedValueElement.getText();
        // Print the extracted values
         System.out.println("Purchased Value: " + purchasedValue);
      
         // Wait until the elements are visible
         WebElement soldValueElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@name='sales_count']//span")));
        // Extract text values from the elements
         String soldValue = soldValueElement.getText();
        // Print the extracted values
         System.out.println("Sold Value: " + soldValue);
         
         // Wait until the elements are visible
         WebElement minValueElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@name='reordering_min_qty']//span")));
        // Extract text values from the elements
         String minValue = minValueElement.getText();
        // Print the extracted values
         System.out.println("Minimum Value: " + minValue);
       
         
         // Wait until the elements are visible
         WebElement maxValueElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@name='reordering_max_qty']//span")));
        // Extract text values from the elements
         String maxValue = maxValueElement.getText();
        // Print the extracted values
         System.out.println("Maximum Value: " + maxValue);
 	}

}
