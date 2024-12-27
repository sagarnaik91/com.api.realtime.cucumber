Feature: Validate get order feature
  I want to get paypal order using this feature

  @paypal
  Scenario Outline: Validate get order feature with valid details
    Given I want to get access token from paypal api
    When I get order from paypal api
    And I verify status code as <statusCode>
    Examples:
      | statusCode |
      | 200        |
