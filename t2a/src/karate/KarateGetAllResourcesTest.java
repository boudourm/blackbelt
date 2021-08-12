package karate;

import java.util.ArrayList;

import file.FileWriter;

public class KarateGetAllResourcesTest implements KarateApiEndPointTest{

	//Attributes
	private String url;
	private String apiName;
	private String filePath;

	//Constructors
	public KarateGetAllResourcesTest(String url, String apiName, String filePath) {
		super();
		this.url = url;
		this.apiName = apiName;
		this.filePath = filePath;
	}	
	//Getters & Setters
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
	//Methods
	
	private KarateScenario getAllSecnario() {
		KarateScenario karateScenario = new KarateScenario("get all resources", null, new ArrayList<KarateStep>());
		karateScenario.given("url", this.url);
		karateScenario.when("method", "get");
		karateScenario.then("status", "200");
		 return karateScenario;
	}

	private KarateScenario getAllAndComparedWithDataFile() {
		KarateVariable karateVariable = new KarateVariable("expectedResources", "read('classpath:"+this.filePath+"')");
		
		KarateScenario karateScenario = new KarateScenario("get call test all resources - def and read", new ArrayList<KarateVariable>(), new ArrayList<KarateStep>());
		karateScenario.getValiables().add(karateVariable);
		karateScenario.given("url", this.url);
		karateScenario.when("method", "get");
		karateScenario.then("status", "200");
		karateScenario.then("print", "response");
		karateScenario.and("match response", "expectedResources");
		
		return karateScenario;
	}

	@Override
	public String genFeatureFile() {
		KarateFeature karateFeature = new KarateFeature(this.apiName+" get all test", new ArrayList<KarateScenario>());
		karateFeature.getScenarios().add(this.getAllSecnario());
		karateFeature.getScenarios().add(this.getAllAndComparedWithDataFile());
		
		String file = "getAllResources.feature";
		FileWriter.WriteTextIntoFile(karateFeature.toKarateCode(), file);
		return file;
	}
	
}
