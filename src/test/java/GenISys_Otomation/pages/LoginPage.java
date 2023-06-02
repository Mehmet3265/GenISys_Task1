package GenISys_Otomation.pages;

import GenISys_Otomation.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[@class='button']")
    public WebElement returningUser;

    @FindBy(xpath = "//input[@class='input']")
    public WebElement emailArea;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement forwardbutton;

    @FindBy(xpath = "//h1[@class='big-text']")
    public WebElement bigText;
}
