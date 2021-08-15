Feature: Cover Amounts Order

  Scenario: Verify that cover amounts are displayed in ascending order
    Given the user opens the Woolworths Insurance Webpage
    And then navigates to Life Insurance Quotes Page
    And confirms Age Eligibility to proceed
    And enters the following details and requests for quote
      | NAME    | DOB      | SMOKER | GENDER | ANNINCOME | COVERAMT |
      | HFSTest | 18071990 | Yes    | Male   | No        | $700,000 |
    Then the selected amount is displayed
    And the quotes are displayed in ascending order

