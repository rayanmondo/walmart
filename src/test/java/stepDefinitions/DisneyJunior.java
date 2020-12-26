package stepDefinitions;

import command_providers.ActOn;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ReadConfigFiles;

import java.io.IOException;
import java.util.Properties;

public class DisneyJunior {
    private static final By DisOption = By.xpath("//*[@id='header-Header-sparkButton']/span[@class='g_b']");
    private static final By DisMousehoverMoviesnBook = By.xpath("//*[@id='vh-department-menu']//span[text()='Movies, Music & Books']");
    private static final By disneyjuniorcat=By.xpath("//*[@id='dept-l5zGKEY--children']//div[text()='Disney Junior']");
    private static final By firstItem=By.xpath("//*[@id='cp-center-module-1']//a[@aria-label=' World of Reading: Disney Junior: Five Tales of Fun! (Paperback). Average rating: 4 out of 5 stars based on 1 reviews. Price $5.34 was $7.99. Two day delivery.']");

    private final Logger LOGGER = LogManager.getLogger(DisneyJunior.class);
    WebDriver driver = Hooks.driver;

    @Given("^walmart homepage for disney$")
    public void walmartPageforDis() throws IOException {
        ReadConfigFiles readConfigFiles = new ReadConfigFiles();
        Properties prop = readConfigFiles.getPropertyValue();
        String url = prop.getProperty("URL");
        LOGGER.info("URL is:" + url);
        ActOn.browser(driver).openBrowser(url);
    }

    @When("^click on option and mousehover to movies and book and select disney junior$")
    public void selectDisJUnior() {

        ActOn.element(driver, DisOption).click();
        ActOn.element(driver, DisMousehoverMoviesnBook).mouseHover();
        ActOn.element(driver, disneyjuniorcat).click();
    }

    @And("^click on first item$")
    public void itemSelection() {
        ActOn.element(driver, firstItem).click();
    }

    @Then("^validate the item page$")
    public void DisneyItemPageVal() {
        ActOn.browser(driver).validateTitle("World of Reading: Disney Junior: Five Tales of Fun! (Paperback) - Walmart.com - Walmart.com");
    }
}
