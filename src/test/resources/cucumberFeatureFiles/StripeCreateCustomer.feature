Feature: Validate stripe create customer API

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

  @test11
  Scenario Outline: Create a order using stripe API
    Given I set the valid auth key
    And I setup "<email>" in the field email
    And I set "<description>" in the description
    When I send a request to url
    Then I should get <StatusCode> as the expected status code
    Examples:
      | email        | description          | StatusCode |
      | 123@test.com | description 21 to 30 | 200        |
      | 456@test.com | description 31 to 40 | 200        |
      | 789@test.com | description 41 to 50 | 200        |
      | abc@test.com | description 51 to 60 | 200        |
