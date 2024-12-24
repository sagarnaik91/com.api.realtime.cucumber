Feature: Validate stripe create customer API

  Scenario: Validate create customer API with vaild email and descriptions
    Given I set the valid auth key
    And I set "abc@test.com" as the email in the parameter
    And I set "This is the dummy description" as the description in the parameter
    When I send a Post request to "https://api.stripe.com/v1/customers"
    Then I should get 200 as the expected status code
    And I should have the "id" field in the response
    And we should get get "abc@test.com" as email in the response
    And we should get "This is the dummy description" as description the response

  @outTest
  Scenario Outline: Validate create customer API with vaild email and descriptions
    Given I set the valid auth key
    And I set "<email>" as the email in the parameter
    And I set "<description>" as the description in the parameter
    When I send a Post request to url
    Then I should get <StatusCode> as the expected status code
    And I should have the "<expectedid>" field in the response
    And we should get get "<expectedEmail>" as email in the response
    And we should get "<expectedDescription>" as description the response
    Examples:
      | email        | description          | StatusCode | expectedid | expectedEmail | expectedDescription  |
      | zxc@test.com | description 1 to 10  | 200        | id         | zxc@test.com  | description 1 to 10  |
      | abc@test.com | description 11 to 20 | 200        | id         | abc@test.com  | description 11 to 20 |
