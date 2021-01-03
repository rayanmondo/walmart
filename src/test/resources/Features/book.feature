Feature:  books shops the collection price and title validation


@Book1
  Scenario: Find the desired book and validate the book title
    Given user on walmart homepage1
    When user click on option and mousehover to movies and book and select Textbooks
    And click on business and money
    Then user select the desired book and validate book title
  @Book2
  Scenario: find the desired ebook and validate writer name
    Given walmart homepage
    When click on option and mousehover to movies and book and select ebook
    And user click on desired ebook
    Then select the  ebook and validate writer name
  @Book3
  Scenario: find shop and collection and validate the title of desired collection
    Given user on walmart homepage
    When click on option and mousehover to movies and book and select Mandalorian
    And click on desired type of mandaloria collection
    Then validate the title
  @Book4
  Scenario: find over the moon from movies and book and validate the item title
    Given user on walmart homepage2
    When click on option and mousehover to movies and book and select over the moon
    And click on desired item
    Then validate the item title
  @Book5
  Scenario: find disney junior from movies and book and validate the item page
    Given walmart homepage for disney
    When click on option and mousehover to movies and book and select disney junior
    And click on first item
    Then validate the item page



