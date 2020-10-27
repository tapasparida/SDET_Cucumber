@jobBoard2
Feature: Job Board Job Search

Scenario Outline: Job Search activity
    Given Open the Browser and go to Job Board site "<uName>" and "<pWord>"
    And Find Search input search jobs change jobtype
    When Filter Fulltime jobs
    And Find job listing and job details
    Then Apply job
    And Close the Browser
    
    
    
    Examples:
    |uName| pWord   | uNameAssert | NewUser  |email|
    |root | pa$$w0rd| sdet3BDD     | sdet3BDD |sdet3BDD@domain.com|
    