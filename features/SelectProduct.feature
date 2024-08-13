Feature: Product purchase
@Regrresion
Scenario: Purchase the produt for customer

When User launch Crome Browser
Given User Open Url "https://www.saucedemo.com/"
And User enter email as "standard_user" and password as "secret_sauce"
And Click on login button
Then Page of home page title Should be "Swag Labs"
And customer should click on product 
Then user can see the productPage detail
And click on addToCard button
And Click on back to product List page
When  user can see product list page "Swag Labs"
And  Click on Crat Icone
And Click on Checkout button
Then user can see the checkout information page 
And user entert the name "Aman" and last name "Varma" and Pincode "23456"
And click on continue button
Then user can view Checkout Overview page 
And  Click on finish button
Then user can see the thank you page
And click on Back t home page button
And click on logout button

 


