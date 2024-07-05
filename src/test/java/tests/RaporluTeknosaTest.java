package tests;

import org.testng.annotations.Test;
import pages.RaporluTeknosaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class RaporluTeknosaTest extends TestBaseRapor {
    RaporluTeknosaPage teknosa =new RaporluTeknosaPage();

    @Test
    public  void test01() throws InterruptedException {
        extentTest=extentReports.createTest("Teknosa arama testi");
        //extent reports kütüphanesinde bir test oluşturmak için kullanılır
        Driver.getDriver().get(ConfigReader.getProperty("urlTeknosa"));
        Thread.sleep(5000);
        extentTest.info("Kullanıcı anasayfasına gider");


        //burada bir hata var ama çözemedim
        Thread.sleep(2000);
        teknosa.search.sendKeys("ıphone 12 pro");
        extentTest.info("Arama kutusuna belirlenen kelime yazılır"); //her adımı testte görmek için kullanılan kod


    }
}
