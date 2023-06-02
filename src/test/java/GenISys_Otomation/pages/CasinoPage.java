package GenISys_Otomation.pages;

import GenISys_Otomation.utilities.BrowserUtils;
import GenISys_Otomation.utilities.ConfigurationReader;
import GenISys_Otomation.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CasinoPage extends HomePage{

    LoginPage loginPage = new LoginPage();
    BrowserUtils browserUtils = new BrowserUtils();

    public CasinoPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//header[@class=\"game__header\"])/div[5]/select")
    public WebElement betDropdown;

    @FindBy(xpath = "//iframe[@src=\"/game-page\"]")
    public WebElement catIframe;

    @FindBy(xpath = "(//div[@class='option'])[1]")
    public WebElement firstCat;

    @FindBy(xpath = "(//div[@class='option'])[2]")
    public WebElement secondCat;

    @FindBy(xpath = "(//div[@class='option'])[3]")
    public WebElement thirdCat;

    @FindBy(xpath = "(//div[@class='option'])[4]")
    public WebElement forthCat;

    @FindBy(xpath = "(//h3[@class=\"deposit__sub-title\"])[1]")
    public WebElement depositeMethodMessage;

    @FindBy(xpath = "//select[@class=\"form-input\"]")
    public WebElement depositeDropdown;

    @FindBy(xpath = "(//button[@class=\"button button--deposit\"])[3]")
    public WebElement eWalletButton;

    @FindBy(xpath = "(//button[@class=\"button button--deposit\"])[7]")
    public WebElement fiveHundred;

    @FindBy(xpath = "//button[normalize-space()='Deposit Approved']")
    public WebElement approveButton;

    @FindBy(xpath = "//h3[contains(text(),'✨ Your deposit was successful! ✨')]")
    public WebElement depositSuccess;

    @FindBy(xpath = "//button[normalize-space()='OK']")
    public WebElement depositeOKbutton;



    public List<WebElement> cats(){
        List<WebElement> elements = Driver.getDriver().findElements(By.xpath("//div[@class='option']"));
        return elements;
    }

    public void clickCats() {
        List<WebElement> elements = Driver.getDriver().findElements(By.xpath("//div[@class='option']"));
        Driver.getDriver().switchTo().frame(catIframe);
        for (int i = 0; i <4 ; i++) {
            elements.get(i).click();
            browserUtils.sleep(1);
            Alert catAlert = Driver.getDriver().switchTo().alert();
            Assert.assertTrue(catAlert.getText().equals("Lower your bet to play again."));
            catAlert.accept();
        }
        Driver.getDriver().switchTo().defaultContent();
    }

    public void loginNoMONEY(){
        Driver.getDriver().get(ConfigurationReader.get("url"));
        browserUtils.waitForClickablility(loginPage.returningUser, 3);
        loginPage.returningUser.click();
        loginPage.emailArea.sendKeys("nobudget@gmail.com");
        browserUtils.waitForClickablility(loginPage.forwardbutton,3);
        loginPage.forwardbutton.click();
    }

    public int walletValue(){
        String wallet = walletButton.getText().substring(1,walletButton.getText().length()-3);
        int value = Integer.parseInt(wallet);
        return value;
    }

    public void catWinScenario(WebElement element){
        int beforeValue= walletValue();
        Driver.getDriver().switchTo().frame(catIframe);
        browserUtils.waitForClickablility(element,3);
        element.click();
        browserUtils.sleep(5);
        Driver.getDriver().switchTo().defaultContent();
        int afterValue = walletValue();
        Assert.assertTrue(beforeValue<=afterValue);
    }

    public void catLoseScenario(WebElement element){
        int beforeValue= walletValue();
        Driver.getDriver().switchTo().frame(catIframe);
        browserUtils.waitForClickablility(element,3);
        element.click();
        browserUtils.sleep(5);
        Driver.getDriver().switchTo().defaultContent();
        int afterValue = walletValue();
        Assert.assertTrue(afterValue<=beforeValue);
    }




}
