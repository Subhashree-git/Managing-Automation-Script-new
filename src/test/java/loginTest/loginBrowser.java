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
    
    // Method to perform login action
    public void login(WebDriver driver) {
        driver.get("http://8.217.119.29:8069/odoo/contacts/new");

        // Print a message
        System.out.println("Application Opened");
        driver.findElement(By.xpath("//a[@href='/odoo?db=Peckochina_v18_testing']")).click();

        // Wait for the login fields to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='login']")));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='password']")));
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Log in']")));

        // Enter credentials
        usernameField.sendKeys("admin");
        passwordField.sendKeys("@dminstage");
        loginButton.click();

        System.out.println("Login successful");
    }
    

public static void main(String[] args) {
		// TODO Auto-generated method stub
	    loginBrowser test = new loginBrowser();
        WebDriver driver = test.getDriver("chrome");
        test.login(driver);
        
    }    
	
	

}
			
	


