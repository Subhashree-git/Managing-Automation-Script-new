package loginTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class loginBrowser {

    // Method to get WebDriver based on the browser name passed
    public WebDriver getDriver(String browser) {
        WebDriver driver = null;

        // Setting up browser-specific drivers
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();  // Automatically download and setup ChromeDriver
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("start-maximized"); // Start Chrome maximized
                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();  // Automatically download and setup GeckoDriver
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless");  // Running Firefox in headless mode
                driver = new FirefoxDriver(firefoxOptions);
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();  // Automatically download and setup EdgeDriver
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("start-maximized"); 
                driver = new EdgeDriver(edgeOptions);
                break;

            default:
                System.out.println("Unsupported browser: " + browser);
                break;
        }

        return driver;
    }

public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	    // You can pass the browser name directly or ask the user to input it
        String browser = "edge"; // Set this to "chrome", "firefox", or "edge" for testing

       // Create an instance of loginBrowser
       loginBrowser browserFactory = new loginBrowser();
    
       // Get the WebDriver based on the browser
       WebDriver driver = browserFactory.getDriver(browser);

       // Perform login actions here
       driver.get("http://8.217.119.29:8069/odoo/contacts/new");
       
       // Print a message
       System.out.println("Odoo Runbot v18 Opened");
       
       driver.findElement(By.xpath("//a[@href='/odoo?db=Peckochina_v18_testing']")).click();
      	    
            // Wait for the login fields to be visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
           
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='login']")));// Replace with actual element ID
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='password']")));// Replace with actual element ID
            WebElement loginButton = driver.findElement(By.xpath("//button[text()='Log in']"));  // Replace with actual XPath if necessary

            // Enter credentials
            usernameField.sendKeys("admin");
            passwordField.sendKeys("@dminstage");

            // Click the login button
            loginButton.click();

            // Wait for successful login (You can wait for an element that indicates successful login)
            //WebElement postLoginElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Dashboard']")));  // Example post-login check
            System.out.println("Login successful");

      
            // Close the browser
            driver.quit();
        }
    }

		
		
		
		
		
	


