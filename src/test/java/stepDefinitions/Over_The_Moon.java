package stepDefinitions;

import command_providers.ActOn;
import command_providers.AssertThat;
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

public class Over_The_Moon {
    private static final By OTM_Option = By.xpath("//*[@id='header-Header-sparkButton']/span[@class='g_b']");
    private static final By OTM_MousehoverMoviesnBook=By.xpath("//*[@id='vh-department-menu']//span[text()='Movies, Music & Books']");
    //private static final By OTM_MousehoverMoviesnBook = By.xpath("//*[@id='vh-department-menu']/button[9]//span[text()='Movies, Music & Books']");
    private static final By overTheMoon=By.xpath("//*[@id='dept-l5zGKEY--children']//div[text()='Over the Moon']");
    private static final By BungeePush=By.xpath("//*[@id='cp-center-module-0']//li[1]/div/div/div[1]/div/a[@data-product-id='5JEUK90ZEQ87']");
    private static final By BungeeTitleVal=By.xpath("//*[@id='product-overview']//h1[text()='Over the Moon Bungee Plush']");
    private final Logger LOGGER = LogManager.getLogger(Over_The_Moon.class);
    WebDriver driver= Hooks.driver;

    @Given("^user on walmart homepage2$")
    public void walmartPage() throws IOException {
        ReadConfigFiles readConfigFiles = new ReadConfigFiles();
        Properties prop = readConfigFiles.getPropertyValue();
        String url = prop.getProperty("URL");
        LOGGER.info("URL is:" + url);
        ActOn.browser(driver).openBrowser(url);

    }

    @When("^click on option and mousehover to movies and book and select over the moon$")
    public void selectOverTheMoon() {
        ActOn.element(driver, OTM_Option).click();
        ActOn.element(driver, OTM_MousehoverMoviesnBook).mouseHover();
        ActOn.element(driver, overTheMoon).click();
    }

    @And("^click on desired item$")
    public void selectBungee() {
        ActOn.element(driver, BungeePush).click();
    }

    @Then("^validate the item title$")
    public void bungeeTitleValidation() {
        AssertThat.elementAssertions(driver, BungeeTitleVal).elementExist();
    }

}
