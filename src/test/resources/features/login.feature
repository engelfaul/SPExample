Feature: Login to Sauce home page

  @progress
  Scenario: Success Login to Sauce home page
    Given Carlos is a Sauce customer
    When He tries to login
    Then He should see to products list

