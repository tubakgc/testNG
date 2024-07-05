package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    //selenıum web driver yönetmek ve tarayıcı yapılandırmak için
    private static WebDriver driver; //webdriver tutan statik bir değişken

    private Driver() {

        //constructor - driver sınıfının dışında nesne oluşturmayı engeller

    }

    public static WebDriver getDriver() {

        //yönetilen webdriver nesnesini döndğren metot

        String Browser = ConfigReader.getProperty("browser");

        if (driver == null) {
            switch (Browser) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;

                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();

            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); //bulunmayan bir lement için bekle

        }
        return driver;
    }
    //webdriver kapatır ve sıfırlar
    public static void closeDriver(){
        if (driver!=null){
            driver.close();
            driver=null;
        }

    }
    //webdriverı kapatır ve bütün sayları kapaıtr sıfırlar
     public static void quitDriver(){
         if (driver!=null){
             driver.quit();
             driver=null;
         }

     }

}
