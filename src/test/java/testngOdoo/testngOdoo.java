package testngOdoo;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Test;


import loginTest.loginBrowser;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class testngOdoo {
	
	WebDriver driver;
    loginBrowser test = new loginBrowser();

    @BeforeMethod
    public void setUp() {
        // Setup WebDriver for Chrome
        driver = test.getDriver("chrome");
        test.login(driver);
    }

    @Test
	public void testProductCreation() throws InterruptedException {
        // Wait for Sales module and click
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement Salesmodule = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[./div[text()='Sales']]")));
        Salesmodule.click();

        // Click on Product menu
        WebElement product_menu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-section='203' and text()='Products']")));
        product_menu.click();
        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-section='204' and text()='Products']")));
        product.click();

        // Click New to create a new product
        WebElement New = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' New ']")));
        New.click();

        // Enter Product Name
        WebElement product_name = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@id='name_0']")));
        product_name.sendKeys("auto #1");
       // String expectedName = "auto #1";

        // Assert that product name is entered
    //    assertEquals(product_name.getAttribute("value"), expectedName, "Product name mismatch!");

       
        // Verify Sales checkbox and enable it if not selected
        WebElement saleCheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sale_ok_0")));
        if (!saleCheckbox.isSelected()) {
            saleCheckbox.click();
        }
        assertTrue(saleCheckbox.isSelected(), "Sales checkbox not selected!");

        // Select Product type and verify
        selectRadioButton(driver, "consu"); 
        verifyRadioButtonSelection(driver, "consu");

        // Enable inventory tracking
        WebElement inventory_track = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='o-checkbox form-check d-inline-block'])[3]")));
     // Ensure the checkbox is not already selected before clicking
        if (!inventory_track.isSelected()) {
            inventory_track.click();
        }

        // Wait until it is selected before asserting
        wait.until(ExpectedConditions.elementToBeClickable(inventory_track));
        Thread.sleep(2000);
      //  assertTrue(inventory_track.isSelected(), "Inventory tracking checkbox not selected!");
       
        // Proceed with other field inputs
        // Example for entering Sales Price and asserting
        WebElement salesPrice = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='list_price_0']")));
        salesPrice.clear();
        salesPrice.sendKeys("13.0000");
        assertEquals(salesPrice.getAttribute("value"), "13.0000", "Sales price mismatch!");

        // Similar input and assertions for other fields like UOM, taxes, etc.
       // 1. Locate the input field and click to open the dropdown
        WebElement uom = driver.findElement(By.xpath("//input[@id='uom_id_0']"));
        uom.click();
      
       // 2. Select the desired option (for example, selecting "gm")
        WebElement uom_selection = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='gm']")));
        uom_selection.click();
        assertEquals(uom_selection.isSelected(), "UOM not selected");
        
        WebElement salesTaxes = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='taxes_id_0']")));
        salesTaxes.sendKeys(Keys.BACK_SPACE);
        salesTaxes.click();
        WebElement salesTax_selection = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"taxes_id_0_0_0\"]")));
        salesTax_selection.click();
        assertEquals(salesTax_selection.isSelected(), "Tax is not selected");
        
        WebElement Cost = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='standard_price_0']")));
        Cost.clear();
        Cost.sendKeys("20.000");
        assertEquals(Cost.isSelected(), "Cost is not selected");
        
        WebElement purchaseTaxes = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='supplier_taxes_id_0']")));
        purchaseTaxes.sendKeys(Keys.BACK_SPACE);
        purchaseTaxes.click();
        WebElement purchaseTaxes_selection = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='supplier_taxes_id_0_0_0']")));
        purchaseTaxes_selection.click();
        assertEquals(purchaseTaxes_selection.isSelected(), "Purchase Tax is not selected");
        
     
        WebElement productCategory = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='categ_id_0']")));
        productCategory.sendKeys(Keys.BACK_SPACE);
        productCategory.click();
        WebElement productCategory_selection = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"categ_id_0_0_1\"]")));
        productCategory_selection.click();
        assertEquals(productCategory_selection.isSelected(), "Product category is not selected");
        
        WebElement reference = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='default_code_0']")));
        reference.sendKeys("AUTO-12345");
        
        WebElement description = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='x_studio_field_mHzKJ_0']")));
        description.sendKeys("Test Product Description");
        
        WebElement supplier_PartNum = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='x_studio_field_qr3ai_0']")));
        supplier_PartNum.sendKeys("Supplier Part Number");
        
        WebElement Manufacturer_name = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='manufacturer_id_0']")));
        Manufacturer_name.click();
        WebElement Manufacturer_selection = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='ABB Controls Inc']")));
        Manufacturer_selection.click();
        
        //purchase tab
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement purchase_tab = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@name='purchase']")));
        purchase_tab.click();
        WebElement addLine = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Add a line']")));
        addLine.click();
        WebElement sequence = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@name='sequence' and contains(@class, 'o_field_widget') and contains(@class, 'o_field_False')]/input[@inputmode='numeric' and @class='o_input' and @autocomplete='off' and @type='text']")));
        sequence.clear();
        sequence.sendKeys("01");
        
        WebElement vendor = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@name='partner_id']")));
        vendor.click();
        WebElement vendor_selection = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='AOQI MULTIMEDIA SDN BHD']")));
        vendor_selection.click();
        
        WebElement quantity = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@name='min_qty']/div[@name='min_qty']/input[@inputmode='decimal' and @class='o_input' and @autocomplete='off' and @type='text']")));
        quantity.clear();
        quantity.sendKeys("0");
        
        WebElement price = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@name='price' and @class='o_field_widget o_required_modifier o_field_float']/input[@inputmode='decimal' and @class='o_input' and @autocomplete='off' and @type='text']")));
        price.clear();
        price.sendKeys("25");
        
        WebElement currency = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@name='currency_id']//div[@class='o_field_widget o_required_modifier o_field_many2one']//div[@class='o_field_many2one_selection']//div[@class='o_input_dropdown']//div[@class='o-autocomplete dropdown']/input[@class='o-autocomplete--input o_input pe-3' and @type='text' and @aria-expanded='false']")));
        currency.click();
        Thread.sleep(2000);
        WebElement currency_selection = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='autocomplete_0_4']")));
        currency_selection.click();
        
        //inventory tab
        WebElement inventory = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@name='inventory' and text()='Inventory']")));
        inventory.click();
        Thread.sleep(2000);
        // Call the route function for both checkboxes
        selectCheckboxByLabel(driver, "PKS - Buy from Vendor");
        //selectCheckboxByLabel(driver, "Manufacture in PKS");
        // Add your other assertions here for different fields like `description`, `supplier_PartNum`, etc.

        // Click Save button
        WebElement save_product = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Save manually']")));
        save_product.click();

        // Assert if save was successful by checking for some confirmation
        WebElement confirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Product created')]")));
        assertTrue(confirmation.isDisplayed(), "Product creation failed!");
    }

 //   @Test
