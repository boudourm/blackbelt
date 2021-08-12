Feature: test du GET de la facture terme

Background:
# Environment
* url bravo2magentoConfig.base_url
* configure headers = bravo2magentoConfig.header

# Variables
* def idFactureTerme_param = 1

Scenario: GET une facture terme
    Given path 'v1/edition', 'facture-terme', idFactureTerme_param
    When method GET
    Then status 200
	And match header Content-Type contains 'application/pdf'
