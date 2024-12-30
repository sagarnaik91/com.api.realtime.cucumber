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
    Then validate the array block "<arrayBlockPathInJson>" and "<field1InsideArrayBlock>" and "<field1ValueInsideArrayBlock>" and "<field2InsideArrayBlock>"
    Examples:
      | currency_code | value | arrayBlockPathInJson | field1InsideArrayBlock | field1ValueInsideArrayBlock | field2InsideArrayBlock |
      | USD           | 300   | links                | rel                    | self                        | href                   |
      | USD           | 300   | links                | rel                    | approve                     | href                   |
      | USD           | 300   | links                | rel                    | update                      | href                   |
      | USD           | 300   | links                | rel                    | capture                     | href                   |

  @paypal
  Scenario Outline: Create paypal order by reading request from file and validate the links array returned in the response
    Given I want to get access token from paypal api
    When I set currency code as "<currency_code>" and value as "<value>" and "<referenceId>"
    Then validate the array block "<arrayBlockPathInJson>" and "<field1InsideArrayBlock>" and "<field1ValueInsideArrayBlock>" and "<field2InsideArrayBlock>"
    Examples:
      | currency_code | value | arrayBlockPathInJson | field1InsideArrayBlock | field1ValueInsideArrayBlock | field2InsideArrayBlock | referenceId                          |
      | USD           | 300   | links                | rel                    | self                        | href                   | a9f80740-38f0-11e8-b467-0ed5f89f718c |
      | USD           | 300   | links                | rel                    | approve                     | href                   | b9f80740-38f0-11e8-b467-0ed5f89f718c |
      | USD           | 300   | links                | rel                    | update                      | href                   | c9f80740-38f0-11e8-b467-0ed5f89f718c |
      | USD           | 300   | links                | rel                    | capture                     | href                   | d9f80740-38f0-11e8-b467-0ed5f89f718c |

  @paypal
  Scenario Outline: Validate get order feature with valid details
    Given I want to get access token from paypal api
    When I get order from paypal api
    And I verify status code as <statusCode>
    Examples:
      | statusCode |
      | 200        |