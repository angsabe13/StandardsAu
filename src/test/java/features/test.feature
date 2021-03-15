Feature: Customer registration form
   Verify customer registration form

  Scenario: Login as a customer 0001
    Given Customer logs in as customer "0001"
    When user navigates to Banking then Everyday accounts
    And user clicks Open now for Smart Account Access
    And user navigates upto Now tell us about yourself form
    And user fills up Now tell us about yourself fields
    Then assertion success here
    
    Scenario: Login as a customer 0002
    Given Customer logs in as customer "0002"
    When user navigates to Banking then Everyday accounts
    And user clicks Open now for Smart Account Access
    And user navigates upto Now tell us about yourself form
    And user fills up Now tell us about yourself fields
    Then assertion failure here