/*	public void testReorderingRule() throws InterruptedException {
        // Navigate to Sales and select product
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement Salesmodule = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[./div[text()='Sales']]")));
        Salesmodule.click();

        WebElement product_menu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-section='203' and text()='Products']")));
        product_menu.click();
        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-section='204' and text()='Products']")));
        product.click();

        // Search for the product and select
        WebElement Product_search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search...']")));
        Product_search.click();
        Product_search.sendKeys("Vivo 1#");
        Product_search.sendKeys(Keys.ENTER);

        WebElement Product_select = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='o_content']//span[text()='Vivo 1#']")));
        Product_select.click();

        // Click on 'More' option
        WebElement more_option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[span='More']")));
        more_option.click();

        // Click on 'Reordering Rules'
        WebElement reordering_rules = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(., 'Min:')]")));
        reordering_rules.click();

        // Set min and max quantities for reordering
        WebElement minInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@name='product_min_qty']//input")));
        minInput.clear();
        minInput.sendKeys("0");
        ((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new Event('change'));", minInput);

        WebElement maxInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@name='product_max_qty']//input")));
        maxInput.clear();
        maxInput.sendKeys("10");
        ((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new Event('change'));", maxInput);

        // Ensure values are correct
        String minValue = minInput.getAttribute("value");
        String maxValue = maxInput.getAttribute("value");

        assertEquals(minValue, "0", "Minimum quantity mismatch!");
        assertEquals(maxValue, "10", "Maximum quantity mismatch!");

        // Save reordering rule
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='button'and contains(text(), 'Save')]")));
        saveButton.click();

        // Assert that the reordering rule is saved
        WebElement confirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Reordering rule saved')]")));
        assertTrue(confirmation.isDisplayed(), "Reordering rule save failed!");
    }

   // @AfterMethod
    public void tearDown() {
        // Close the driver after each test
        if (driver != null) {
            driver.quit();
        }
    }   */

    // Helper methods for radio buttons and checkboxes
  	public static void selectCheckboxByLabel(WebDriver driver, String labelText) {
 		 WebElement checkbox = driver.findElement(By.xpath("//label[text()='" + labelText + "']/preceding-sibling::input[@type='checkbox']"));
 		 if (!checkbox.isSelected()) {
 		     checkbox.click();  // Select the checkbox if it's not already selected
 		 }
 		}
   
   	public static void selectRadioButton(WebDriver driver, String option) {
        WebElement radioButton = driver.findElement(By.xpath("//input[@type='radio' and @data-value='" + option + "']"));
        if (!radioButton.isSelected()) {
            radioButton.click();
        }
    }

  	public static void verifyRadioButtonSelection(WebDriver driver, String option) {
        WebElement radioButton = driver.findElement(By.xpath("//input[@type='radio' and @data-value='" + option + "']"));
        assertTrue(radioButton.isSelected(), option + " radio button is not selected");
    }
    

    
    
    
}

	
