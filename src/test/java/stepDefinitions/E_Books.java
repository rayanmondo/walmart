package stepDefinitions;

import command_providers.ActOn;
import command_providers.AssertThat;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ReadConfigFiles;

import java.io.IOException;
import java.util.Properties;

public class E_Books {
    private static final By ebookOption = By.xpath("//*[@id='header-Header-sparkButton']/span[@class='g_b']");
    private static final By ebookMousehoverMoviesnBook = By.xpath("//*[@id='vh-department-menu']//span[text()='Movies, Music & Books']");
    private static final By selectEbookType = By.xpath("//*[@id='dept-l5zGKEY--children']//div[text()='eBooks']");
    private static final By ebookName = By.xpath("/html/body//a/div[1][@title='Chaos Walking Movie Tie-in Edition: The Knife of Never Letting Go ebook by Patrick Ness']");
    private static final By valWriterName = By.xpath("/html/body//a[text()='Patrick Ness']");
    private final Logger LOGGER = LogManager.getLogger(E_Books.class);
    WebDriver driver= Hooks.driver;

    @Given("^walmart homepage$")
    public void mainpage() throws IOException {
        ReadConfigFiles readConfigFiles = new ReadConfigFiles();
        Properties prop = readConfigFiles.getPropertyValue();
        String url = prop.getProperty("URL");
        LOGGER.info("URL is:" + url);
        ActOn.browser(driver).openBrowser(url);
    }

    @When("^click on option and mousehover to movies and book and select ebook$")
    public void selectionOfDesireBook() {
        ActOn.element(driver, ebookOption).click();
        ActOn.element(driver, ebookMousehoverMoviesnBook).mouseHover();
        ActOn.element(driver, selectEbookType).click();
    }

    @And("^user click on desired ebook$")
    public void selectBookCategory() {
        ActOn.element(driver, ebookName).click();
    }

    @Then("^select the  ebook and validate writer name$")
    public void priceValidation() {
        AssertThat.elementAssertions(driver, valWriterName).elementExist();
    }

}
