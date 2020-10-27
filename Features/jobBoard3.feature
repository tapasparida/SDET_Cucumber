@jobBoard3
Feature: Job Board Job Search

Scenario Outline: Job Search activity
    Given Open the Browser and visit Alchemy Jobsite "<uName>" and "<pWord>"
    And Post a job and fill in details "<title>" and "<location>" and "<desc>" 
    When Submit the job post
    Then Go to jobs page and validate the post
    
    
    
    
    Examples:
    |uName| pWord   | title 			| location  |desc|
    |root | pa$$w0rd| SDET QA Engineer    | Dubai |This is SDET QA position|
    