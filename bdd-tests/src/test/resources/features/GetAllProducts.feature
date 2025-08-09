Feature: Get all products
  Scenario: Retrieve all products
    Given the API is running
    When I send a GET request to "products"
    Then the response status code should be 200
    And the response should contain a list of products

  Scenario: Retrieve a product by ID
    Given the API is running
    When I send a GET request to "products/1"
    Then the response status code should be 200

  Scenario Outline: Retrieve a product by ID and validate the rate of the product
    Given the API is running
    When I send a GET request to "products/1"
    Then the response status code should be 200
    And the response should contain the rate as "<rate>"
    Examples:
      | rate |
      | 3.9  |

