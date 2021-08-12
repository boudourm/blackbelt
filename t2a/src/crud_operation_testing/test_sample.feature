#===========================================================================================================================
#                            BLACK BELT GENERATED TESTS
#===========================================================================================================================

#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Sem api 

Background: 
		* def expectedSemMember1 = read('classpath:com/samse/dsup/internship/restapi/restapiapp/ui/controllers/data/sem-member-1.json')
		* def expectedSemMember2 = read('classpath:com/samse/dsup/internship/restapi/restapiapp/ui/controllers/data/sem-member-2.json')
		* def expectedSemMembers = read('classpath:com/samse/dsup/internship/restapi/restapiapp/ui/controllers/data/semteam.json')
		
#===========================================================================================================================
Scenario: get call test all team

Given url 'http://localhost:8080/t2a/semapi/team/members'
When method get
Then status 200
#===========================================================================================================================
Scenario: get call test single sem member - print response

Given url 'http://localhost:8080/t2a/semapi/team/members/7'
When method get
Then status 200
Then print response 
#===========================================================================================================================
Scenario: get call test single sem member - match response 

Given url 'http://localhost:8080/t2a/semapi/team/members/7'
When method get
Then status 200
And match response == {"id":7,"firstName":"Mehdi","lastName":"BOUDOUR","email":"mehdi-boudour@samse.fr","title":"STAGIAIRE"}
#===========================================================================================================================
Scenario: get call test all team - def and read

* def expectedTeam = read('classpath:com/samse/dsup/internship/restapi/restapiapp/ui/controllers/data/semteam.json')
# 'read' command does not work

Given url 'http://localhost:8080/t2a/semapi/team/members'
When method get
Then status 200
And match response == expectedTeam
#===========================================================================================================================
Scenario: get call test single sem member - check particular fields

* def expectedMember = read('classpath:com/samse/dsup/internship/restapi/restapiapp/ui/controllers/data/mehdi.json')

Given url 'http://localhost:8080/t2a/semapi/team/members/7'
When method get
Then status 200
And match response == expectedMember
And match response.id == 7
And match response.lastName == "BOUDOUR"
And match response.lastName == '#notnull'
And match response == '#notnull'
#===========================================================================================================================
Scenario: get call test - get member 1 
Given url 'http://localhost:8080/t2a/semapi/team/members/1'
When method get
Then status 200
And match response == expectedSemMember1
#===========================================================================================================================
Scenario: get call test - get member 2 
Given url 'http://localhost:8080/t2a/semapi/team/members/2'
When method get
Then status 200
And match response == expectedSemMember2

#===========================================================================================================================
Scenario: get call test - get member 1 with wheck from collection 

Given url 'http://localhost:8080/t2a/semapi/team/members/1'
When method get
Then status 200
And match response == expectedSemMembers[0]

#===========================================================================================================================
Scenario: get call test - get member 2 with wheck from collection 

Given url 'http://localhost:8080/t2a/semapi/team/members/2'
When method get
Then status 200
And match response == expectedSemMembers[1]

#===========================================================================================================================
Scenario: get call test - get member 7 from anotherfeature

* def feature = read('classpath:com/samse/dsup/internship/restapi/restapiapp/ui/controllers/features/get-semmember-7.feature')
* def result = call feature

Given url 'http://localhost:8080/t2a/semapi/team/members/7'
When method get
Then status 200
And match response == result.response
Then print 'result : \n',result

#===========================================================================================================================
Scenario: get call test - get member 2 with wheck from collection 

Given url 'http://localhost:8080/t2a/semapi/team/members/2'
When method get
Then status 200
And match response == expectedSemMembers[1]
		
		

