 Feature: As a new user to Mercury Tours
   I need to register to the system
   So that I can obtain their services
    Background: User is on Mercury Registration Page
     Given User is on Mercury Home Page --> Register Page

      Scenario: New User Registration
        Given User enter first name as "Imperial"
        And User enter last name as "College"
        And User enter phone number as "0112887665"
        And User enter email address as "info@imperial.lk"
        And User enter user name as "admin001"
        And user enter password as "admin@123"
        And user enter confirm password as "admin@123"
        When User clicks on submit
        Then Salutation message will display as "Dear Imperial College,"