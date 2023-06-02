Feature:Registiration

@Register
Scenario: As a user, I should be able to register properly
Given User is on tour page
When user clicks to new user button
And user clicks to CONTINUE button
And user enters email to email box and clicks to forward button
And user enters its phone number and clicks to forward button
And user enters its name and clicks to forward button
And user enters its password  and clicks to forward button
Then user should see the complete message
