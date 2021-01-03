Feature: movies and music title validation
@Movie1
  Scenario: Find the desired movie and validate the title
    Given walmart homepage movie1
    When user click on option and mousehover to movies and book and select new release movie
    And  click frozen 2
    Then validate the movie title
  @Movie2
  Scenario: Find the desired show and validate the title
    Given walmart homepage movie2
    When user click on option and mousehover to movies and book and select tv show
    And  click The Big Bang Theory
    Then validate the show title

  @Movie3
  Scenario: Find the desired series and validate the title
    Given walmart homepage movie3
    When user click on option and mousehover to movies and book and select complete series
    And  click on Harry potter
    Then validate the complete series title



