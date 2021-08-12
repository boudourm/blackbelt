package karate;

import java.util.ArrayList;
import java.util.Map;

import file.FileWriter;

public class BlackBeltGetGeneration implements KarateApiEndPointTest {
	//Attributes
	private String url;
	private String apiName;
	private String filePath;
	private String expectedResource;
	private String expectedResourcesFile;
	private Map<String,String> particularFields;
	private Integer idToGet;

	
	public BlackBeltGetGeneration(String url, String apiName, String filePath, String expectedResource,
			String expectedResourcesFile, Map<String, String> particularFields, Integer idToGet) {
		super();
		this.url = url;
		this.apiName = apiName;
		this.filePath = filePath;
		this.expectedResource = expectedResource;
		this.expectedResourcesFile = expectedResourcesFile;
		this.particularFields = particularFields;
		this.idToGet = idToGet;
	}
	
	
	public String getExpectedResourcesFile() {
		return expectedResourcesFile;
	}


	public void setExpectedResourcesFile(String expectedResourcesFile) {
		this.expectedResourcesFile = expectedResourcesFile;
	}


	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getApiName() {
		return apiName;
	}
	public void setApiName(String apiName) {
		this.apiName = apiName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getExpectedResource() {
		return expectedResource;
	}
	public void setExpectedResource(String expectedResource) {
		this.expectedResource = expectedResource;
	}




	public Map<String, String> getParticularFields() {
		return particularFields;
	}


	public void setParticularFields(Map<String, String> particularFields) {
		this.particularFields = particularFields;
	}


	public Integer getIdToGet() {
		return idToGet;
	}


	public void setIdToGet(Integer idToGet) {
		this.idToGet = idToGet;
	}


	//Methods
	private KarateScenario getAllSecnario() {
		KarateScenario karateScenario = new KarateScenario("get all resources", null, new ArrayList<KarateStep>());
		karateScenario.given("url", this.url);
		karateScenario.when("method", "get");
		karateScenario.then("status", "200");
		 return karateScenario;
	}
	
	private KarateScenario getSingleRessourceAndPrint() {
		KarateScenario karateScenario = new KarateScenario(" get call test single resource - print response", null, new ArrayList<KarateStep>());
		karateScenario.given("url", this.url+"/"+this.getIdToGet()); //7
		karateScenario.when("method", "get");
		karateScenario.then("status", "200");
		karateScenario.then("print", "response");	
		 return karateScenario;
	}
	
	private KarateScenario getSingleRessourceAndMatch() {
		KarateScenario karateScenario = new KarateScenario(" get call test single resource - match response ", null, new ArrayList<KarateStep>());
		karateScenario.given("url", this.url+"/"+this.getIdToGet()); //7
		karateScenario.when("method", "get");
		karateScenario.then("status", "200");
		karateScenario.then("match response ", this.expectedResource);	
		 return karateScenario;
	}
	
	private KarateScenario getAllRessourcesAndMatchWithFile() {
		KarateVariable kv = new KarateVariable("resources", "read('"+this.getExpectedResourcesFile()+"')");
		KarateScenario karateScenario = new KarateScenario(" get call test single resource - match response ", new ArrayList<KarateVariable>(), new ArrayList<KarateStep>());
		karateScenario.getValiables().add(kv);
		karateScenario.given("url", this.url); 
		karateScenario.when("method", "get");
		karateScenario.then("status", "200");
		karateScenario.then("match response ", "resources");	
		 return karateScenario;
	}
	
	private KarateScenario getSingleResourceMatchParticularFieldsScenario() {
		KarateScenario karateScenario = new KarateScenario("get call test single - check particular fields", null, new ArrayList<KarateStep>());
		karateScenario.given("url", this.url+"/"+this.idToGet);
		karateScenario.when("method", "get");
		karateScenario.then("status", "200");
		karateScenario.then("print", "response");
		for (Map.Entry<String, String> entry : particularFields.entrySet()) {
		    karateScenario.and("response."+entry.getKey(), entry.getValue()+"");
		}
		return karateScenario;
	}
	
	private KarateScenario getCallTestGetFirstRessource() {
		KarateScenario karateScenario = new KarateScenario("get call test - get member 1  ", null, new ArrayList<KarateStep>());
		karateScenario.given("url", this.url+"/1"); 
		karateScenario.when("method", "get");
		karateScenario.then("status", "200");
		 return karateScenario;
	}
	
	private KarateScenario getCallTestGetSecondRessource() {
		KarateScenario karateScenario = new KarateScenario("get call test - get member 2  ", null, new ArrayList<KarateStep>());
		karateScenario.given("url", this.url+"/2"); 
		karateScenario.when("method", "get");
		karateScenario.then("status", "200");
		 return karateScenario;
	}
	


	@Override
	public String genFeatureFile() {
		KarateFeature karateFeature = new KarateFeature(this.apiName+" get all test", new ArrayList<KarateScenario>());
		karateFeature.getScenarios().add(this.getAllSecnario());
		karateFeature.getScenarios().add(this.getAllRessourcesAndMatchWithFile());
		karateFeature.getScenarios().add(this.getCallTestGetFirstRessource());
		karateFeature.getScenarios().add(this.getSingleRessourceAndMatch());
		karateFeature.getScenarios().add(this.getSingleRessourceAndPrint());
		karateFeature.getScenarios().add(this.getSingleResourceMatchParticularFieldsScenario());
		karateFeature.getScenarios().add(this.getCallTestGetSecondRessource());
		
		
		
		String file = "blackBeltTestExample.feature";
		FileWriter.WriteTextIntoFile(karateFeature.toKarateCode(), file);
		return file;
	}		
	
}
