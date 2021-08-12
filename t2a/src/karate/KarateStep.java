package karate;

public class KarateStep implements KarateItem{

	//Attribute
	private String firstMember;
	private String secondMember;
	private String keyword;

	//Constructors
	public KarateStep(String firstMember, String secondMember, String keyword) {
		super();
		this.firstMember = firstMember;
		this.secondMember = secondMember;
		this.keyword = keyword;
	}
	
	//Getters & Setters
	public String getFirstMember() {
		return firstMember;
	}
	public void setFirstMember(String firstMember) {
		this.firstMember = firstMember;
	}
	public String getSecondMember() {
		return secondMember;
	}
	public void setSecondMember(String secondMember) {
		this.secondMember = secondMember;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	//Methods
	@Override
	public String toKarateCode() {
		if(keyword == "And") {
			return this.keyword+" "+this.firstMember+" == "+this.secondMember+"\n";
		}
		
		if(keyword == "Given") {
			return this.keyword+" "+this.firstMember+" '"+this.secondMember+"'\n";
		}
		return this.keyword+" "+this.firstMember+" "+this.secondMember+"\n";
	}





}
