@frameworktest
Business Need: required to check login functionality of mercury site
Feature: : Mercury site login functionality
Background: testuser opens browser
    Given user launch the mercury website

Scenario Outline: Validate login functionality with valid credentials
  Given user enters "<username>" & "<password>"
  And checks if mercury site home page is displayed with success message as "<success msg>"

  Examples:
  |username|password|success msg|
  |mercury |mercury |Login Successfully|