Feature: test du GET de encours client

Background:
# Environment
* url bravo2magentoConfig.base_url
* configure headers = bravo2magentoConfig.header

# Variables
* def codeClient_param = 7305

Scenario: GET encours d un client
    Given path 'v1/client', codeClient_param, 'encours'
    When method GET
    Then status 200
	And match $ ==
    	"""
    	{
        	"codeClient": #number,
        	"codeSociete": #string,
        	"encoursActuelSociete": #number,
        	"encoursActuelSocieteFacture": #number,
        	"encoursActuelSocieteNonFacture": #number
    	}
    	"""
	And match $.codeClient == codeClient_param
