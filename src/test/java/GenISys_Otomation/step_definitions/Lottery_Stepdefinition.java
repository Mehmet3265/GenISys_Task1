package GenISys_Otomation.step_definitions;

import GenISys_Otomation.pages.LotteryPage;
import GenISys_Otomation.utilities.BrowserUtils;
import GenISys_Otomation.utilities.Driver;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Lottery_Stepdefinition {

    BrowserUtils browserUtils = new BrowserUtils();
    LotteryPage lotteryPage = new LotteryPage();

    int walletBefore;
    //User plays lottery
    @And("user selects the lottery option")
    public void user_seleckts_the_lottery_option() {
        browserUtils.waitForClickablility(lotteryPage.lotteryOption,3);
        lotteryPage.lotteryOption.click();
    }
    @And("user adds two tickets")
    public void user_adds_two_tickets() {
        lotteryPage.addingTicket(2);

    }
    @And("user deletes thee first ticket and accepts the alert")
    public void user_deletes_thee_first_ticket() {

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(lotteryPage.deleteButton).perform();
        browserUtils.waitForClickablility(lotteryPage.deleteButton,3);
        lotteryPage.deleteButton.click();
        Alert ticketAlert=Driver.getDriver().switchTo().alert();
        ticketAlert.accept();
    }
    @And("user selects seven options from each ticket")
    public void user_selects_seven_options_from_each_ticket() {
        lotteryPage.clickTickets(lotteryPage.tickets());
        walletBefore=lotteryPage.walletValuee();
    }
    @And("user checks wallet and clicks to draws dropdown, selects an option whichs price is lower than the wallet")
    public void user_clicks_to_draws_dropdown_and_selects_an_option_whichs_price_is_lower_than_the_wallet() {
        Select draws = new Select(lotteryPage.drawsDropdown);
        draws.selectByIndex(1);
    }
    @And("user selects buy ticket")
    public void user_selects_buy_ticket() {
        browserUtils.waitForClickablility(lotteryPage.buyTicket,3);
        lotteryPage.buyTicket.click();
    }
    @And("user checks the wallet if it is lessened properly according to the price of option")
    public void user_checks_the_wallet_if_it_is_lessened_properly_according_to_the_price_of_option() {
        browserUtils.sleep(2);
        int walletAfter = lotteryPage.walletValuee();
        Assert.assertTrue(walletAfter<=walletBefore);
    }

}
