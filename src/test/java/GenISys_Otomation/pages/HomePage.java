package GenISys_Otomation.pages;

import GenISys_Otomation.utilities.BrowserUtils;
import GenISys_Otomation.utilities.ConfigurationReader;
import GenISys_Otomation.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends LoginPage{
    BrowserUtils browserUtils = new BrowserUtils();
    LoginPage loginPage = new LoginPage();

      public HomePage(){
             PageFactory.initElements(Driver.getDriver(),this);
      }

    @FindBy(xpath = "//div[@id='navigation']")
    public WebElement menuButton;

    @FindBy(xpath = "//button[@class='button money']/..")
    public WebElement walletButton;

    @FindBy(xpath = "//a[normalize-space()='Casino']")
    public WebElement casinoOption;

    @FindBy(xpath = "//a[@href=\"/lottery\"]")
    public WebElement lotteryOption;



    public void loginWithMoney(){
        Driver.getDriver().get(ConfigurationReader.get("url"));
        browserUtils.waitForClickablility(loginPage.returningUser, 3);
        loginPage.returningUser.click();
        loginPage.emailArea.sendKeys("withMoney@gmail.com");
        browserUtils.waitForClickablility(loginPage.forwardbutton,3);
        loginPage.forwardbutton.click();
    }

}
