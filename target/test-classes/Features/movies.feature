Feature: Test movies and musics title Validation
Background:
  Given User on walmart Homepage

  @Movie1
  Scenario: Find Frozen 2 from Movies and validate the item title
    When User click on option and mousehover to movies and book and select new release movie
    And  User click on frozen 2
    Then User should be able to see the title "Frozen II (DVD)"

  @Movie2
  Scenario: Find The Big Bang Theory from Movies and validate the item title
    When User click on option and mousehover to movies and book and select Tv Show
    And  User click on The Big Bang Theory
    Then User should be able to see the title "The Big Bang Theory: The Complete Series (DVD)"

  @Movie3
  Scenario: Find Harry Potter from Movies Complete series  and validate the item title
    When User click on option and mousehover to movies and book and select Complete Series
    And User click on Harry Potter
    Then User should be able to see the title "Harry Potter: The Complete 8-Film Collection (DVD)"

  @Movie4
  Scenario: Find Aladin from Shop Movies by Studio  and validate the item title
    When User click on option and mousehover to movies and book and select Shop Movies by Studio
    And User click on Aladin
    Then User should be able to see the title "Aladdin (DVD)"
#  @Movie1
#  Scenario: Find the desired movie and validate the title
#    When User click on option and mousehover to movies and book and select Tv Show
#    And  User click on The Big Bang Theory
#    Then User should be able to see the title "The Big Bang Theory: The Complete Series (DVD)"





