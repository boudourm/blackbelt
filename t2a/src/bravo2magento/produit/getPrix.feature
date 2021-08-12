Feature: test prix du produit

Background:
# Environment
* url bravo2magentoConfig.base_url
* configure headers = bravo2magentoConfig.header

# Variables
* def codeProduit_param = 96054
* def codeAgence_param = '151'

Scenario: GET prix produit par agence
    Given path 'v1/produit', codeProduit_param, 'tarif'
    And param codeAgence = codeAgence_param
    When method GET
    Then status 200
    And match $ ==
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
    And match $.prix == '#? _ > 0'
    And match $.prixHorsPromo == '#? _ > 0'
    And match $.prixPublic == '#? _ > 0'
