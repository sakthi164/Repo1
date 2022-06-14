Feature: functionality of the facebook web application
Scenario Outline: user enter the login data in application
Given user launch the application
When user enters the valid "<Username>" in the username field
When user enters the valid "<Password>" in the password field
And user clicks the submit button
Then user verifies the homepage

Examples:
|Username|Password|
|ASDD@gmail.com|4512|
|abc@gmail.com|65gfd|
|xyz@gmail.com|9596|