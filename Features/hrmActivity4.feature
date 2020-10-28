@tag

Feature: Add job vacancy



  @activity4

  Scenario Outline: Create multiple job vacancy for “DevOps Engineer”

    Given Open the HRM page

    When Navigate to the recruitment page

    And Click on the “Vacancies” menu item to navigate to the vacancies page

    And Click on the “Add” button to navigate to the “Add Job Vacancy” form.

    Then Fill out the necessary details <jobVacancy>,<hiringManager>

    And Click the “Save” button to save the vacancy

    Then Verify that the vacancy was created <jobVacancy>,<hiringManager>

    And Close the browser4

 

    Examples: 

      | jobVacancy  | hiringManager  | 

      | Engineer25  |    orange hrm  |

      | Engineering |   orange hrm   |

      |Test Engineer| orange hrm     |