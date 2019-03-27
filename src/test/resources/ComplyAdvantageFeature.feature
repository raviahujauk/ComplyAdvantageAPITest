Feature: As an automation test
          I want to add politician data via post API method and display politician detail via get API method
          so that API end points are verified successfully

  @Test1
  Scenario Outline: Allows adding politicians data
    Given I request ComplyAdvantage
    When I post adding politicians "<name>" "<country>" "<year_of_birth>" "<position>" and "<risk>"
    Then I get an OK response

    Examples:
    | name     | country | year_of_birth | position | risk |
    | Ravi Ahu | UK      | 27/11/1981    | Senator  |  2   |

    @Test2
    Scenario: Returns the list of the latest 5 politicians, order by date of creation
      Given I request ComplyAdvantage
      When I request get method for endpoint "http://ec2-34-251-162-89.eu-west-1.compute.amazonaws.com/peps"
      Then I get response as list of the latest 5 politicians, order by date of creation