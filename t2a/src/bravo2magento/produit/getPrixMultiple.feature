Feature: test prix du produit multiple

Background:
# Environment
* url bravo2magentoConfig.base_url
* configure headers = bravo2magentoConfig.header

# Variables
* params { codeAgence : '151', codeProduit : [96054,96055,96056,96057] }
* def codeClient_param = 263281

Scenario: GET prix produit par agence et client
    Given path 'v1/produit', 'tarif'
    And param codeClient = codeClient_param
    When method GET
    Then status 200
    And match $ == '#[_>0]'
    And match each $ ==
    	"""
    	{
        	"prix": #number,
        	"prixHorsPromo": #number,
        	"prixPublic": #number,
        	"codeProduit": #number,
        	"symboleUniteFacturation": #string,
        	"nbUFparUS": #number
    	}
    	"""
    And match each $[*].prix == '#? _ > 0'
    And match each $[*].prixHorsPromo == '#? _ > 0'
    And match each $[*].prixPublic == '#? _ > 0'

Scenario: GET prix produit par agence
    Given path 'v1/produit', 'tarif'
    When method GET
    Then status 200
    And match $ == '#[_>0]'
    And match each $ ==
    	"""
    	{
        	"prix": #number,
        	"prixHorsPromo": #number,
        	"prixPublic": #number,
        	"codeProduit": #number,
        	"symboleUniteFacturation": #string,
        	"nbUFparUS": #number
    	}
    	"""
    And match each $[*].prix == '#? _ > 0'
    And match each $[*].prixHorsPromo == '#? _ > 0'
    And match each $[*].prixPublic == '#? _ > 0'
