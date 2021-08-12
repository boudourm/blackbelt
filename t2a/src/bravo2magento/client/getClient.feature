Feature: test du GET des infos d un client

  Background:
# Environment
    * url bravo2magentoConfig.base_url
    * configure headers = bravo2magentoConfig.header

# Variables
    * def utils = call read('classpath:utils/common.feature')
    * def codeClient_param = 358452
    * def codeSociete_param = '01'

  Scenario: GET infos d un client
    Given path 'v1/client', codeClient_param
    And param codeSociete = codeSociete_param
    When method GET
    Then status 200
    And match $ ==
    """
    {
        "idCivilite": #? utils.isPresentAndNotNullNumber(_),
        "nom": #? utils.isPresentAndString(_),
        "prenom": #? utils.isPresentAndString(_),
        "telephonePortable": #? utils.isPresentAndString(_),
        "email": #? utils.isPresentAndNotNullString(_),
        "typeClient": #? utils.isPresentAndNotNullNumber(_),
        "numeroSiren": #? utils.isPresentAndString(_),
        "raisonSociale": #? utils.isPresentAndNotNullString(_),
        "nomResponsable": #? utils.isPresentAndString(_),
        "prenomResponsable": #? utils.isPresentAndString(_),
        "emailSociete": #? utils.isPresentAndString(_),
        "idTypeVoie": #? utils.isPresentAndNotNullNumber(_),
        "numeroVoie": #? utils.isPresentAndNotNullString(_),
        "nomVoie": #? utils.isPresentAndNotNullString(_),
        "codePostal": #? utils.isPresentAndNotNullString(_),
        "ville": #? utils.isPresentAndNotNullString(_),
        "idPays": #? utils.isPresentAndNotNullNumber(_),
        "telephoneFixe": #? utils.isPresentAndNotNullString(_),
        "consentementPromoSMS": #? utils.isPresentAndNotNullBoolean(_),
        "consentementPromoEmail": #? utils.isPresentAndNotNullBoolean(_),
        "consentementRGPD": #? utils.isPresentAndNotNullBoolean(_),
        "referenceBonCmdObligatoire": #? utils.isPresentAndNotNullBoolean(_),
        "chantierObligatoire": #? utils.isPresentAndNotNullBoolean(_),
        "idTypeClient": #? utils.isPresentAndNotNullNumber(_),
        "codeClient": #? utils.isPresentAndNotNullNumber(_),
        "codeAgencePilote": #? utils.isPresentAndNotNullNumber(_),
    }
    """
