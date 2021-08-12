package karate;

import java.util.List;

public class KarateScenario implements KarateItem{
	
	//Attributes
	private String name;
	private List<KarateVariable> valiables;
	private List<KarateStep> testSet;
	
	//Constructors
	public KarateScenario(String name, List<KarateVariable> valiables, List<KarateStep> testSet) {
		super();
		this.name = name;
		this.valiables = valiables;
		this.testSet = testSet;
	}
	
	//Getters & Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<KarateVariable> getValiables() {
		return valiables;
	}
	public void setValiables(List<KarateVariable> valiables) {
		this.valiables = valiables;
	}
	public List<KarateStep> getTestSet() {
		return testSet;
	}
	public void setTestSet(List<KarateStep> testSet) {
		this.testSet = testSet;
	}
	
	//Methods
	public void given(String firstMember, String secondMember) {
		this.testSet.add(new KarateStep(firstMember, secondMember, "Given"));
	}
	public void and(String firstMember, String secondMember) {
		this.testSet.add(new KarateStep(firstMember, secondMember, "And"));
	}
	public void then(String firstMember, String secondMember) {
		this.testSet.add(new KarateStep(firstMember, secondMember, "Then"));
	}
	public void when(String firstMember, String secondMember) {
		this.testSet.add(new KarateStep(firstMember, secondMember, "When"));
	}

	@Override
	public String toKarateCode() {
		String karateCode = "#===========================================================================================================================\n";
		karateCode = karateCode +  "Scenario: "+this.name+"\n\n";
		if(valiables!=null)
		for (KarateVariable variable : valiables) {
			karateCode = karateCode+variable.toKarateCode();
		}
		karateCode =karateCode+"\n";
		for (KarateStep testLine : testSet) {
			karateCode =karateCode+testLine.toKarateCode();
		}
		karateCode =karateCode+"\n";
		return karateCode;
	}
	
	
}
