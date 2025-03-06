package loginTest;

import java.time.Duration;
import java.util.List;

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
		loginBrowser test = new loginBrowser();
        WebDriver driver = test.getDriver("chrome");
        test.login(driver);

         //product creation
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40)); 
         WebElement Salesmodule = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[./div[text()='Sales']]"))); 
   	     Salesmodule.click(); 
   	      
   	     WebElement product_menu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-section='203' and text()='Products']")));
   	     product_menu.click();
   	
   	     WebElement product = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-section='204' and text()='Products']")));
   	     product.click();
   	
   	     
   	     WebElement New = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' New ']")));
   	     New.click();
   	     
   	     Thread.sleep(1000);
   	  WebElement product_name = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@id='name_0']")));
      product_name.sendKeys("Product#23");
	     
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
      
   // enabling TRack Inventory
      WebElement inventory_track = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='o-checkbox form-check d-inline-block'])[3]")));
      inventory_track.click();
  
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
      WebElement productCategory_selection = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='All / Saleable / Adhesive UOM in grm']")));
      productCategory_selection.click();
      
      WebElement reference = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='default_code_0']")));
      reference.sendKeys("Product#23");
      
      WebElement description = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='x_studio_field_mHzKJ_0']")));
      description.sendKeys("Test Product Description");
      
      WebElement supplier_PartNum = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='x_studio_field_qr3ai_0']")));
      supplier_PartNum.sendKeys("Supplier Part Number");
      
      WebElement Manufacturer_name = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='manufacturer_id_0']")));
      Manufacturer_name.click();
      WebElement Manufacturer_selection = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='ABB Controls Inc']")));
      Manufacturer_selection.click();
      
      //purchase tab
      WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(40));
      WebElement purchase_tab = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@name='purchase']")));
      purchase_tab.click();
      WebElement addLine = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Add a line']")));
      addLine.click();
      WebElement sequence = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@name='sequence' and contains(@class, 'o_field_widget') and contains(@class, 'o_field_False')]/input[@inputmode='numeric' and @class='o_input' and @autocomplete='off' and @type='text']")));
      sequence.clear();
      sequence.sendKeys("01");
      
      WebElement vendor = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@name='partner_id']")));
      vendor.click();
      Thread.sleep(2000);
      WebElement vendor_selection = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='AOQI MULTIMEDIA SDN BHD']")));
      vendor_selection.click();
      
      WebElement quantity = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@name='min_qty']/div[@name='min_qty']/input[@inputmode='decimal' and @class='o_input' and @autocomplete='off' and @type='text']")));
      quantity.clear();
      quantity.sendKeys("0");
      
      WebElement price = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@name='price' and @class='o_field_widget o_required_modifier o_field_float']/input[@inputmode='decimal' and @class='o_input' and @autocomplete='off' and @type='text']")));
      price.clear();
      price.sendKeys("25");
      
      WebElement currency = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@name='currency_id']//div[@class='o_field_widget o_required_modifier o_field_many2one']//div[@class='o_field_many2one_selection']//div[@class='o_input_dropdown']//div[@class='o-autocomplete dropdown']/input[@class='o-autocomplete--input o_input pe-3' and @type='text' and @aria-expanded='false']")));
      currency.click();
      Thread.sleep(2000);
      WebElement currency_selection = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='autocomplete_0_4']")));
      currency_selection.click();
      
      //inventory tab
      WebElement inventory = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@name='inventory' and text()='Inventory']")));
      inventory.click();
      Thread.sleep(2000);
      // Call the route function for both checkboxes
      selectCheckboxByLabel(driver, "PKS - Buy from Vendor");
     //selectCheckboxByLabel(driver, "Manufacture in PKS");
      
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

//Function to select a Route checkbox based on label text
public static void selectCheckboxByLabel(WebDriver driver, String labelText) {
 WebElement checkbox = driver.findElement(By.xpath("//label[text()='" + labelText + "']/preceding-sibling::input[@type='checkbox']"));
 if (!checkbox.isSelected()) {
     checkbox.click();  // Select the checkbox if it's not already selected
 }
}



}






















