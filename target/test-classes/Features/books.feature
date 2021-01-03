Feature:  test the price validation of books and shops collection
Background:
  Given walmart homepage

  @Book1
  Scenario: find the desired ebook and validate writer name
    When click on option and mousehover to movies and book and select ebook
    And user click on Chaos Walking Movie Tie-in Edition
    Then User select the desired book and validate writer name "Patrick Ness"

  @Book2
  Scenario: Find the desired book and validate the book title
    When user click on option and mousehover to movies and book and select Textbooks
    And User click on business and money and click on Extreme Ownership
    Then User validate the title "Extreme Ownership : How U.S. Navy Seals Lead and Win"

    @Book3
  Scenario: find the mandalorian from shops and collection and validate the title
    When user click on option and mousehover to movies and book and select Mandalorian
    And User click on Baby Yoda Twin
    Then User validate the title "Baby Yoda Twin/Full Comforter and Sham Set"

  @Book4
  Scenario: find over the moon from shops and collection and validate the item title
    When user click on option and mousehover to movies and book and select over the moon
    And User click on over the moon Bungee
    Then User validate the title "Bungee Ambient Light"

  @Book5
  Scenario: find Disney Book from shops and collection and validate the item title
    When user click on option and mousehover to movies and book and select Disney book
    And User click on World of Reading: Level 2
    Then User validate the title "World of Reading: This Is Spider-Man Level 1 Reader (Paperback)"




