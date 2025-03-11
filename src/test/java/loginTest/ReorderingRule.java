package loginTest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReorderingRule {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		loginBrowser test = new loginBrowser();
        WebDriver driver = test.getDriver("chrome");
        test.login(driver);

         //product creation
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); 
         WebElement Salesmodule = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[./div[text()='Sales']]"))); 
   	     Salesmodule.click(); 
   	      
   	     WebElement product_menu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-section='203' and text()='Products']")));
   	     product_menu.click();
   	
   	     WebElement product = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-section='204' and text()='Products']")));
   	     product.click();
   	     
   	     WebElement Product_search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search...']")));
         Product_search.click();
         Product_search.sendKeys("Scenario1_test product");
         Product_search.sendKeys(Keys.ENTER);
         
         WebElement Product_select = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='o_content']//span[text()='Product1#23']")));
         Product_select.click();
         
         
         //more option clicking
         WebElement more_option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[span='More']")));
         more_option.click();
         
         // XPaths for the two elements
         String divXpath = "//div[@name='nbr_reordering_rules']";
         String buttonXpath = "//button[contains(., 'Min:')]";

         // Find the div element (if it exists)
         List<WebElement> divElements = driver.findElements(By.xpath(divXpath));
         
         // Find the button element (if it exists)
         List<WebElement> buttonElements = driver.findElements(By.xpath(buttonXpath));

         // Check if either the div or button element exists and perform the action
         if (!divElements.isEmpty()) {
             // Element with div[@name='nbr_reordering_rules'] is present
             WebElement divElement = divElements.get(0);
             System.out.println("Div element found!");
             divElement.click();  // Perform the desired action, such as clicking
         } else if (!buttonElements.isEmpty()) {
             // Element with button[contains(., 'Min:')] is present
             WebElement buttonElement = buttonElements.get(0);
             System.out.println("Button element found!");
             buttonElement.click();  // Perform the desired action, such as clicking
         } else {
             // Neither element is present
             System.out.println("Neither element was found!");
         }
         
         WebElement newButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'New')]")));
         newButton.click();
         
         Thread.sleep(1000);
         WebElement minInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@name='product_min_qty']//input")));
         minInput.clear();
         minInput.sendKeys("0");

         // Trigger change event if necessary
         ((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new Event('change'));", minInput);

         WebElement maxInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@name='product_max_qty']//input")));
         maxInput.clear();
         maxInput.sendKeys("10");

         // Trigger change event if necessary
         ((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new Event('change'));", maxInput);

         // Wait for any JavaScript actions that might alter the values
         Thread.sleep(2000);

         // Ensure values are correct
         String minValue = minInput.getAttribute("value");
         String maxValue = maxInput.getAttribute("value");

         if (minValue.equals("0") && maxValue.equals("10")) {
             // Proceed to click the save button if values are as expected
             WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='button'and contains(text(), 'Save')]")));
             saveButton.click();
         } else {
             System.out.println("Values have been modified by the system. Trying again...");
             // Optionally retry or handle the situation further
             minInput.clear();
             minInput.sendKeys("0");

             // Trigger change event if necessary
             ((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new Event('change'));", minInput);

             WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='button'and contains(text(), 'Save')]")));
             saveButton.click();
             
         }
      

        

	}

}
