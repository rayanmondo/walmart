package page_object;

import command_providers.ActOn;
import command_providers.AssertThat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BooksCucumber extends NavigationBar{

   //ebook
    private static final By ebookName = By.xpath("/html/body//a/div[1][@title='Chaos Walking Movie Tie-in Edition: The Knife of Never Letting Go ebook by Patrick Ness']");

    //textbook
    private static final By businessAndMoney=By.id("65c82341-6ee6-42f3-9330-bb51b521e681-tileLink-0");
    private static final By extremeOwnership =By.xpath("//*[@id='searchProductResult']//span[text()='Extreme Ownership : How U.S. Navy Seals Lead and Win']");
 //mandalorian
 private static final By mandalorianCollection =By.xpath("//*[@id='cp-center-module-0']//a[@data-product-id='6W3V8Z8HVGPW']");
 //over the moon
 private static final By BungeePush=By.xpath("//*[@id='cp-center-module-1']//a[@data-product-id='71YKHKNNAKQV']");
 //disney
    private static final By worldOfReadingDisney =By.xpath("//*[@id='searchProductResult']//span[text()='World of Reading: This Is Spider-Man Level 1 Reader (Paperback)']");


    public BooksCucumber(WebDriver driver) {
        super(driver);
    }

    //ebook

    public BooksCucumber chaosWalking(){
        ActOn.element(driver,ebookName).click();
        return this;
    }
    public BooksCucumber writerNameVal(String Writername){
        // LOGGER.info("expected total monthly payment"+totalMonthlyPayment);
        By Name=By.xpath("/html/body//a[text()='" +Writername+ "']");
        AssertThat.elementAssertions(driver,Name).elementExist();
        return this;
    }

    //textbook
    public BooksCucumber selectTextBookCategory(){
        ActOn.element(driver,businessAndMoney).click();
        return this;
    }
    public BooksCucumber selectTextBookStrong(){
        ActOn.element(driver,extremeOwnership).click();
        return this;
    }

    public BooksCucumber Validationtitle(String titleValue){
        By titleText=By.xpath("//*[@id='product-overview']//h1[contains(text(),'" +titleValue+ "')]");
        AssertThat.elementAssertions(driver,titleText).elementExist();
        return this;
    }

    //mandalorian
    public BooksCucumber mandalorianTwinBed(){
        ActOn.element(driver,mandalorianCollection).click();
        return this;
    }

    //over the moon
    public BooksCucumber BungeeLink(){
        ActOn.element(driver,BungeePush).click();
        return this;
    }

    //disney
    public BooksCucumber DisneyBookItem(){
        ActOn.element(driver, worldOfReadingDisney).click();
        return this;
    }



//    public BooksCucumber enterCalculateButton(){
//        ActOn.element(driver,calculateButton).click();
//        return this;
//    }
//    public BooksCucumber priceVal(String totalMonthlyPayment){
//        // LOGGER.info("expected total monthly payment"+totalMonthlyPayment);
//        By monthlyPaymentLocator=By.xpath("//*[@id='analysisDiv']/table[3]//td[2][text()='"+totalMonthlyPayment+"']");
//        AssertThat.elementAssertions(driver,monthlyPaymentLocator).elementExist();
//        return this;
////    public Refi_Calculate priceVal(String expextedValue){
////        String refiCal=ActOn.element(driver,monthlyPayment).getTextValue();
////        Assert.assertEquals(refiCal,expextedValue);
////        return this;
//    }
}
