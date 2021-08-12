package parse;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParser {
	
	public List<String> apiPathsFromJsonApiDocs(String file ){
		JSONParser parser = new JSONParser();
		List<String> result = new ArrayList<String>();
	    try {     
	    	//"api-docs-filtered.json"
	        Object obj = parser.parse(new FileReader(file));

	        JSONObject jsonObject =  (JSONObject) obj;
	        JSONObject paths = (JSONObject) jsonObject.get("paths");
	        
	        
	        for (int i = 0; i < paths.entrySet().toArray().length; i++) {
	        	String path = paths.entrySet().toArray()[i].toString();
	        	result.add(path.substring(0, path.indexOf("=")));
			}
	        
	        

	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	    	return result;

	}
	
	public List<ApiEndpoint> apiEndpointsFromJsonApiDocs(String file) {
		JSONParser parser = new JSONParser();
		List<ApiEndpoint> result = new ArrayList<ApiEndpoint>();
	    try {     
	    	//"api-docs-filtered.json"
	        Object obj = parser.parse(new FileReader(file));

	        JSONObject jsonObject =  (JSONObject) obj;
	        JSONObject paths = (JSONObject) jsonObject.get("paths");
	        
	        List<String> keysArray = apiPathsFromJsonApiDocs(file);
	        
	        
	      for (String pathKey : keysArray) {
	        	JSONObject path = (JSONObject) paths.get(pathKey);
	        	JSONObject get = (JSONObject) path.get("get");
	        	String getSummary = (String) get.get("summary");
	        	
	        	result.add(new ApiEndpoint(pathKey, getSummary, ApiMethod.GET) );
	        	
		}   

	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	    	return result;
	}
	
	public static void main(String[] args) {
		System.out.println(new JsonParser().apiEndpointsFromJsonApiDocs("api-docs-filtered.json"));
	}

}

