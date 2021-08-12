@ignore
Feature: test du GET de commande

Background:
# Environment
* url bravo2magentoConfig.base_url
* configure headers = bravo2magentoConfig.header

# Variables
* def numeroBon_param = 14411282
* def extensionBon_param = 1
* def idFicheSociete_param = 116210

Scenario: GET une commande
    Given path 'v1/edition', 'commande'
    And param numeroBon = numeroBon_param
    And param extensionBon = extensionBon_param
    And param idFicheSociete = idFicheSociete_param
    When method GET
    Then status 404
 #   And match header content-type contains 'application/pdf'
