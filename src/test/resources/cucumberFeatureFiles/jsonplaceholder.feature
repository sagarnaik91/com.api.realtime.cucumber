Feature: Validate the fields of https://jsonplaceholder.typicode.com/posts

  @jsonplaceholder
  Scenario: Validate the count of objects in a array
    Given I send a get request
    Then validate the total number of objects available are 100

  @jsonplaceholder
  Scenario: Validate the id 89 has the userId 9
    Given I send a get request with "id" query param and value as 89
    Then Validate the value of "userId" is 9

  @jsonplaceholder1
  Scenario Outline: Execute the get method to retrieve the posts based on the id and validate status code is 200 and there is only one block for a specific id
    Given I send a get request with <id> in the path param
    Then Validate statusCode returned is <statusCode>
    And Validate only one block is returned for a id
    Examples:
      | id | statusCode |
      | 1  | 200        |
      | 2  | 200        |
      | 3  | 200        |