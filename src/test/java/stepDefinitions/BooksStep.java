package stepDefinitions;

import command_providers.ActOn;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page_object.BooksCucumber;
import page_object.NavigationBar;
import utilities.ReadConfigFiles;

import java.io.IOException;
import java.util.Properties;

public class BooksStep {
    private final Logger LOGGER = LogManager.getLogger(BooksStep.class);
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
    public void selectionOfDesireBook(){
        LOGGER.info("Book is selected");
        new NavigationBar(driver)
                .OptionLink()
                .mouseHoverToBooksAndMovies()
                .clickToLinkEbook();
    }

    @And("^user click on Chaos Walking Movie Tie-in Edition$")
    public void selectBookCategory() {
        new BooksCucumber(driver)
                .chaosWalking();
    }

    @Then("^User select the desired book and validate writer name \"(.+?)\"$")
    public void priceValidation(String name) {
        new BooksCucumber(driver)
                .writerNameVal(name);
    }

    @When("^user click on option and mousehover to movies and book and select Textbooks$")
    public void textbookSelect(){
        new NavigationBar(driver)
                .OptionLink()
                .mouseHoverToBooksAndMovies()
               .ClickToTextBook();

    }

    @And("^User click on business and money and click on Extreme Ownership$")
    public void extremeOwnershipBook(){
        new BooksCucumber(driver)
                .selectTextBookCategory()
                .selectTextBookStrong();
    }

    @Then("User validate the title \"(.+?)\"$")
    public void TextBookTitleValidation(String title){
        new BooksCucumber(driver)
                .Validationtitle(title);
    }

    @When("^user click on option and mousehover to movies and book and select Mandalorian$")
    public void selectMandalorianLInk(){
        new NavigationBar(driver)
                .OptionLink()
                .mouseHoverToBooksAndMovies()
                .clickToMandalorinLink();
    }

    @And("^User click on Baby Yoda Twin$")
    public void mandalorianItem(){
        new BooksCucumber(driver)
                .mandalorianTwinBed();
    }

    @When("^user click on option and mousehover to movies and book and select over the moon$")
    public void selectOverTheMoon(){
        new NavigationBar(driver)
                .OptionLink()
                .mouseHoverToBooksAndMovies()
                .OverTHeMoonLink();
    }

    @And("^User click on over the moon Bungee$")
    public void overTheMoonItem(){
        new BooksCucumber(driver)
                .BungeeLink();
    }

    @When("^user click on option and mousehover to movies and book and select Disney book$")
    public void DisneyBooks(){
        new NavigationBar(driver)
                .OptionLink()
                .mouseHoverToBooksAndMovies()
                .disneyLink();
    }

    @And("^User click on World of Reading: Level 2$")
    public void disneyItem(){
        new BooksCucumber(driver)
                .DisneyBookItem();
    }



}
