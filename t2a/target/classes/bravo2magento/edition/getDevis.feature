Feature: test du GET du devis

Background:
# Environment
* url bravo2magentoConfig.base_url
* configure headers = bravo2magentoConfig.header

# Variables
* def idBon_param = 10658909

Scenario: GET un devis
    Given path 'v1/edition', 'devis', idBon_param
    When method GET
    Then status 200
 	And match header Content-Type contains 'application/pdf'
 
