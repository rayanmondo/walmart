package page_object;

import command_providers.ActOn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar {
    private static final By ebookOption = By.xpath("//*[@id='header-Header-sparkButton']/span[@class='g_b']");
    private static final By ebookMousehoverMoviesnBook = By.xpath("//*[@id='vh-department-menu']//span[text()='Movies, Music & Books']");
    //ebook
    private static final By selectEbookType = By.xpath("//*[@id='dept-l5zGKEY--children']//div[text()='eBooks']");
    //textbook
    private static final By selectTypeBook=By.xpath("//*[@id='dept-l5zGKEY--children']//div[text()='Textbooks']");
    //mandalorian
    private static final By selectTypeCollection =By.xpath("//*[@id='dept-l5zGKEY--children']//div[text()='The Mandalorian']");

    //over the moon
    private static final By overTheMoon=By.xpath("//*[@id='dept-l5zGKEY--children']//div[text()='Over the Moon']");
    //disney
    private static final By disneynFromBooks =By.xpath("//*[@id='dept-l5zGKEY--children']//div[text()='Disney Books ']");

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    //Frozen  2
    private static final By newMovies=By.xpath("//*[@id='dept-l5zGKEY--children']//a[1]/div[text()='New Release Movies']");

    //tv show
    private static final By tvShowOption =By.xpath("//*[@id='dept-l5zGKEY--children']//div[text()='TV Shows  ']");

    //Harry pOtter
    private static final By selecCompleteSeries =By.xpath("//*[@id='dept-l5zGKEY--children']//div[text()='Complete Series & Box Sets  ']");

    //Aladin
    private static final By ShopMoviesByStudio=By.xpath("//*[@id='dept-l5zGKEY--children']//div[text()='Shop by Studio']");

    WebDriver driver;



    public NavigationBar(WebDriver driver) {
        this.driver = driver;
    }
    public NavigationBar OptionLink(){
        ActOn.element(driver,ebookOption).click();
        return this;

    }

    public NavigationBar mouseHoverToBooksAndMovies() {
        ActOn.element(driver, ebookMousehoverMoviesnBook).mouseHover();
        return this;
    }


    //ebook
    public BooksCucumber clickToLinkEbook() {
        ActOn.element(driver, selectEbookType).click();
        return new BooksCucumber(driver);
    }


    //textbook
    public BooksCucumber ClickToTextBook(){
        ActOn.element(driver,selectTypeBook).click();
        return new BooksCucumber(driver);
}

    //mandalorian
    public BooksCucumber clickToMandalorinLink(){
        ActOn.element(driver,selectTypeCollection).click();
        return new BooksCucumber(driver);
    }

    //over the moon
    public BooksCucumber OverTHeMoonLink(){
        ActOn.element(driver,overTheMoon).click();
        return new BooksCucumber(driver);
    }

    //disney
    public BooksCucumber disneyLink(){
        ActOn.element(driver, disneynFromBooks).click();
        return new BooksCucumber(driver);
    }
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    //Frozen 2
    public MoviesCucumver Frozen2LInk(){
        ActOn.element(driver,newMovies).click();
        return new MoviesCucumver(driver);
    }

    //tv show
    public MoviesCucumver ShowLink(){
        ActOn.element(driver,tvShowOption).click();
        return new MoviesCucumver(driver);
    }
    //complete Series
    public MoviesCucumver CompleteSeriesLink(){
        ActOn.element(driver,selecCompleteSeries).click();
        return new MoviesCucumver(driver);
    }

    //Shop Movies By Studio
    public  MoviesCucumver MoviesByStudioLink(){
        ActOn.element(driver,ShopMoviesByStudio).click();
        return new MoviesCucumver(driver);
    }

}
