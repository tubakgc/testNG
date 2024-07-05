package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestBaseRapor {
    protected  static ExtentReports extentReports; //extent reports örneği referansı tutar

    protected  static ExtentTest extentTest; // testin başarısını yada başarısızlığını tutar, ekran görüntüsü yakalamak için
    protected  static ExtentHtmlReporter extentHtmlReporter; //html raporunu oluşturur

    @BeforeTest(alwaysRun = true)
    public void setUpTest(){
        extentReports=new ExtentReports(); //extent reportsu başlatır
        //html raporu için dosyayolu ve adını belirler
        String date=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String filePath = System.getProperty("user.dir")+"/test-output/Rapor" + date +".html";
        extentHtmlReporter=new ExtentHtmlReporter(filePath);
        extentReports.attachReporter(extentHtmlReporter);


        //rapor için ek sistem bilgilerini belirle
        extentReports.setSystemInfo("Environnement", "QA");
        extentReports.setSystemInfo("Navigator",ConfigReader.getProperty("browser"));
        extentReports.setSystemInfo("Matematikçi","Tuğba");
        extentHtmlReporter.config().setDocumentTitle("e2e Testing"); //raporun belge başlığı
        extentHtmlReporter.config().setReportName("TestNG Reports"); //rapor adını belirle

    }

    //her bir test metodundan sonra başarısıxlık durumunun ekran görüntüsüs alır ve sürücüyü kapatır
    @AfterMethod(alwaysRun = true)
    public void tearDownMethod(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE){
            //test başarısız ise ekran görüntüsü yakala ve rapora ekle
            String screenshotLocation =ReusableMethods.getScreenshot(result.getName());
            extentTest.fail(result.getName()); //testi başarısız olarak kaydet
            extentTest.addScreenCaptureFromPath(screenshotLocation);//ekran görüntüsünü raporaekle
            extentTest.fail(result.getThrowable());//hata ayrıntılarını kaydet

        } else if (result.getStatus()==ITestResult.SKIP) {
            //atlanan testi kaydet
            extentTest.skip("Test durumu atlama :" + result.getName());

        }
        Driver.closeDriver();//her test metodundan sonra sürücüyü kapat
    }

    //raporlamayı tamamlamak için raporu kaydedip sonlandırır
    @AfterTest(alwaysRun = true)
    public void tearDownTest(){
        extentReports.flush();
    }
}
