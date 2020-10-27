@jobBoard1
Feature: Job Board New User

Scenario Outline: Create New User
    Given Open Browser and go to Job Board site
    When User entered username and password "<uName>" and "<pWord>"
    Then Create New User from left menu on landing page "<NewUser>" and "<email>"
    And Click Add New User button
    And Assert User "<uNameAssert>"
    And Close  Browser
    
    
    
    Examples:
    |uName| pWord   | uNameAssert | NewUser  |email|
    |root | pa$$w0rd| sdet3BDD     | sdet3BDD |sdet3BDD@domain.com|
    