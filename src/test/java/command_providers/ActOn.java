package command_providers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActOn {
    public static BrowserActions browser(WebDriver driver){
        return new BrowserActions(driver);
    }

    public static ElementActions element (WebDriver driver, By locator){
        return new ElementActions(driver, locator);
    }
    public  static  Waitfor wait ( WebDriver driver, By locator){
        return  new Waitfor(driver, locator);
    }
}
