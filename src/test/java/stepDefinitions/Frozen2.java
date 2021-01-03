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

public class Frozen2 {
    private static final By frozOption = By.xpath("//*[@id='header-Header-sparkButton']/span[@class='g_b']");
    private static final By FrozMousehoverMoviesnBook = By.xpath("//*[@id='vh-department-menu']//span[text()='Movies, Music & Books']");
    private static final By newMovies=By.xpath("//*[@id='dept-l5zGKEY--children']//a[1]/div[text()='New Release Movies']");
    private static final By selectMovieFro=By.xpath("//*[@id='searchProductResult']//span[text()='Frozen II (DVD)']");
    private static final By froTitleVal=By.xpath("//*[@id='product-overview']//h1[text()='Frozen II (DVD)']");

    private final Logger LOGGER = LogManager.getLogger(Frozen2.class);
    WebDriver driver = Hooks.driver;

    @Given("^walmart homepage movie1$")
    public void homeWalmart1() throws IOException {
        ReadConfigFiles readConfigFiles = new ReadConfigFiles();
        Properties prop = readConfigFiles.getPropertyValue();
        String url = prop.getProperty("URL");
        LOGGER.info("URL is:" + url);
        ActOn.browser(driver).openBrowser(url);
    }

    @When("^user click on option and mousehover to movies and book and select new release movie$")
    public void mouseHoberToMoviesFro(){
        ActOn.element(driver,frozOption).click();
        ActOn.element(driver,FrozMousehoverMoviesnBook).mouseHover();
        ActOn.element(driver, newMovies).click();
    }

    @And("^click frozen 2$")
    public void selectFrozen() {
        ActOn.element(driver, selectMovieFro).click();
    }

    @Then("^validate the movie title$")
    public void FrozTitleVal(){
        AssertThat.elementAssertions(driver,froTitleVal).elementExist();
    }
}
