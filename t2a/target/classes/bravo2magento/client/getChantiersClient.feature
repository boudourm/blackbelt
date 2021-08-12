Feature: test du GET des chantiers d un client

Background:
# Environment
* url bravo2magentoConfig.base_url
* configure headers = bravo2magentoConfig.header

# Variables
* def codeClient_param = 230074
* def afficherChantiersEchus_param = true

Scenario: GET chantiers d un client
    Given path 'v1/client', codeClient_param, 'chantier'
    And param afficherChantiersEchus = afficherChantiersEchus_param
    When method GET
    Then status 200
	And match $ == '#[_>0]'
    And match each $ ==
    	"""
    	{
        	"id": #number,
        	"libelleChantier": #string,
        	"dateDebut": #string,
        	"dateFin": #string,
        	"codePostal": #string,
        	"ville": #string
    	}
    	"""  
