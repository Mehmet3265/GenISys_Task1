Feature: Login

  @Login
  Scenario: As a user, I should be able to login properly
    Given User is on tour page
    When user clicks to new user button
    And user clicks to CONTINUE button
    And user enters its email to email box and clicks to forward button
    And user enters its phone number and clicks to forward button
    And user enters its name and clicks to forward button
    And user enters its password  and clicks to forward button
    Then user should see the complete message
    When user clicks to returning user button and login panel opens
    And user enters valid email and clicks forward button next to mail box
    Then user should see the Fast Track texting displayed in the middle of the page


