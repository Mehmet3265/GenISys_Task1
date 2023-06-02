package GenISys_Otomation.pages;

import GenISys_Otomation.utilities.BrowserUtils;
import GenISys_Otomation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class LotteryPage extends HomePage {
    BrowserUtils browserUtils = new BrowserUtils();

    public LotteryPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[normalize-space()='Add another ticket']")
    public WebElement addTicket;

    @FindBy(xpath = "((//button[@class=\"remove-line\"])/img)[1]")
    public WebElement deleteButton;

    @FindBy(xpath = "//select[@class='form-input']")
    public WebElement drawsDropdown;

    @FindBy(xpath = "//button[@class='button button--secondary']")
    public WebElement buyTicket;

    @FindBy(xpath = "//button[@class='button money']")
    public WebElement moneyButton;


    //user defines that how much tickets does he/she wants to add
    public void addingTicket(int times) {
        for (int i = 0; i < times; i++) {
            browserUtils.waitForClickablility(addTicket, 3);
            addTicket.click();
        }
    }

    public List<WebElement> tickets() {
        List<WebElement> tickeElements = Driver.getDriver().findElements(By.xpath("//div[@class=\"lottery-ticket__inner\"]"));
        return tickeElements;
    }

    public List<WebElement> numbers() {
        List<WebElement> elements = Driver.getDriver().findElements(By.xpath("//div[@class=\"lottery-ticket__number\"]"));
        return elements;
    }

    public void clickTickets(List<WebElement> tickets) {
        for (int i = 0; i < tickets.size(); i++) {
            int number = 50;
            List<Integer> choosenNumbers = new ArrayList<>();
            int count = 0;
            while (count < 7) {
                int randomNumber;
                if (i == 0) {
                    randomNumber = (int) (Math.random() * (number * (i + 1))+number*i); //0-49
                } else {
                    randomNumber = (int) (Math.random() * (number * (i)) + number*i); //50-99
                }
                System.out.println(randomNumber);
                // new Random(50).nextInt();
                if (!(choosenNumbers.contains(randomNumber + 1))) {
                    numbers().get(randomNumber).click();
                    choosenNumbers.add(randomNumber + 1);
                    System.out.println(choosenNumbers);
                    count++;
                }
            }
        }
    }

    public int walletValuee() {
        String wallet = walletButton.getText().substring(1, walletButton.getText().length() - 3);
        int value = Integer.parseInt(wallet);
        return value;
    }


}
