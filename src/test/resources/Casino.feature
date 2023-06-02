Feature: Casino

  @Casino
  Scenario: As a user I shouldn't be able to play on casino without money.
    Given User successfully navigates to home page
    And user clicks to game options
    And user selects the casino option
    And user clicks to bet dropdown and selects the first option
    Then user clicks the picture of the first cat and gets the warning alert

  @WinAndLose
  Scenario: As a user I should see the wallet changes properly according to winning and losing situations
    Given User navigates to home page
    When user clicks to game options
    And user selects the casino option
    And user clicks to wallet button
    And user chooses FastTrackBonus from bonus dropdown
    And user clicks to forth option
    And user approves the deposit and sees success message
    And click to ok button
    And user clicks to bet dropdown and selects the first option
    Then user clicks to first two pictures of cats and verifies the changes on the wallet


