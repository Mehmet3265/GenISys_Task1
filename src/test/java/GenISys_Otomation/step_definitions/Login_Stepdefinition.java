package GenISys_Otomation.step_definitions;

import GenISys_Otomation.pages.LoginPage;
import GenISys_Otomation.pages.RegisterPage;
import GenISys_Otomation.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_Stepdefinition {

    LoginPage loginPage = new LoginPage();

    RegisterPage registerPage = new RegisterPage();
    BrowserUtils browserUtils = new BrowserUtils();

    String email;

    //SUCCESSFULLY LOGIN

    @And("user enters its email to email box and clicks to forward button")
    public void userEntersItsEmailToEmailBoxAndClicksToForwardButton() {
        email = registerPage.emailAdress();
        registerPage.emailBox.sendKeys(email);
        browserUtils.waitForClickablility(registerPage.forwardButton,3);
        registerPage.forwardButton.click();
    }
    @When("user clicks to returning user button and login panel opens")
    public void user_clicks_to_returning_user_button_and_login_panel_opens() {
        browserUtils.waitForClickablility(registerPage.registerLoginButton, 50);
        registerPage.registerLoginButton.click();
    }
    @When("user enters valid email and clicks forward button next to mail box")
    public void user_enters_valid_email_and_clicks_forward_button_next_to_mail_box() {
        loginPage.emailArea.sendKeys(email);
        browserUtils.waitForClickablility(loginPage.forwardbutton,3);
        loginPage.forwardbutton.click();
    }
    @Then("user should see the Fast Track texting displayed in the middle of the page")
    public void user_should_see_the_fast_track_crm_built_for_casino_sports_and_lottery_textis_displayed_in_the_middle_of_the_page() {
        Assert.assertTrue(loginPage.bigText.isDisplayed());
    }



}
