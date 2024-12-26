Feature: Validate create order feature
  I want to create a paypal order using this feature

  @paypal
  Scenario Outline: Create paypal order and validate status is created
    Given I want to get access token from paypal api
    When I set currency code as "<currency_code>" and value as "<value>"
    And I verify status as CREATED
    Examples:
      | currency_code | value |
      | USD           | 100   |
      | USD           | 200   |

  @paypal
  Scenario Outline: Create paypal order and validate the links array returned in the response
    Given I want to get access token from paypal api
    When I set currency code as "<currency_code>" and value as "<value>"
    Then validate the first rel is "<relValue>"
    Examples:
      | currency_code | value | relValue |
      | USD           | 300   | links    |