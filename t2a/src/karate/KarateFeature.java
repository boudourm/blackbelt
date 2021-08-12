package karate;

import java.util.List;

public class KarateFeature implements KarateItem{

	//Attributes
	private String name;
	private List<KarateScenario> scenarios;
	

	//Constructors
	public KarateFeature(String name, List<KarateScenario> scenarios) {
		super();
		this.name = name;
		this.scenarios = scenarios;
	}

	//Getters & Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<KarateScenario> getScenarios() {
		return scenarios;
	}
	public void setScenarios(List<KarateScenario> scenarios) {
		this.scenarios = scenarios;
	}
	
	//Methods
	@Override
	public String toKarateCode() {
		String karateCode = "Feature: "+this.name+"\n\n";
		
		for (KarateScenario karateScenario : scenarios) {
			 karateCode = karateCode + karateScenario.toKarateCode(); 
		}
		return karateCode;
	}	
	
}
