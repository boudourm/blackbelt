Feature: test du GET du bon de livraison

Background:
# Environment
* url bravo2magentoConfig.base_url
* configure headers = bravo2magentoConfig.header

# Variables
* def idBon_param = 18623276

Scenario: GET un bon de livraison
    Given path 'v1/edition', 'bon-de-livraison', idBon_param
    When method GET
    Then status 200
	And match header Content-Type contains 'application/pdf'
