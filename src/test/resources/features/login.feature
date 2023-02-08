Feature: Login to Sauce home page

  @qa
  Scenario: Success Login to Sauce home page
    Given Carlos is a Sauce customer
    When He tries to login
    Then He should see to products list


  @qa
  Scenario Outline: Success Login to Sauce home page
    Given Carlos is a Sauce customer
    When He tries to login with usarname <username> and password <password>
    Then He should see to products list
    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

