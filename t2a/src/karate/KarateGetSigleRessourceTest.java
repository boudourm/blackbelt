package karate;

import java.util.ArrayList;
import java.util.Map;

import file.FileWriter;

public class KarateGetSigleRessourceTest implements KarateApiEndPointTest{
	//Attributes
	private String url;
	private String apiName;
	private String expectedResource;
	private Map<String,String> particularFields;

	//Constructors
	public KarateGetSigleRessourceTest(String url, String apiName, String expectedResource,
			Map<String, String> particularFields) {
		super();
		this.url = url;
		this.apiName = apiName;
		this.expectedResource = expectedResource;
		this.particularFields = particularFields;
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
	
	//Methods
	
	private KarateScenario getSingleResourceAndPrintScenario() {
		KarateScenario karateScenario = new KarateScenario("get call test single resource - print response", null, new ArrayList<KarateStep>());
		karateScenario.given("url", this.url);
		karateScenario.when("method", "get");
		karateScenario.then("status", "200");
		karateScenario.then("print", "response");
		karateScenario.and("match response", expectedResource);
		
		return karateScenario;
	}
	


	private KarateScenario getSingleResourceMatchParticularFieldsScenario() {
		KarateScenario karateScenario = new KarateScenario("get call test single - check particular fields", null, new ArrayList<KarateStep>());
		karateScenario.given("url", this.url);
		karateScenario.when("method", "get");
		karateScenario.then("status", "200");
		karateScenario.then("print", "response");
		for (Map.Entry<String, String> entry : particularFields.entrySet()) {
		    karateScenario.and("response."+entry.getKey(), entry.getValue()+"");
		}
		return karateScenario;
	}


	@Override
	public String genFeatureFile() {
		KarateFeature karateFeature = new KarateFeature(this.apiName+" get all test", new ArrayList<KarateScenario>());
		karateFeature.getScenarios().add(this.getSingleResourceAndPrintScenario());
		karateFeature.getScenarios().add(this.getSingleResourceMatchParticularFieldsScenario());
		String file = "getSingleRessource.feature";
		FileWriter.WriteTextIntoFile(karateFeature.toKarateCode(), file);
		return file;
	}
}
