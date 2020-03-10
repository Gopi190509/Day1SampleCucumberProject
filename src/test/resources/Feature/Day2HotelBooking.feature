Feature: Verifying the Adaction Hotel Booking Details

  Scenario Outline: Verifying the hotel booking credentials
    Given User on the adaction hotel booking home page
    When User enters the "<userName>", "<password>"
    And User should click on loging button
    And User enters the "<location>", "<hotels>", "<roomType>", "<numberOfRooms>", "<checkInDate>", "<checkOutDate>", "<adultsPerRoom>", "<childrenPerRoom>"
    And User click on the search button
    And User click to select the hotel and click on continue button
    And User now enter the "<firstName>" , "<lastName>" , "<billingAddress>" , "<creditCardNo>" , "<creditCardType>", "<expiryMonth>", "<expiryYear>", "<cvvNumber>"
    And User now click on the booknow button and wait Order No.
    Then User should verify the booking details.

    Examples: 
      | userName  | password  | location | hotels         | roomType | numberOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom | firstName | lastName | billingAddress              | creditCardNo     | creditCardType | expiryMonth | expiryYear | cvvNumber |
      | samsamsam | samsamsam | Sydney   | Hotel Sunshine | Double   |             2 | 10/03/2020  | 15/03/2020   |             2 | 1 - One         | Gopinath  | Arumugam | No-123, Melbourn, Australia | 1234512345123451 | AMEX           |           3 |       2022 |      1234 |
