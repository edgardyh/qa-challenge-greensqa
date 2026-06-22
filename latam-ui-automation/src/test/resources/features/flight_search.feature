Feature: Flight Search LATAM

  @positive
  Scenario: Search flight successfully

    Given the user opens LATAM website
    When the user searches a flight using generated data
    Then available flights should be displayed

  @invalidOriginDestination
  Scenario Outline: Search Flight Invalid Destination

      Given the user opens LATAM website
      When the user searches a flight from "<origin>" to "<destination>"
      Then destination should not have available options

      Examples:
        | origin | destination |
        | Bogotá | Bogotá      |

  @withoutDestination
  Scenario Outline: Search Flight Without Destination

    Given the user opens LATAM website
    When the user searches a flight from "<origin>" to "<destination>"
    Then destination validation should be displayed

    Examples:
      | origin | destination |
      | Bogotá |             |