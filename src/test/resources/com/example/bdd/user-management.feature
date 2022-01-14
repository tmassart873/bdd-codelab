Feature: Being able to manage users

  Scenario: I can retrieve a list of users from the system
    Given a user named "Bob" "Dylan" in the system
    And a user named "Bob" "Marley" in the system
    When getting a list of users
    Then this list will contain
      | Bob | Dylan |
      | Bob | Marley |