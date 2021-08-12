package parse;

public class ApiEndpoint {

	//Attribute
	String path;
	String summury;
	ApiMethod 	method;

	
	//Constructors
	public ApiEndpoint(String path, String summury, ApiMethod method) {
		super();
		this.path = path;
		this.summury = summury;
		this.method = method;
	}
	
	//Getters & Setters
	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public String getSummury() {
		return summury;
	}


	public void setSummury(String summury) {
		this.summury = summury;
	}


	public ApiMethod getMethod() {
		return method;
	}


	public void setMethod(ApiMethod method) {
		this.method = method;
	}
	
	//Methods
	
}
