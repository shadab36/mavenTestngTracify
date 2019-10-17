@pyarollpand_loginTest 
Feature: signin Test On Web Application 
@invalidLogintest 
Scenario: 
	Given Open the application url. 
Scenario Outline: Data driving for invalid sign-in. 
	Then Enter email address as "<EmailAddress>". 
	Then Enter the Password "<Pass>". 
	Then Click on Login CTA. 
	Then Verify user email "<EmailAddressVal>" validation message for Email Address. 
	Then Verify user pass "<PassVal>" validation message for Password. 
	Then Verify user error "<Signin_error_Msg>" message for all invalid credentials. 
	Examples: 
		|EmailAddress        |Pass     |EmailAddressVal                                                        |    PassVal                |Signin_error_Msg                            |
		|                    |         | Please fill out this field.                                           |Please fill out this field.|                                            |
		|test                |         |Please include an '@' in the email address. 'test' is missing an '@'.  |Please fill out this field.|                                            |
		|test@@gmail.com     |         |A part following '@' should not contain the symbol '@'.                |Please fill out this field.|                                            | 
		|test@gmail.com      |         |                                                                       |Please fill out this field.|                                            |
		|test@gmail.com      |1234     |                                                                       |                           |Invalid email or password. Please try again.|
    @validLogintest 
    Scenario Outline: valid data for SignIn 
	Given Open the application url. 
	Then Enter email address as "<EmailAddress>". 
	Then Enter the Password "<Pass>". 
	Then Click on Login CTA. 
	Then Verify the page title Go To Dashboard. 
	Then Verify the logout button. 
	Examples: 
		|EmailAddress               |Pass        |
		|qaautomation@getnada.com   |QaTest1234  |
		
		
	 