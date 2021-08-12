@ignore
Feature: test du POST d import d un client

Background:
# Environment
* url bravo2magentoConfig.base_url
* configure headers = bravo2magentoConfig.header

# Variables
* def codeClient_param = '7305'
* def codeAgence_param = '455'

Scenario: POST d import d un client
    Given path 'v1/client', codeClient_param, 'litige'
	And param codeAgence = codeAgence_param
    When method GET
    Then status 200
	And match $ ==
	"""
	{
		"codeClient": #string,
		"codeAgence": #string,
		"codeSociete": #string,
		"litige": #boolean
	}
	"""
	And match $.codeClient == codeClient_param
	And match $.codeAgence == codeAgence_param
