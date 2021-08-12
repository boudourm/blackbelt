Feature: test du GET des factures d un client

Background:
# Environment
* url bravo2magentoConfig.base_url
* configure headers = bravo2magentoConfig.header

# Variables
* def codeClient_param = 7305
* def dateDebut_param = "2016-05-01T11:58:01.000Z"
* def dateFin_param = "2020-07-31T11:58:01.000Z"

Scenario: GET de toutes les factures d un client
    Given path 'v1/client', codeClient_param, 'facture'
    And param dateDebut = dateDebut_param
    And param dateFin = dateFin_param
    When method GET
    Then status 200
	And match $ == '#[_>0]'
	And match each $ ==
    	"""
    	{
        	"numeroFacture": #string,
        	"dateCreation": #string,
        	"agence": #string,
        	"modeReglement": ##string,
        	"montantTotalHT": #number,
        	"montantTotalTTC": #number,
        	"lienEditionPdf": #string,
        	"idChantier": ##number,
        	"libelleChantier": ##string,
        	"referenceBonDeCommande": #string
    	}
    	"""    
	 And match $[0] ==
    	"""
    	{
        	"numeroFacture": #string,
        	"dateCreation": #string,
        	"agence": #string,
        	"modeReglement": #string,
        	"montantTotalHT": #number,
        	"montantTotalTTC": #number,
        	"lienEditionPdf": #string,
        	"idChantier": ##number,
        	"libelleChantier": #string,
        	"referenceBonDeCommande": #string
    	}
    	"""    
