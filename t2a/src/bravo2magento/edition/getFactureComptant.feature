Feature: test du GET de la facture comptant

Background:
# Environment
* url bravo2magentoConfig.base_url
* configure headers = bravo2magentoConfig.header

# Variables
* def idFactureComptant_param = 1

Scenario: GET une facture comptant
    Given path 'v1/edition', 'facture-au-comptant', idFactureComptant_param
    When method GET
    Then status 200
	And match header Content-Type contains 'application/pdf'
