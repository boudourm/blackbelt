Feature: test du GET des devis d un client

Background:
# Environment
* url bravo2magentoConfig.base_url
* configure headers = bravo2magentoConfig.header

# Variables
* def codeClient_param = 7305
* def montantCommandeTTC_param = 1000
* def dateDebut_param = "2008-05-01T11:58:01.000Z"
* def dateFin_param = "2020-07-31T11:58:01.000Z"

Scenario: GET de tous les devis d un client
    Given path 'v1/client', codeClient_param, 'devis'
    And param dateDebut = dateDebut_param
    And param dateFin = dateFin_param
    When method GET
    Then status 200
	And match $ == '#[_>0]'
	And match each $ ==
    	"""
    	{
        	"idBon": #number,
        	"dateCreation": #string,
        	"numeroBon": #number,
        	"extensionBon": #number,
        	"referenceBonDeCommande": ##string,
        	"agence": #string,
        	"lienEditionPdf": #string,
        	"idChantier": ##number,
        	"libelleChantier": #string,
    	}
    	"""    
