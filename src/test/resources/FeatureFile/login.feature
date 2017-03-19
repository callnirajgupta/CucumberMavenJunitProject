@testBackground
Feature:  check the login page scenario

Background:
Given open browser

@testScenario
Scenario: login to gmail.simple scenario with one set of argument
Given user enter the  url "http://www.gmail.com"
When user enter the username "callnirajgupta" and password "abc"
Then user should able to login into "Gmail"

@testScenarioMultiple
Scenario Outline: login to multiple website with multiple data
Given user enter the  url "<URL>"
When user enter the username "<UserName>" and password "<Password>"
Then user should able to login into "<Title>"

Examples:
|URL                 |UserName      |Password|Title |
|http://www.gmail.com|callnirajgupta|abc     | Gmail|  
|http://www.yahoo.com|callnirajgupta|abcdef  | Yahoo| 


@TestScenarioAndBut
Scenario: scenario with And & But
Given I am a Facebook user
When I enter my username
And I enter my password
Then login should be successful.
But home page should not be missing.

@ScenarioTableSingleColumn
Scenario: datatable with single value
Given I am on a new user registration page
When I enter valid data on the page

| Fields                 |
| First Name             |
| Last Name              |
| Email Address          |
| Re-enter Email Address |
| Password               |
| Birthdate              |
Then the user registration should be successful.


@ScenarioTablemutiplecolumn
Scenario: datatable with mutilple value
Given I am on a new user registration page
When I enter valid data on the page registration page

| Fields                 |values|
| First Name             |Niraj|
| Last Name              |Gupta|
| Email Address          |callnirajgupta@gmail.com|
| Re-enter Email Address |callnirajgupta@gmail.com|
| Password               |abcde|
| Birthdate              |10/06/1980|
Then the user registration should be successful.

@ScenarioTablemutiplecolumnWithoutColumn
Scenario: datatable with multiple value column
Given I am on a new user registration page
When I enter valid data on the page registration page without knowing keys fields

| Fields                 |values|
| First Name             |Niraj|
| Last Name              |Gupta|
| Email Address          |callnirajgupta@gmail.com|
| Re-enter Email Address |callnirajgupta@gmail.com|
| Password               |abcde|
| Birthdate              |10/06/1980|
Then the user registration should be successful.


@Scenariobeforeanytag
Scenario: some step before this scenario
Given execute some some step before this given

@testwithInteger
Scenario: scenario
Given execute some some step before this given for number 11

