package GenISys_Otomation.pages;

import GenISys_Otomation.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    public RegisterPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//button[@class='button register']")
    public WebElement newUser;

    @FindBy(xpath = "//button[@class='button button--intro']")
    public WebElement continueButton;

    @FindBy(xpath = "//input[@placeholder='Enter Email']")
    public WebElement emailBox;


    @FindBy(xpath = "//button[@type='submit']")
    public WebElement forwardButton;

    @FindBy(xpath = "//input[@type=\"text\"]")
    public WebElement countryCodeBox;

    @FindBy(xpath = "//input[@type=\"number\"]")
    public WebElement phoneNumberBox;

    @FindBy(xpath = "//input[@placeholder='Enter your name']")
    public WebElement nameBox;

    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement passwordButton;

    @FindBy(xpath = "//h3[contains(text(),'✨ Your registration is complete! ✨')]")
    public WebElement successMessage;

    @FindBy(xpath = "//button[@class='button button--secondary']")
    public WebElement registerLoginButton;



    Faker faker =new Faker();

    public  String firstname(){
        String firstName = faker.name().firstName();
        return firstName;
    }

    public  String lastName(){
        String lastName = faker.name().lastName();
        return lastName;
    }

    public  String userName(){
        String userName= firstname()+" "+lastName();
        return userName;
    }

    public  String emailAdress(){
        String emailAdress=firstname()+"@gmail.com";
        return emailAdress;
    }

    public  String pasword(){
        String password = faker.bothify("??##?#");
        return password;
    }

    public String countrycode(){
        String countrycode= "+"+faker.numerify("##");
        return countrycode;
    }

    public  String phoneNumber(){
        String phoneNumber= faker.numerify("######");
        return phoneNumber;
    }


}
