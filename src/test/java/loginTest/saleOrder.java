package loginTest;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class saleOrder {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	    loginBrowser test = new loginBrowser();
		WebDriver driver = test.getDriver("chrome");
		test.login(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement Salesmodule = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[./div[text()='Sales']]")));
		Salesmodule.click();

		WebElement Order = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-hotkey='1']")));
		Order.click();
		WebElement Quotation = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Quotations']")));
		Quotation.click();
		WebElement new_Quotation = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-hotkey='c']")));
		new_Quotation.click();

		WebElement customer = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='partner_id_0']")));
		customer.click();
		Thread.sleep(2000);
		customer.sendKeys("AOQI MULTIMEDIA SDN BHD, KC Lee");
		customer.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		WebElement expiration_date = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='validity_date_0']")));
		expiration_date.click();
		WebElement date_picker = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[span[text()='11']]")));
		date_picker.click();

		WebElement pricelist = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pricelist_id_0']")));
		pricelist.click();
		WebElement pricelist_selection = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Default (CNY)']")));
		pricelist_selection.click();

		WebElement paymentTerms = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"payment_term_id_0\"]")));
		paymentTerms.click();
		WebElement payment_selection = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Immediate Payment']")));
		payment_selection.click();

		WebElement customerPO = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='customer_po_no_0']")));
		customerPO.sendKeys("SAMPLE NUMBER");

		WebElement customerPO_Date = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='customer_po_date_0']")));
		customerPO_Date.click();
		WebElement customerPO_DatePicker = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button/span[text()='15']")));
		customerPO_DatePicker.click();

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(40));

		WebElement Orderline_Tab = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@name='order_lines']")));
		Orderline_Tab.click();

		Thread.sleep(1000);

		// Wait for the tooltip to disappear
		WebDriverWait wait0 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait0.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//div[@class='o_tour_pointer_tip position-absolute']")));


		// adding products
		Thread.sleep(2000);
		WebElement add_product = wait1
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Add a product']")));
		add_product.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new Event('change'));", add_product);

		WebElement fill_POSITION = wait1.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//input[@inputmode='numeric' and @class='o_input' and @autocomplete='off' and @type='text']")));
		fill_POSITION.sendKeys("1");
		
		String saleOrderProductName = "Product1#23";
		System.out.println("Sale Order Product " + saleOrderProductName);

		WebElement fill_PeckoPartNumber = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"(//input[@type='text' and @class='o-autocomplete--input o_input pe-3' and @autocomplete='off' and @role='combobox' and @aria-autocomplete='list' and @aria-haspopup='listbox' and @aria-expanded='false'])[8]")));
		fill_PeckoPartNumber.click();
		Thread.sleep(2000);
		fill_PeckoPartNumber.sendKeys(saleOrderProductName);
		Thread.sleep(2000);
		fill_PeckoPartNumber.sendKeys(Keys.ENTER);

		WebElement fill_Quantity = wait1
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@name='product_uom_qty']//input")));

		fill_Quantity.clear();
		fill_Quantity.sendKeys("12");

		// Trigger change event if necessary
		((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new Event('change'));", fill_Quantity);

  /*      WebElement fill_Taxes = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='text' and @class='o-autocomplete--input o_input pe-3' and @autocomplete='off' and @role='combobox' and @aria-autocomplete='list' and @aria-haspopup='listbox' and @aria-expanded='false'])[10]")));
        fill_Taxes.click();

        WebElement fill_unitPrice = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@inputmode='decimal' and @type='text'])[2]"))); 
        fill_unitPrice.click();
        fill_unitPrice.sendKeys("       ");
*/
		Thread.sleep(1000);

/*		 WebElement add_product2 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Add a product']"))); 
		 add_product2.click(); 
		 WebElement fill_POSITION2 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@inputmode='numeric' and @class='o_input' and @autocomplete='off' and @type='text']"))); 
		 fill_POSITION2.sendKeys("1"); 
		 Thread.sleep(1000); 
		 WebElement fill_PeckoPartNumber2 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='text' and @class='o-autocomplete--input o_input pe-3' and @autocomplete='off' and @role='combobox' and @aria-autocomplete='list' and @aria-haspopup='listbox' and @aria-expanded='false'])[8]"))); 
		 fill_PeckoPartNumber2.click(); 
		 Thread.sleep(2000);
		 fill_PeckoPartNumber2.sendKeys("[SS-12345] Samsung 1#"); 
		 Thread.sleep(2000);
		 fill_PeckoPartNumber2.sendKeys(Keys.ENTER); 
		 Thread.sleep(1000);
		 WebElement fill_Quantity2 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[@name='product_uom_qty'])[2]//input")));
	     fill_Quantity2.clear(); fill_Quantity2.sendKeys("12");
         // Trigger change event if necessary 
	     ((JavascriptExecutor)driver).executeScript("arguments[0].dispatchEvent(new Event('change'));", fill_Quantity2);
		 WebElement add_product3 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Add a product']"))); 
		 add_product3.click();
*/		 

		Thread.sleep(1000);
		WebElement save = wait1
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Save manually']")));
		save.click();
		WebElement confirm = wait1.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@data-hotkey='q' and @name='action_confirm']")));
		confirm.click();

		Thread.sleep(3000);
		// Assuming you have a WebDriver instance (driver) initialized
		WebElement spanElement = driver.findElement(By.xpath("//div[@class='oe_title']//h1//div[@name='name']//span")); 

		// Retrieve the text inside the span element
		String spanText = spanElement.getText();

		// Print or use the text
		System.out.println("Sale order id: " + spanText);

		// Duplicate window
		// Execute JavaScript to open a new tab
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open('','_blank');");
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);

		// Get all window handles (tabs)
		Set<String> allWindowHandles = driver.getWindowHandles();

		// Iterate through the window handles and switch to the new tab
		String firstTab = driver.getWindowHandle(); // Store the first tab's window handle
		for (String handle : allWindowHandles) {
			if (!handle.equals(firstTab)) {
				driver.switchTo().window(handle);
				break; // Switch to the new tab
			}
		}

		// Copy the URL of the first tab and load it in the new tab (duplicate)
		driver.get(currentUrl); // Same URL as the first tab

		// Optionally, perform actions in the new duplicated tab
		System.out.println("Title of the new tab: " + driver.getTitle());

		// Switch back to the original tab
		// driver.switchTo().window(firstTab);

		WebElement modules = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='Sales']")));
		modules.click();

		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement PurchaseModule = wait3
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[./div[text()='Purchase']]")));
		PurchaseModule.click();

		WebElement Order_purchase = wait3
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[span[text()='Orders']]")));
		Order_purchase.click();

		WebElement rfq_purchase = wait3
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Requests for Quotation']")));
		rfq_purchase.click();

		WebElement search_rfq = wait3
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search...']")));
		search_rfq.click();
		search_rfq.sendKeys(spanText);

		WebElement searchby = wait3.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//ul[@class='o-dropdown--menu dropdown-menu o_searchview_autocomplete show']//li[@id='55']")));
		searchby.click();

		// Wait for the results list to appear (assuming it's an unordered list)
		List<WebElement> results = driver.findElements(By.xpath(
				"//table[@class='o_list_table table table-sm table-hover position-relative mb-0 o_list_table_ungrouped table-striped']//tbody"));
		Thread.sleep(2000);
		// Check if results are present
		if (results.size() > 0) {
			// System.out.println("Records found: " + results.size());
			WebElement firstRow = results.get(0);
			String firstRowText = firstRow.getText().trim();
			if (firstRowText.isEmpty()) {
				System.out.println("RFQ not created for this " + spanText);
			} else {
				System.out.println("Records found: " + results.size());
				if (results.size() == 1) {
					System.out.println("Related RFQ is " + firstRowText);
					firstRow.click();
				}
			}
		} else {
			System.out.println("No records found.");
		}
		
		Thread.sleep(2000);
		
		
		// Locate the <tbody> element containing the rows
        WebElement tbody = driver.findElement(By.cssSelector("tbody.ui-sortable"));

        // Find all <tr> elements inside the tbody
        List<WebElement> rows = tbody.findElements(By.cssSelector("tr.o_data_row.o_row_draggable.o_is_false"));

        String PO_QuantityText = null;
        // Iterate through each <tr> to extract product details
        for (WebElement row : rows) {
            // Find the <td> element with the name 'product_id' to get the product name
            WebElement productTd = row.findElement(By.xpath("//td[@name='customer_part_no']"));
            String PO_Product = productTd.getText().trim();

            // Find the <td> element with the name 'product_qty' to get the quantity
            WebElement qtyTd = row.findElement(By.xpath("//td[@name='product_qty']"));
            PO_QuantityText = qtyTd.getText().trim();

            // Find the <td> element with the name 'price_unit' to get the price
            WebElement priceTd = row.findElement(By.xpath("//td[@name='price_unit']"));
            String PO_Price = priceTd.getText().trim();

            // Find the <td> element with the name 'price_subtotal' to get the subtotal
            WebElement subtotalTd = row.findElement(By.xpath("//td[@name='price_subtotal']"));
            String PO_Subtotal = subtotalTd.getText().trim();

            // Output the product details
            System.out.println("PO Product: " + PO_Product + ", PO Quantity: " + PO_QuantityText + ", PO Price: " + PO_Price + ", PO Subtotal: " + PO_Subtotal);
        
            Thread.sleep(3000);
         // Check if the product matches the sale order product name
            if (PO_Product.equals(saleOrderProductName)) {
                // Store the quantity for this specific product
                String specificProductQty = PO_QuantityText;
                System.out.println("Specific Product: " + PO_Product + ", Specific Quantity: " + specificProductQty);
            } else {
                System.out.println("Product does not match the sale order product name.");
            
            }
            
        }
   
		 // Get available quantity and maximum quantity from printProductDetails()
	    saleOrder order = new saleOrder();
	    double[] productDetails = order.printProductDetails();
	    double availableQty = productDetails[0];
	    double maxQty = productDetails[1];

	    // Now you can use these values in calculatePOQuantity()
	    double salesOrderQty = 12;  // This is an example, get this from your sales order form as needed
	    double calculatedPOQuantity = calculatePOQuantity(availableQty, maxQty, salesOrderQty);

	    System.out.println("Calculated PO Quantity: " + calculatedPOQuantity);

		
		// Perform the calculation for PO Quantity and compare it to expected value
	   double poQuantityValue = Double.parseDouble(PO_QuantityText); // Parse the PO Quantity text

		// Optionally, validate whether the calculated PO quantity matches the expected value
		if (calculatedPOQuantity == poQuantityValue) {
		    System.out.println("PO Quantity is correct.");
		} else {
		    System.out.println("PO Quantity is incorrect.");
		}
	
	}

	
	
	public static double calculatePOQuantity(double onHandQty, double maxQty, double salesOrderQty) {
        double poQty = 0.0;

        // PO Quantity calculation logic based on the formula
        double availableStockAfterSO = onHandQty - salesOrderQty;

        if (availableStockAfterSO <= 0) {
            // If available stock after considering SO is <= 0, create PO
            poQty = maxQty - availableStockAfterSO;
            System.out.println("PO Quantity calculated: " + poQty);
        } else {
            // If available stock after considering SO is positive, no PO needed
            poQty = 0;
            System.out.println("No PO needed. Available stock is sufficient.");
        }

        return poQty;
    }

	public double[] printProductDetails() throws InterruptedException {
		loginBrowser test = new loginBrowser();
		WebDriver driver = test.getDriver("chrome");
		test.login(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement Salesmodule = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[./div[text()='Sales']]")));
		Salesmodule.click();

		WebElement product_menu = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-section='203' and text()='Products']")));
		product_menu.click();

		WebElement product = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-section='204' and text()='Products']")));
		product.click();

		WebElement Product_search = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search...']")));
		Product_search.click();
		Product_search.sendKeys("Product1#23");
		Product_search.sendKeys(Keys.ENTER);

		WebElement Product_select = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class='o_content']//span[text()='Product1#23']")));
		Product_select.click();
		// Get and print Available Quantity
		WebElement qtyAvailableElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@name='qty_available']//span")));
		String qtyAvailableValue = qtyAvailableElement.getText();
		System.out.println("Available Quantity: " + qtyAvailableValue);

		// Get and print Forecasted Available Quantity
		WebElement virtualAvailableElement = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@name='virtual_available']//span")));
		String virtualAvailableValue = virtualAvailableElement.getText();
		System.out.println("Forecasted Available Quantity: " + virtualAvailableValue);
		Thread.sleep(2000);
		
        //more option clicking
        WebElement more_option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[span='More']")));
        more_option.click();

		// Get and print Purchased Value
		WebElement purchasedValueElement = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@name='purchased_product_qty']//span")));
		String purchasedValue = purchasedValueElement.getText();
		System.out.println("Purchased Value: " + purchasedValue);

		// Get and print Sold Value
		WebElement soldValueElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@name='sales_count']//span")));
		String soldValue = soldValueElement.getText();
		System.out.println("Sold Value: " + soldValue);

		// Get and print Minimum Value
		WebElement minValueElement = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@name='reordering_min_qty']//span")));
		String minValue = minValueElement.getText();
		System.out.println("Minimum Value: " + minValue);

		// Get and print Maximum Value
		WebElement maxValueElement = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@name='reordering_max_qty']//span")));
		String maxValue = maxValueElement.getText();
		System.out.println("Maximum Value: " + maxValue);
		
		driver.quit();
		
		// Convert to double and return as an array of doubles
	    double availableQty = Double.parseDouble(qtyAvailableValue);
	    double maxQty = Double.parseDouble(maxValue);
	    return new double[]{availableQty, maxQty};
	}
	
}
