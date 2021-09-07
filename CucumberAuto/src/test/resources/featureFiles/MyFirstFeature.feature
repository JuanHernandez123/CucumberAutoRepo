Feature: Create account of Facebook 
	As a user I need to open Facebook home page and do the validations
	
@test1 @all 
Scenario: Validate First Name field 
	When User enters user "David" first name 
	Then User checks user "David" name is present 
	
@test2 @all 
Scenario: Validate create user multiple fields 
	When User enters user "Ryan" first name 
	And User enters user "Jack" surname 
	Then User checks user "Ryan" name is present 
	Then User Mobile field should be blank 
	
@test3 @all 
Scenario: Validate create user multiple fields With table
	When Enter following data 
		|userName|userSurname|Mobile|
		|Tom     |Hanks      |1234  |
		|Jack    |Daniel     |5678  |
		|Josue   |Henry      |91011 |
		
@test4 @all 
Scenario Outline: Validate create user multiple fields with Examples table 
	When User enters user "<username>" first name 
	And User enters user "<surname>" surname 
	Then User checks user "<username>" name is present 
	Then User Mobile field should be blank 
	Examples: 
		|username|surname|
		|Josept  |Dong   |
		|Harry   |Clain  |