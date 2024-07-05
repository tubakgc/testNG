package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RaporluTeknosaPage {
    public RaporluTeknosaPage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }
   @FindBy(xpath = "//input[@type='text']")
    public WebElement search;


}
