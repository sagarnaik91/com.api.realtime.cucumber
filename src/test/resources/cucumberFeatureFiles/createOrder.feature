Feature: Validate create order feature
  I want to create a paypal order using this feature

  Scenario Outline: Validate paypal create order using valid details
    Given I want to get access token from paypal api
    When I set currency code as "<currency_code>" and value as "<value>"
    And I verify status as CREATED
    Examples:
      | currency_code | value |
      | USD           | 100 |
      | USD           | 200 |