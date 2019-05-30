Feature: Login into Stack overflow account
Scenario: Login into account with correct credentials
Given User navigates to stack overflow website
And User clicks on the Login button
And User enters a valid username
And User enters a valid password
When User clicks on Login button
Then User should be taken to the successful login page    
