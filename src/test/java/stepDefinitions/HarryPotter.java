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

public class HarryPotter {
    private static final By harryoption =By.id("header-Header-sparkButton");
    private static final By harrymousehover =By.xpath("//*[@id='vh-department-menu']//span[text()='Movies, Music & Books']");
    private static final By selecCompleteSeries =By.xpath("//*[@id='dept-l5zGKEY--children']//div[text()='Complete Series & Box Sets  ']");
    private static final By selecHarryPotter=By.xpath("//*[@id='searchProductResult']//span[text()='Harry Potter: The Complete 8-Film Collection (DVD)']");
    private static final By validatePotterTitle=By.xpath("//*[@id='product-overview']//div[3]/div/a/span[text()='Daniel Radcliffe; Rupert Grint; Emma Watson']");
    private final Logger LOGGER = LogManager.getLogger(HarryPotter.class);
    WebDriver driver = Hooks.driver;

    @Given("^walmart homepage movie3$")
    public void homeWalmart3() throws IOException {
        ReadConfigFiles readConfigFiles = new ReadConfigFiles();
        Properties prop = readConfigFiles.getPropertyValue();
        String url = prop.getProperty("URL");
        LOGGER.info("URL is:" + url);
        ActOn.browser(driver).openBrowser(url);
    }

    @When("^user click on option and mousehover to movies and book and select complete series$")
    public void mouseHoberToSeries(){
        ActOn.element(driver,harryoption).click();
        ActOn.element(driver, harrymousehover).mouseHover();
        ActOn.element(driver, selecCompleteSeries).click();
    }

    @And("^click on Harry potter$")
    public void selectSeriesHP() {
        ActOn.element(driver, selecHarryPotter).click();
    }

    @Then("^validate the complete series title$")
    public void TvShowTitleValidation(){
        AssertThat.elementAssertions(driver,validatePotterTitle).elementExist();
    }
}
