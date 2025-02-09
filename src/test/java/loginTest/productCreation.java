package loginTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class productCreation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
        
		// Create an instance of loginBrowser
        loginBrowser browserFactory = new loginBrowser();
        
        // Set the browser you want to use (can be passed dynamically as needed)
        String browser = "chrome"; // You can change this to "firefox" or "edge" as well
        
        // Get the WebDriver for the selected browser
        WebDriver driver = browserFactory.getDriver(browser);
     // Perform login actions here
        driver.get("http://8.217.119.29:8069/odoo/contacts/new");
        
        // Print a message
        System.out.println("Application Opened");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@href='/odoo?db=Peckochina_v18_testing']")).click();
               	    
        // Wait for the login fields to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40)); 
        //Thread.sleep(2000);
            
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='login']")));// Replace with actual element ID
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='password']")));// Replace with actual element ID
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Log in']")));  // Replace with actual XPath if necessary

        // Enter credentials
        usernameField.sendKeys("admin");
        passwordField.sendKeys("@dminstage");
        // Click the login button
         loginButton.click();
         System.out.println("Login successful");
		
         
         //product creation
         WebElement Salesmodule = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[./div[text()='Sales']]"))); 
   	    Salesmodule.click(); 
   	      
   	     WebElement product_menu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-section='203' and text()='Products']")));
   	     product_menu.click();
   	
   	     WebElement product = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-section='204' and text()='Products']")));
   	     product.click();
   	
   	     
   	     WebElement New = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' New ']")));
   	     New.click();
   	     
   	     Thread.sleep(1000);
   	  WebElement Data1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@id='name_0']")));
      Data1.sendKeys("spare parts");
	     
   // Wait for Sales checkbox and check its state
      WebElement saleCheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sale_ok_0")));
      if (saleCheckbox.isSelected()) {
          System.out.println("Sales checkbox is already checked.");
      } else {
          System.out.println("Sales checkbox is not checked. Enabling...");
          new Actions(driver).moveToElement(saleCheckbox).click().perform();  // Click to select the checkbox
      }
      
   // Select the radio button dynamically by value for Product type
      selectRadioButton(driver, "consu");  // Example: Select "consu", "services", "combo"
   // Optionally, verify the selection of Product type
      verifyRadioButtonSelection(driver, "consu");

   // Locate the dropdown by ID for  Invisible policy
      WebElement dropdown = driver.findElement(By.id("invoice_policy_0"));
   // Create a Select object to interact with the dropdown
      Select select = new Select(dropdown);
   // 1. Select by Visible Text
      select.selectByVisibleText("Ordered quantities"); //Example: Select "Delivered quantities", "Ordered quantities"
      
      WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));


      WebElement item_Text = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"item_text_0\"]")));
      item_Text.sendKeys("Customer Part Number");
      WebElement customer_partNumber = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"customer_part_number_0\"]")));
      customer_partNumber.sendKeys("Customer Part Number");
      WebElement salesPrice = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='list_price_0']")));
      salesPrice.clear();
      salesPrice.sendKeys("13.0000");
      
   // 1. Locate the input field and click to open the dropdown
      WebElement uom = driver.findElement(By.xpath("//input[@id='uom_id_0']"));
      uom.click();
    // 2. Select the desired option (for example, selecting "gm")
      WebElement uom_selection = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='gm']")));
      uom_selection.click();
      
      WebElement salesTaxes = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='taxes_id_0']")));
      salesTaxes.sendKeys(Keys.BACK_SPACE);
      salesTaxes.click();
      WebElement salesTax_selection = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"taxes_id_0_0_0\"]")));
      salesTax_selection.click();
      
      WebElement Cost = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='standard_price_0']")));
      Cost.clear();
      Cost.sendKeys("20.000");
      
      WebElement purchaseTaxes = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='supplier_taxes_id_0']")));
      purchaseTaxes.sendKeys(Keys.BACK_SPACE);
      purchaseTaxes.click();
      WebElement purchaseTaxes_selection = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='supplier_taxes_id_0_0_0']")));
      purchaseTaxes_selection.click();
      
   
      WebElement productCategory = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='categ_id_0']")));
      productCategory.sendKeys(Keys.BACK_SPACE);
      productCategory.click();
      WebElement productCategory_selection = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"categ_id_0_0_1\"]")));
      productCategory_selection.click();
      
      WebElement reference = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='default_code_0']")));
      reference.sendKeys("REF123");
      
      WebElement description = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='x_studio_field_mHzKJ_0']")));
      description.sendKeys("Test Product Description");
      
      WebElement supplier_PartNum = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='x_studio_field_qr3ai_0']")));
      supplier_PartNum.sendKeys("Supplier Part Number");
      
      WebElement Manufacturer_name = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='manufacturer_id_0']")));
      Manufacturer_name.click();
      WebElement Manufacturer_selection = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='ABB Controls Inc']")));
      Manufacturer_selection.click();
      
      //Save the product 
      WebElement save_product = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Save manually']")));
      save_product.click();
   
      
      
      
      
      
      
      
      
      
      
         
       	}



//Method to select a radio button for Product Type
public static void selectRadioButton(WebDriver driver, String option) {
    WebElement radioButton = driver.findElement(By.xpath("//input[@type='radio' and @data-value='" + option + "']"));
    if (!radioButton.isSelected()) {
        radioButton.click();  // Click the radio button if it's not selected
    }
}

// Method to verify which radio button is selected for Product type
public static void verifyRadioButtonSelection(WebDriver driver, String option) {
    WebElement radioButton = driver.findElement(By.xpath("//input[@type='radio' and @data-value='" + option + "']"));
    if (radioButton.isSelected()) {
        System.out.println(option + " radio button is selected");
    } else {
        System.out.println(option + " radio button is not selected");
    }
}

}






















