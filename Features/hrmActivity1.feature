@tag

Feature: Creating a job vacancy

  

  @activity1

  Scenario: To create a job vacancy for “DevOps Engineer”

    Given Open the HRM page

    When Navigate to the recruitment page

    And Click on the “Vacancies” menu item to navigate to the vacancies page

    And Click on the “Add” button to navigate to the “Add Job Vacancy” form.

    Then Fill out the necessary details

    And Click the “Save” button to save the vacancy

    Then Verify that the vacancy was created

    And Close the browser