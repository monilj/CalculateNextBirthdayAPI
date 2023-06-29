Feature: Calculate time left for next birthday based on birthdate and unit passed
  Description: The purpose of this test is to calculate time left for next birthday based on birthdate and unit passed.
  Unit could hour, days, week, month.

  Scenario Outline:
    Given API endpoints to calculate time left for next birthday
    When User Hit http get request provide query parameters "<dateofbirth>" and "<unit>"
    Then API response JSON must contains "<time>" with "<units>" left
    Examples:
      |dateofbirth  |unit| time|units|
      |1990-02-16   |week|33    |weeks|
