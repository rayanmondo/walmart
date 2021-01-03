package stepDefinitions;

import command_providers.ActOn;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page_object.MoviesCucumver;
import page_object.NavigationBar;
import utilities.ReadConfigFiles;

import java.io.IOException;
import java.util.Properties;

public class MoviesStep {
    private final Logger LOGGER = LogManager.getLogger(MoviesStep.class);
    WebDriver driver= Hooks.driver;

@Given("^User on walmart Homepage$")
    public void WalmartHomePage() throws IOException {
    ReadConfigFiles readConfigFiles = new ReadConfigFiles();
    Properties prop = readConfigFiles.getPropertyValue();
    String url = prop.getProperty("URL");
    LOGGER.info("URL is:" + url);
    ActOn.browser(driver).openBrowser(url);
}

@When("^User click on option and mousehover to movies and book and select new release movie$")
    public void frozenMouseHover(){
    new NavigationBar(driver)
            .OptionLink()
            .mouseHoverToBooksAndMovies()
            .Frozen2LInk();

}

@And("^User click on frozen 2$")
    public void FrozenTwo(){
    new MoviesCucumver(driver)
            .Frozen2NewMovie();
}

@Then("^User should be able to see the title \"(.+?)\"$")
    public void FrozenVal(String titlee){
    new MoviesCucumver(driver)
            .TitleVal(titlee);
}

@When("^User click on option and mousehover to movies and book and select Tv Show$")
    public void BingBangMousehover(){
    new NavigationBar(driver)
            .OptionLink()
            .mouseHoverToBooksAndMovies()
            .ShowLink();
}
@And("^User click on The Big Bang Theory$")
    public void TheBigBangShow(){
    new MoviesCucumver(driver)
            .TheBiGBAng();
}

    @When("^User click on option and mousehover to movies and book and select Complete Series$")
    public void CompleteSeriesMouseHover(){
    new NavigationBar(driver)
            .OptionLink()
            .mouseHoverToBooksAndMovies()
            .CompleteSeriesLink();
    }

    @And("^User click on Harry Potter$")
    public void HarryPotter(){
    new MoviesCucumver(driver)
            .HarryPotterSeries();
    }

    @When("^User click on option and mousehover to movies and book and select Shop Movies by Studio$")
    public void MoviesByStudio(){
    new NavigationBar(driver)
            .OptionLink()
            .mouseHoverToBooksAndMovies()
            .MoviesByStudioLink();
    }

    @And("^User click on Aladin$")
    public void aladinDvDfromMoviesByStudio(){
    new MoviesCucumver(driver)
            .AladinDvdLink();


    }
}
