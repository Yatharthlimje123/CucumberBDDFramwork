Feature: Login
@sanity @Regrresion
Scenario: Scessfully Log in With valid credential 

When User launch Crome Browser
Given User Open Url "https://www.saucedemo.com/"
And User enter email as "standard_user" and password as "secret_sauce"
And Click on login button
Then Page of home page title Should be "Swag Labs"
When User Click on Log out button
And Close browser
@smoke
Scenario: Successfully Log in With valid credentials with Data driven

When User launch Crome Browser
Given User Open Url "https://www.saucedemo.com/"
And User enter email as "<Email>" and password as "<Password>"
And Click on login button
Then Page of home page title Should be "Swag Labs"
When User Click on Log out button
And Close browser

Examples:
| Email          | Password     |
| standard_user  | secret_sauce |
| standard_user  | secret_sauce |
#|standard_user1||secret_sauce1|