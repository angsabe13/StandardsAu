Feature: Login Feature
   Verify if user is able to Login in to the site

  Scenario: Login as a authenticated user
    Given user is on homepage
    When user navigates to Banking then Everyday accounts
    And user clicks Open now for Smart Account Access
    And user navigates upto Now tell us about yourself form
    And user fills up Now tell us about yourself fields
    Then assertion here

