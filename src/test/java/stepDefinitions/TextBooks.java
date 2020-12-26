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

public class TextBooks {
    private static final By optionTX =By.xpath("//*[@id='header-Header-sparkButton']/span[@class='g_b']");
    private static final By TXmousehoverMoviesnBook =By.xpath("//*[@id='vh-department-menu']//span[text()='Movies, Music & Books']");
    private static final By selectTypeBook=By.xpath("//*[@id='dept-l5zGKEY--children']//div[text()='Textbooks']");
    private static final By businessAndMoney=By.id("65c82341-6ee6-42f3-9330-bb51b521e681-tileLink-0");
    private static final By bookChose=By.xpath("//*[@id='searchProductResult']//span[text()='Extreme Ownership : How U.S. Navy Seals Lead and Win']");
    private static final By validateBookName =By.xpath("//*[@id='product-overview']//h1[contains(text(),'Extreme Ownership : How U.S. Navy Seals Lead and Win')]");


    private final Logger LOGGER= LogManager.getLogger(TextBooks.class);
    WebDriver driver = Hooks.driver;

    @Given("^user on walmart homepage1$")
    public void WalmarthomePage() throws IOException {
        ReadConfigFiles readConfigFiles = new ReadConfigFiles();
        Properties prop = readConfigFiles.getPropertyValue();
        String url = prop.getProperty("URL");
        LOGGER.info("URL is:" + url);
        ActOn.browser(driver).openBrowser(url);


    }

    @When("^user click on option and mousehover to movies and book and select Textbooks$")
    public void mouseHoberToMovies(){
        ActOn.element(driver, optionTX).click();
        ActOn.element(driver, TXmousehoverMoviesnBook).mouseHover();
        ActOn.element(driver,selectTypeBook).click();
    }

    @And("^click on business and money$")
    public void selectBookCategory(){
        ActOn.element(driver,businessAndMoney).click();
    }

    @Then("^user select the desired book and validate book title$")
    public void authorNameVal(){
        ActOn.element(driver,bookChose).click();
        AssertThat.elementAssertions(driver, validateBookName).elementExist();
    }
}
