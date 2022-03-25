
Feature: Home Page Verifications

  @home_page
  Scenario: Check Blog Link displayed
  	Given User navigates to ebay HomePage
  	When search for iphone11
  	And Add to cart
  	Then iphone11 should be in cart