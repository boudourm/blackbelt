Feature: test prix du produit multiple

Background:
# Environment
* url bravo2magentoConfig.base_url
* configure headers = bravo2magentoConfig.header

# Variables
* params { codeAgence : '151', codeProduit : [96054,96055,96056,96057,96058,96059,96060,96061,96062,96063,96064,96065,96066,96067,96068,96069,96070,96071,96072,96073,96074,96075,96076,96077,96078,96079,96080,96081,96082,96083,96084,96085,96086,96087,96088,96089,96090,96091,96092,96093,96094,96095,96096,96097,96098,96099,96100,96101,96102,96103,96104,96105,96106,96107,96108,96109,96110,96111,96112,96113,96114,96115,96116,96117,96118,96119,96120,96121,96122,96123,96124,96125,96126,96127,96128,96129,96130,96131,96132,96133,96134,96135,96136,96137,96138,96139,96140,96141,96142,96143,96144,96145,96146,96147,96148,96149,96150,96151,96152,96153,96154,96155,96156,96157,96158,96159,96160,96161,96162,96163,96164,96165,96166,96167,96168,96169,96170,96171,96172,96173,96174,96175,96176,96177,96178,96179,96180,96181,96182,96183,96184,96185,96186,96187,96188,96189,96190,96191,96192,96193,96194,96195,96196,96197,96198,96199,96200,96201,96202,96203,96204,96205,96206,96207,96208,96209,96210,96211,96212,96213,96214,96215,96216,96217,96218,96219,96220,96221,96222,96223,96224,96225,96226,96227,96228,96229,96230,96231,96232,96233,96234,96235,96236,96237,96238,96239,96240,96241,96242,96243,96244,96245,96246,96247,96248,96249,96250,96251,96252,96253,96254] }
* def codeClient_param = 263281

Scenario: GET prix produit par agence et client
    Given path 'v1/produit', 'tarif'
    And param codeClient = codeClient_param
    When method GET
    Then status 200
    And match $ == '#[_>0]'
    And match each $ ==
    	"""
    	{
        	"prix": #number,
        	"prixHorsPromo": #number,
        	"prixPublic": #number,
        	"codeProduit": #number,
        	"symboleUniteFacturation": #string,
        	"nbUFparUS": #number
    	}
    	"""
    And match each $[*].prix != 0
    And match each $[*].prixHorsPromo != 0
    And match each $[*].prixPublic != 0

Scenario: GET prix produit par agence
    Given path 'v1/produit', 'tarif'
    When method GET
    Then status 200
    And match $ == '#[_>0]'
    And match each $ ==
    	"""
    	{
        	"prix": #number,
        	"prixHorsPromo": #number,
        	"prixPublic": #number,
        	"codeProduit": #number,
        	"symboleUniteFacturation": #string,
        	"nbUFparUS": #number
    	}
    	"""
    And match each $[*].prix == '#? _ > 0'
    And match each $[*].prixHorsPromo == '#? _ > 0'
    And match each $[*].prixPublic == '#? _ > 0'
