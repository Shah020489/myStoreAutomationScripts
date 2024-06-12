Feature: Vendor


  Scenario: Successful Login with Valid Credentials
    Given User Launch Chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on customers Menu
    And User click on Vendors
    Then User validate Add a new vendor
    When User clicks on Add New record
    Then User receive error message