@tag

Feature: Add multiple employees



  @activity3

  

  Scenario Outline: Add multiple employees using an the Examples table

    Given Open the OrangeHRM Home page 

  	When Login with credentials provided

	  Then Find the PIM option in the menu and click it

	 	Then Go to Add Employee

    And Fill the required values <firstNmae>,<lastName>

    Then Click on Create Login Details

    And fill other values <UserName> and Save  

   	Then Go to Employee List

  	And Search the employee <firstName>

  	And Verify the employee <firstName>



    Examples: 

      |firstName| lastName | UserName  |

      | Sam     |     15   | name1235  |

      | Sammy   |     35   | name2341  |

      | Nia     |   Mary   | niamary   |