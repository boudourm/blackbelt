Feature: test du GET de encours client verifier

Background:
# Environment
* url bravo2magentoConfig.base_url
* configure headers = bravo2magentoConfig.header

# Variables
* def codeClient_param = 7305
* def montantCommandeTTC_param = 1000

Scenario: GET encours verifier d un client
    Given path 'v1/client', codeClient_param, 'encours/verifier'
    And param montantCommandeTTC = montantCommandeTTC_param
    When method GET
    Then status 200
	And match $ ==
    	"""
    	{
        	"codeClient": #number,
        	"codeSociete": #string,
        	"commandePossible": #boolean
    	}
    	"""    
	And match $.codeClient == codeClient_param
