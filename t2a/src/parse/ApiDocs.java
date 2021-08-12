package parse;

import java.util.List;

public class ApiDocs {

	//Attributes
	private String name;
	private String host;
	private String basePath;
	private List<ApiEndpoint> paths;
	
	//Constructors
	public ApiDocs(String name, String host, String basePath, List<ApiEndpoint> paths) {
		super();
		this.name = name;
		this.host = host;
		this.basePath = basePath;
		this.paths = paths;
	}	
	
	//Getters & Setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

	public List<ApiEndpoint> getPaths() {
		return paths;
	}

	public void setPaths(List<ApiEndpoint> paths) {
		this.paths = paths;
	}
	
	//Methods
	
}
