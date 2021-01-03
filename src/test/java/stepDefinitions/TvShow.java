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

public class TvShow {
    private static final By Showoption =By.xpath("//*[@id='header-Header-sparkButton']/span[@class='g_b']");
    private static final By ShowmousehoverMoviesnBook =By.xpath("//*[@id='vh-department-menu']//span[text()='Movies, Music & Books']");
    private static final By tvShowOption =By.xpath("//*[@id='dept-l5zGKEY--children']//div[text()='TV Shows  ']");
    private static final By bigbangShow=By.xpath("//*[@id='searchProductResult']//span[text()='The Big Bang Theory: The Complete Series (DVD)']");
    private static final By showTitleVal=By.xpath("//*[@id='product-overview']//h1[text()='The Big Bang Theory: The Complete Series (DVD)']");

    private final Logger LOGGER = LogManager.getLogger(TvShow.class);
    WebDriver driver = Hooks.driver;

    @Given("^walmart homepage movie2$")
    public void homeWalmart2() throws IOException {
        ReadConfigFiles readConfigFiles = new ReadConfigFiles();
        Properties prop = readConfigFiles.getPropertyValue();
        String url = prop.getProperty("URL");
        LOGGER.info("URL is:" + url);
        ActOn.browser(driver).openBrowser(url);
    }

    @When("^user click on option and mousehover to movies and book and select tv show$")
    public void mouseHoberToMoviesShow(){
        ActOn.element(driver,Showoption).click();
        ActOn.element(driver,ShowmousehoverMoviesnBook).mouseHover();
        ActOn.element(driver, tvShowOption).click();
    }

    @And("^click The Big Bang Theory$")
    public void selectTvShow() {
        ActOn.element(driver, bigbangShow).click();
    }

    @Then("^validate the show title$")
    public void TvShowTitleValidation(){
        AssertThat.elementAssertions(driver,showTitleVal).elementExist();
    }

}
