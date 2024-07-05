package tests;

import org.testng.annotations.Test;
import pages.UdemyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class UdemyTest {
  UdemyPage udemyPage=new UdemyPage();
    @Test
    public void testUdemy(){
        //udemy sayfasına git

        Driver.getDriver().get(ConfigReader.getProperty("urlUdemy"));

        //udemy.searchBox.sendKeys(ConfigReader.getProperty("textAppium"));



    }
}
