Feature:Admin

@Smoke
Scenario: Login With valid credentials

Given user launch the browser
And User visit the url "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
When user enter the username "admin@yourstore.com" and Password "admin"
Then user click on login button
And validate the title "Dashboard / nopCommerce administration"
Then close the browser

@Sanity
Scenario Outline: Login with Data Driven

Given user launch the browser
And User visit the url "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
When user enter the username "<Email>" and Password "<Password>"
Then user click on login button
And validate the title "Dashboard / nopCommerce administration"
Then close the browser

Examples:
|Email                 | Password|
|admin@yourstore.com   |  admin  |
|admin24@yourstore.com |  admin  |
|admin@yourstore.com   |  admi   |
