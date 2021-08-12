package karate;

public class KarateVariable implements KarateItem {

	//Attributes
	private String name;
	private String value;
	
	//Constructors
	public KarateVariable(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}
	
	//Getters & Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toKarateCode() {
		return "* def "+this.name+" = "+this.getValue()+"\n";
	}
}
