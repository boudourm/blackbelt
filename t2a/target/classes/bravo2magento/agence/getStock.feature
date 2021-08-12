Feature: test du GET des stocks

Background:
# Environment
* url bravo2magentoConfig.base_url
* configure headers = bravo2magentoConfig.header

# Variables
* def codeAgence_param = 455
* def requestProduits = {"produits":[{"codeProduit":"1098075"}]}

Scenario: GET de tous les stocks
    Given path 'v1/agence', codeAgence_param, 'stock'
	And request requestProduits
    When method POST
    Then status 200
    And match $ == '#[_>0]'
	And match each $ ==
    	"""
    	{
        	"codeProduit": #number,
        	"stockAgence": #number
    	}
    	"""    
