Feature: test du GET atc client

Background:
# Environment
* url bravo2magentoConfig.base_url
* configure headers = bravo2magentoConfig.header

# Variables
* def codeClient_param = 7305
* def codeAgence_param = 455

Scenario: GET encours d un client
    Given path 'v1/client', codeClient_param, 'atc'
	And param codeAgence = codeAgence_param
    When method GET
    Then status 200
	And match $ ==
    	"""
    	{
        	"matricule": #string,
        	"prenom": #string,
        	"nomFamille": #string,
        	"telephone": #string,
        	"mobile": #string,
        	"telephonePrefere": #string,
        	"email": #string
    	}
    	"""
