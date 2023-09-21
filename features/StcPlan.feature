Feature: VALIDATE ALL COUNTRY STC PLAN

 Scenario: Open Browser
  	Given I launch chrome browser
    
  Scenario Outline: Verifying All Country Stc Tv Plan
  	When I open stc tv plan page
    Then I clicked on the translate button of type English
  	Then Based on country '<countryName>' and the plan '<planName>'

Examples:
            | countryName | planName |
            | Bahrain    | Lite  		|
            | Bahrain    | Classic  |
            | Bahrain    | Premium  |
            | KSA    | Lite  		|
            | KSA    | Classic  |
            | KSA    | Premium  |
            | Kuwait    | Lite  	 |
            | Kuwait    | Classic  |
            
    
            | Kuwait    | Premium  |
            
	Scenario: Close Browser
  	Given I close the browser