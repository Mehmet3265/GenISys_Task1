package GenISys_Otomation.step_definitions;

import GenISys_Otomation.pages.CasinoPage;
import GenISys_Otomation.pages.HomePage;
import GenISys_Otomation.utilities.BrowserUtils;
import GenISys_Otomation.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.Select;

public class Casino_Stepdefination {

    BrowserUtils browserUtils = new BrowserUtils();
    CasinoPage casinoPage = new CasinoPage();
    HomePage homePage = new HomePage();

    int catWalletBefore;

    //User plays on Casino
    @Given("User successfully navigates to home page")
    public void user_successfully_navigates_to_home_page() {
        casinoPage.loginNoMONEY();
    }

    @And("user clicks to game options")
    public void user_clicks_to_game_options() {
        browserUtils.waitForClickablility(casinoPage.menuButton,3);
        casinoPage.menuButton.click();
    }
    @And("user selects the casino option")
    public void user_selects_the_casino_option() {
        browserUtils.waitForClickablility(casinoPage.casinoOption,3);
        casinoPage.casinoOption.click();
    }
    @And("user clicks to bet dropdown and selects the first option")
    public void user_clicks_to_bet_dropdow_and_selects_the_first_optin() {
        Driver.getDriver().switchTo().frame(casinoPage.catIframe);
        Select select = new Select(casinoPage.betDropdown);
        select.selectByIndex(0);
        Driver.getDriver().switchTo().defaultContent();
    }
    @Then("user clicks the picture of the first cat and gets the warning alert")
    public void user_clicks_the_picture_of_cats_one_by_one_and_gets_the_warning_alert() {

        Driver.getDriver().switchTo().frame(casinoPage.catIframe);
        browserUtils.waitForClickablility(casinoPage.firstCat,3);
        casinoPage.firstCat.click();
        Alert alert = Driver.getDriver().switchTo().alert();
        Assert.assertTrue(alert.getText().equals("Lower your bet to play again."));
        alert.accept();

    }




    //Win and lose scenario in casino

    @Given("User navigates to home page")
    public void userNavigatesToHomePage() {
        browserUtils.sleep(1);
        homePage.loginWithMoney();
    }
    @When("user clicks to wallet button")
    public void user_clicks_to_wallet_button_and_sees_deposite_methods() {
        //catWalletBefore =casinoPage.walletValue();
        browserUtils.waitForClickablility(casinoPage.walletButton,3);
        casinoPage.walletButton.click();
    }
    @When("user chooses FastTrackBonus from bonus dropdown")
    public void user_chooses_fast_track_bonus_from_bonus_dropdown_and_and_sees_deposit_aamounts_message() {
        Select bonusDropdown = new Select(casinoPage.depositeDropdown);
        bonusDropdown.selectByIndex(3);
        browserUtils.waitForClickablility(casinoPage.eWalletButton,3);
        casinoPage.eWalletButton.click();
    }

    @When("user clicks to forth option")
    public void user_clicks_to_forth_option_and_gets_deposit_status_message() {
        browserUtils.waitForClickablility(casinoPage.fiveHundred,3);
        casinoPage.fiveHundred.click();

    }

    @When("user approves the deposit and sees success message")
    public void user_approves_th_deposit_and_sees_succesfull_message_and_click_to_ok_button() {
        browserUtils.waitForClickablility(casinoPage.approveButton,3);
        casinoPage.approveButton.click();
        browserUtils.waitForVisibility(casinoPage.depositSuccess);
        Assert.assertTrue(casinoPage.depositSuccess.isDisplayed());
    }

    @And("click to ok button")
    public void clickToOkButtonAndSeesTheWalletIncreasedFiveHundredEuros() {
        browserUtils.waitForClickablility(casinoPage.depositeOKbutton,3);
        casinoPage.depositeOKbutton.click();
    }


    @Then("user clicks to first two pictures of cats and verifies the changes on the wallet")
    public void user_clicks_the_picture_of_cats_one_by_one_and_checsk_if_wallets_amount_changes_properly() {

//        int beforeValue= casinoPage.walletValue();
//        Driver.getDriver().switchTo().frame(casinoPage.catIframe);
//        browserUtils.waitForClickablility(casinoPage.firstCat,3);
//        casinoPage.firstCat.click();
//        browserUtils.sleep(5);
//        Driver.getDriver().switchTo().defaultContent();
//        int afterValue = casinoPage.walletValue();
//        Assert.assertTrue(beforeValue<=afterValue);
        casinoPage.catWinScenario(casinoPage.firstCat);
        casinoPage.catLoseScenario(casinoPage.secondCat);

    }



}
