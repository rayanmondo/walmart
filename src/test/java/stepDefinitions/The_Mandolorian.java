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

public class The_Mandolorian {
    private static final By option=By.xpath("//*[@id='header-Header-sparkButton']/span[@class='g_b']");
    private static final By mousehoverMoviesnBook=By.xpath("//*[@id='vh-department-menu']//span[text()='Movies, Music & Books']");
  //  private static final By mousehoverMoviesnBook=By.xpath("//*[@id='vh-department-menu']/button[9]//span[text()='Movies, Music & Books']");
    private static final By selectTypeCollection =By.xpath("//*[@id='dept-l5zGKEY--children']//div[text()='The Mandalorian']");
    private static final By mandalorianCollection =By.xpath("//*[@id='cp-center-module-0']//a[@data-product-id='6W3V8Z8HVGPW']");
    private static final By titleValid = By.xpath("//*[@id='product-overview']//h1[text()='Baby Yoda Twin/Full Comforter and Sham Set']");
    private final Logger LOGGER = LogManager.getLogger(The_Mandolorian.class);
    WebDriver driver = Hooks.driver;

    @Given("^user on walmart homepage$")
    public void home() throws IOException {
        ReadConfigFiles readConfigFiles = new ReadConfigFiles();
        Properties prop = readConfigFiles.getPropertyValue();
        String url = prop.getProperty("URL");
        LOGGER.info("URL is:" + url);
        ActOn.browser(driver).openBrowser(url);
    }

    @When("^click on option and mousehover to movies and book and select Mandalorian$")
    public void mouseHoberToMoviesandBOok(){
        ActOn.element(driver,option).click();
        ActOn.element(driver,mousehoverMoviesnBook).mouseHover();
        ActOn.element(driver, selectTypeCollection).click();
}

    @And("^click on desired type of mandaloria collection$")
    public void selectAudioBookCategory() {
        ActOn.element(driver, mandalorianCollection).click();
    }

    @Then("^validate the title$")
     public void AudioBookTitleVal(){
        AssertThat.elementAssertions(driver,titleValid).elementExist();
    }

}


