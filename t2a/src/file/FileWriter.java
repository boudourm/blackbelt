package file;

import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class FileWriter 
{
	
	public static void WriteTextIntoFile(String text, String file) {
		try (PrintWriter out = new PrintWriter(file, StandardCharsets.UTF_8)) {
		    out.println(text);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	


}
