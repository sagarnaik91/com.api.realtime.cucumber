Feature: Validate stripe create customer API

  @stripe
  Scenario Outline: Create a stripe customer and validate the statusCode and fields like id, email and description
    Given I set the valid auth key
    And I set "<email>" as the email in the parameter
    And I set "<description>" as the description in the parameter
    When I send a Post request to url
    Then I should get <StatusCode> as the expected status code
    And I should have the "<expectedid>" field in the response
    And we should get get "<expectedEmail>" as email in the response
    And we should get "<expectedDescription>" as description the response
    And validate the schema passed in "<path>"
    Examples:
      | email        | description          | StatusCode | expectedid | expectedEmail | expectedDescription  | path                                                       |
      | zxc@test.com | description 1 to 10  | 200        | id         | zxc@test.com  | description 1 to 10  | src/test/resources/responseSchema/stripeResponseWithFields |
      | abc@test.com | description 11 to 20 | 200        | id         | abc@test.com  | description 11 to 20 | src/test/resources/responseSchema/stripeResponseWithFields |

  @stripe
  Scenario Outline: Create a strip customer using the request from file and validating the statusCode
    Given I set the valid auth key
    And I setup "<email>" in the field email
    And I set "<description>" in the description
    When I send a request to url
    Then I should get <StatusCode> as the expected status code
    And validate the schema passed in "<path>"
    Examples:
      | email        | description          | StatusCode | path                                                  |
      | 123@test.com | description 21 to 30 | 200        | src/test/resources/responseSchema/stripeResponse.json |
      | 456@test.com | description 31 to 40 | 200        | src/test/resources/responseSchema/stripeResponse.json |
      | 789@test.com | description 41 to 50 | 200        | src/test/resources/responseSchema/stripeResponse.json |
      | abc@test.com | description 51 to 60 | 200        | src/test/resources/responseSchema/stripeResponse.json |

  @stripe
  Scenario Outline: Create a strip customer using the request from file and validating the invoice_settings json object
    Given I set the valid auth key
    And I setup "<email>" in the field email
    And I set "<description>" in the description
    When I send a request to url
    Then I should get "<mapLocatorInJsonResponse>" and "<fieldToBeValidated>" as the expected status code
    Examples:
      | email        | description          | mapLocatorInJsonResponse    | fieldToBeValidated     |
      | efg@test.com | description 41 to 50 | invoice_settings | default_payment_method |
      | hij@test.com | description 51 to 60 | invoice_settings | default_payment_method |

