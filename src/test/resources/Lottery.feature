Feature:Lottery

@Lottery
Scenario: As a user I should buys, add and delete lotteries and checks the changes in the wallet.
Given User navigates to home page
When user clicks to game options
And user selects the lottery option
And user adds two tickets
And user deletes thee first ticket and accepts the alert
And user selects seven options from each ticket
And user checks wallet and clicks to draws dropdown, selects an option whichs price is lower than the wallet
And user selects buy ticket
Then user checks the wallet if it is lessened properly according to the price of option
