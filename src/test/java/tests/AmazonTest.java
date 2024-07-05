package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static utilities.Driver.quitDriver;

public class AmazonTest {
    public WebDriver driver;
    AmazonPage amazon =new AmazonPage();

    @Test
    public void searchProduct(){
        driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("urlAmazon"));

        //1.ADIM arama kutusuna "samsung note " yazılır
        amazon.searchBox.sendKeys(ConfigReader.getProperty("textSearch"));
        amazon.searchButton.click();


        //css sınıfına ait olan başlığı bul liste yap
        List<WebElement> productTitles=driver.findElements(By.cssSelector(".a-size-medium.a-color-base.a-text-normal"));
        for (WebElement productTitle:productTitles) {
            String title=productTitle.getText();
            System.out.println(title);

        }

        int actualTitleCount=productTitles.size();
        System.out.println("Başlık sayısı : " +actualTitleCount);

        int expectedTitleCount=23;

        assertEquals(actualTitleCount,expectedTitleCount);

        assertEquals(actualTitleCount,expectedTitleCount,"Başlık sayısı başarısız.Beklnen:"+expectedTitleCount);

        //sayfanın en altına gidilir.
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight/2)");

        quitDriver();
    }
}
