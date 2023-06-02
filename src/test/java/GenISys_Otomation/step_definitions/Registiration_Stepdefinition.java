package GenISys_Otomation.step_definitions;

import GenISys_Otomation.pages.RegisterPage;
import GenISys_Otomation.utilities.BrowserUtils;
import GenISys_Otomation.utilities.ConfigurationReader;
import GenISys_Otomation.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Registiration_Stepdefinition {
    RegisterPage registerPage = new RegisterPage();

    BrowserUtils browserUtils = new BrowserUtils();

    public static String email;


    @Given("User is on tour page")
    public void user_is_on_tour_page() {
        Driver.getDriver().get(ConfigurationReader.get("url"));
    }
    @When("user clicks to new user button")
    public void user_clicks_to_new_user_button_and_lets_get_started_page_opens() {
        browserUtils.waitForClickablility(registerPage.newUser,3);
        registerPage.newUser.click();
    }
    @When("user clicks to CONTINUE button")
    public void user_clicks_to_ı_get_ıt_contınue() {
        browserUtils.waitForClickablility(registerPage.continueButton,3);
        registerPage.continueButton.click();
    }
    @When("user enters email to email box and clicks to forward button")
    public void user_enters_email_to_email_box_and_clicks_to_forward_button_next_to_email_box() {
        email = registerPage.emailAdress();
        registerPage.emailBox.sendKeys(email);
        browserUtils.waitForClickablility(registerPage.forwardButton,3);
        registerPage.forwardButton.click();
    }
    @When("user enters its phone number and clicks to forward button")
    public void user_enters_his_or_her_phone_number_with_the_country_code_and_clicks_to_forward_button_next_to_phone_box() {
        registerPage.countryCodeBox.sendKeys(registerPage.countrycode());
        registerPage.phoneNumberBox.sendKeys(registerPage.phoneNumber());
        browserUtils.waitForClickablility(registerPage.forwardButton,3);
        registerPage.forwardButton.click();
    }
    @When("user enters its name and clicks to forward button")
    public void user_enters_his_or_her_full_name_and_clicks_to_forward_button_next_to_full_name_box() {
        registerPage.nameBox.sendKeys(registerPage.userName());
        browserUtils.waitForClickablility(registerPage.forwardButton,3);
        registerPage.forwardButton.click();
    }
    @When("user enters its password  and clicks to forward button")
    public void user_enters_at_least_six_characters_of_password_and_clicks_to_button_next_to_password_box() {
        registerPage.passwordButton.sendKeys(registerPage.pasword());
        browserUtils.waitForClickablility(registerPage.forwardButton,3);
        registerPage.forwardButton.click();
    }
    @Then("user should see the complete message")
    public void user_should_see_the_your_registiration_is_complete_message_is_displayed_in_the_middle_off_the_page() {
        browserUtils.waitForVisibility(registerPage.successMessage);
        Assert.assertTrue(registerPage.successMessage.isDisplayed());

    }

}
