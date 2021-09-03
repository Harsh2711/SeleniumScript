Feature: Login

  @test
  Scenario: Test Function
    Given login into application
    And wait for 30 seconds
    And select "ଅନୁଗୋଳ." value from "District" dropdown
    And wait for 30 seconds
    And select "ଓଡଗାଁ" value from "Tahasil" dropdown
    And wait for 30 seconds
    And select "ଅଖାରିଆ" value from "Village" dropdown

