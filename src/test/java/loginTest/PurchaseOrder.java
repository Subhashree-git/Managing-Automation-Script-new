package loginTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PurchaseOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		loginBrowser test = new loginBrowser();
        WebDriver driver = test.getDriver("chrome");
        test.login(driver);
        
     // Wait until the Manufacturing value element is visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40)); 
        WebElement manufacturingValueElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='o_stat_text' and text()='Purchase']/preceding-sibling::div//div[@name='purchase_order_count']//span")));

        // Extract the text value from the element (which should be a number)
        String manufacturingValue = manufacturingValueElement.getText();

        // Convert the value to a float or integer to compare
        float manufacturingCount = Float.parseFloat(manufacturingValue);

        // Check if the value is not equal to 0
        if (manufacturingCount != 0) {
            // Find the smart button for "Manufacturing" (using its parent or another related identifier) and click it
            WebElement manufacturingButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='o_stat_text' and text()='Purchase']/preceding-sibling::div//button")));
            manufacturingButton.click();
            System.out.println("Smart button for Manufacturing clicked.");
        } else {
            System.out.println("Manufacturing value is 0, smart button not clicked.");
        }


        
        
        
		
		
		
	}

}
