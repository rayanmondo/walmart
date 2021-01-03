package page_object;

import command_providers.ActOn;
import command_providers.AssertThat;
import io.cucumber.java.en_old.Ac;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MoviesCucumver extends NavigationBar{
    // frozen 2
    private static final By selectMovieFro=By.xpath("//*[@id='searchProductResult']//span[text()='Frozen II (DVD)']");
    //tv show
    private static final By bigbangShow=By.xpath("//*[@id='searchProductResult']//span[text()='The Big Bang Theory: The Complete Series (DVD)']");
    //harry potter
    private static final By selecHarryPotter=By.xpath("//*[@id='searchProductResult']//span[text()='Harry Potter: The Complete 8-Film Collection (DVD)']");
    //Aladin
    private static final By selectAladin=By.xpath("//*[@id='searchProductResult']//span[text()='Aladdin (DVD)']");

    public MoviesCucumver(WebDriver driver) {
        super(driver);
    }

    public MoviesCucumver Frozen2NewMovie(){
        ActOn.element(driver,selectMovieFro).click();
        return this;
    }

    public MoviesCucumver TitleVal(String value){
        By title=By.xpath("//*[@id='product-overview']//h1[text()='" +value+ "']");
        AssertThat.elementAssertions(driver,title).elementExist();
        return this;
    }

    public MoviesCucumver TheBiGBAng(){
        ActOn.element(driver,bigbangShow).click();
        return this;
    }
    public MoviesCucumver HarryPotterSeries(){
        ActOn.element(driver,selecHarryPotter).click();
        return this;
    }

    public MoviesCucumver AladinDvdLink(){
        ActOn.element(driver,selectAladin).click();
        return this;
    }
}
