package testngOdoo;


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import loginTest.loginBrowser;


public class Product_Creation {
	

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        loginBrowser test = new loginBrowser();
        driver = test.getDriver("chrome");
        test.login(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }


    @Test
    public void testProductCreation() throws InterruptedException {
        // Navigate to Sales module
        WebElement Salesmodule = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[./div[text()='Sales']]")));
        Salesmodule.click();

        // Click on Products menu
        WebElement product_menu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-section='203' and text()='Products']")));
        product_menu.click();

        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-section='204' and text()='Products']")));
        product.click();

        // Click on New product
        WebElement New = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' New ']")));
        New.click();

        Thread.sleep(1000);

        // Fill in product details
     // Fill in product details
        String productName = createProduct();

        // Verify Sales checkbox state
        verifySalesCheckbox();

        // Select Product Type
        selectProductType("consu");

        // Enable Track Inventory
        enableTrackInventory();

        // Select Invisible Policy
        selectInvoicePolicy("Ordered quantities");

        // Fill item details
        fillItemDetails();

        // Purchase Tab - Add vendor and price info
        fillPurchaseTab();
        
        //Inventory Tab - Routes
        fillInventoryTab();

        // Save the product
        WebElement save_product = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Save manually']")));
       // System.out.println(save_product);
        save_product.click();
        
        // Wait for the save button to become disabled indicating save has happened
        wait.until(ExpectedConditions.attributeToBe(By.xpath("//button[@aria-label='Save manually']"), "disabled", "true"));

        Thread.sleep(3000);
        //Assertion: Product name is the same as what is provided.
        WebElement productNameAfterSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@name='name']//textarea")));
        String test=productNameAfterSave.getText();
        System.out.println(test);
     //   Assert.assertEquals(productNameAfterSave.getText(), productName, "Product name is not displayed correctly after saving");
        
        
        
        
    }

    @AfterClass
 /*   public void tearDown() {
        // Close the driver after all tests are done
        if (driver != null) {
            driver.quit();
        }
    }
*/


    private void verifySalesCheckbox() {
        WebElement saleCheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sale_ok_0")));
        if (saleCheckbox.isSelected()) {
            System.out.println("Sales checkbox is already checked.");
        } else {
            System.out.println("Sales checkbox is not checked. Enabling...");
            new Actions(driver).moveToElement(saleCheckbox).click().perform();  // Click to select the checkbox
        }
    }

    private void selectProductType(String type) {
        selectRadioButton(driver, type);  // Example: Select "consu", "services", "combo"
        verifyRadioButtonSelection(driver, type);
    }

    private void enableTrackInventory() {
        WebElement inventory_track = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='o-checkbox form-check d-inline-block'])[3]")));
        inventory_track.click();
    }

    private void selectInvoicePolicy(String policy) {
        WebElement dropdown = driver.findElement(By.id("invoice_policy_0"));
        Select select = new Select(dropdown);
        select.selectByVisibleText(policy);  // Example: Select "Ordered quantities"
    }

    private void fillItemDetails() throws InterruptedException {
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement item_Text = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"item_text_0\"]")));
        item_Text.sendKeys("Customer Part Number");

        WebElement customer_partNumber = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"customer_part_number_0\"]")));
        customer_partNumber.sendKeys("Customer Part Number");

        WebElement salesPrice = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='list_price_0']")));
        salesPrice.clear();
        salesPrice.sendKeys("32.0000");

        WebElement uom = driver.findElement(By.xpath("//input[@id='uom_id_0']"));
        uom.click();

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
        reference.sendKeys("Scenario1_test product35");

        WebElement description = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='x_studio_field_mHzKJ_0']")));
        description.sendKeys("Test Product Description");

        WebElement supplier_PartNum = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='x_studio_field_qr3ai_0']")));
        supplier_PartNum.sendKeys("Supplier Part Number");

        WebElement Manufacturer_name = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='manufacturer_id_0']")));
        Manufacturer_name.click();
        WebElement Manufacturer_selection = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='ABB Controls Inc']")));
        Manufacturer_selection.click();
    }

    private void fillPurchaseTab() throws InterruptedException {
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
    }

    private void fillInventoryTab() throws InterruptedException {
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(40));

        // Open the Inventory tab
        WebElement inventory = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@name='inventory' and text()='Inventory']")));
        inventory.click();
        Thread.sleep(2000);

        // Select the checkbox for "PKS - Buy from Vendor"
        selectCheckboxByLabel(driver, "PKS - Buy from Vendor");

        // Uncomment the following line if you need to select "Manufacture in PKS"
        // selectCheckboxByLabel(driver, "Manufacture in PKS");
    }
    
    
    
    
    private void selectRadioButton(WebDriver driver, String option) {
        WebElement radioButton = driver.findElement(By.xpath("//input[@type='radio' and @data-value='" + option + "']"));
        if (!radioButton.isSelected()) {
            radioButton.click();
        }
    }

    private void verifyRadioButtonSelection(WebDriver driver, String option) {
        WebElement radioButton = driver.findElement(By.xpath("//input[@type='radio' and @data-value='" + option + "']"));
        if (radioButton.isSelected()) {
            System.out.println(option + " radio button is selected");
        } else {
            System.out.println(option + " radio button is not selected");
        }
    }

    private void selectCheckboxByLabel(WebDriver driver, String labelText) {
        WebElement checkbox = driver.findElement(By.xpath("//label[text()='" + labelText + "']/preceding-sibling::input[@type='checkbox']"));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }
	
    private String createProduct() {
        WebElement product_name = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@id='name_0']")));
        String productName = "Scenario1_test product";
        product_name.sendKeys(productName);
        return productName;

        // Add any other field interactions here if necessary
    }

}
