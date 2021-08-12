Feature: test stock du produit

Background:
# Environment
* url bravo2magentoConfig.base_url
* configure headers = bravo2magentoConfig.header

# Variables
* def codeProduit_param = 96054
* def codeAgence_param = '151'

Scenario: GET stock produit par agence
    Given path 'v1/produit', codeProduit_param, 'stock'
    And param codeAgence = codeAgence_param
    When method GET
    Then status 200
    And match $ ==
    	"""
    	{
        	"codeProduit": #number,
        	"codeAgence": #string,
        	"codeAgencePrincipaleSociete": #string,
        	"estAgencePrincipaleSociete": #boolean,
        	"stockAgence": #number,
        	"stockAgencePrincipaleSociete": #number,
        	"quantiteCommandeFournisseur": #number
    	}
    	"""
	And match $.codeProduit == codeProduit_param
	And match $.codeAgence == codeAgence_param
