Feature: Validate the fields of https://jsonplaceholder.typicode.com/posts

  @jsonplaceholder
  Scenario: Validate the count of objects in a array
    Given I send a get request
    Then validate the total number of objects available are 100

  @jsonplaceholder1
  Scenario: Validate the id 89 has the userId 9
    Given I send a get request with "id" query param and value as 89
    Then Validate the value of "userId" is 9