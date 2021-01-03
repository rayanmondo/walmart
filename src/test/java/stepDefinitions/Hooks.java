package stepDefinitions;

import command_providers.ActOn;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    private static final Logger LOGGER= LogManager.getLogger(Hooks.class);
    static WebDriver driver;
    @Before
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("chrome://settings/clearBrowserData");
        driver.findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);
        LOGGER.info("Launch Chrome Browser");
    }
    @After
    public void closeBrowser(){
        ActOn.browser(driver).closeBrowser();
        LOGGER.info("Close Chrome Browser");
    }
}

