package karate;

import java.util.HashMap;
import java.util.Map;

import parse.ApiEndpoint;
import parse.JsonParser;

public class Main {

	public static void main(String[] args) {
		Map<String,String> particularFields = new HashMap<String,String>();
		particularFields.put("id", "7");
		particularFields.put("lastName", "'BOUDOUR'");
		particularFields.put("firstName", "'Mehdi'");
		
		JsonParser jp = new JsonParser();
		
		ApiEndpoint path =  jp.apiEndpointsFromJsonApiDocs("api-docs-filtered.json").get(0);
		//KarateGetAllResourcesTest ka = new KarateGetAllResourcesTest(path.getPath(), path.getSummury(),"com/thomas/mehdi/resourcesFile.json");
		
		/*KarateGetSigleRessourceTest ks = new KarateGetSigleRessourceTest("http://localhost:8080/semapi/team/members/7", "Sem Api", 
				"{\"id\":7,\"firstName\":\"Mehdi\",\"lastName\":\"BOUDOUR\",\"email\":\"mehdi-boudour@samse.fr\",\"title\":\"STAGIAIRE\"}", 
				 particularFields);
		*/
		
		BlackBeltGetGeneration bbgg = new BlackBeltGetGeneration(path.getPath(), path.getSummury(),null,"{\"id\":7,\"firstName\":\"Mehdi\",\"lastName\":\"BOUDOUR\",\"email\":\"mehdi-boudour@samse.fr\",\"title\":\"STAGIAIRE\"}",
							"classpath:com/samse/dsup/internship/restapi/restapiapp/ui/controllers/data/semteam.json",
							particularFields, 7);
		
		bbgg.genFeatureFile();
		
		//ka.genFeatureFile();
		//ks.genFeatureFile();
	}
}
