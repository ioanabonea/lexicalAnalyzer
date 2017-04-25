import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
	
	
	static HashMap <String,States> StatesMap;
	States state;

	@SuppressWarnings("null")
	public static void main(String[] args) throws Exception {
	      
		BufferedReader reader = null;
		ArrayList<Transition> transitions = null;
		StatesMap = new HashMap<String,States>();
		String crtLine;

		try {
		    File file = new File("transitions.txt");
		    reader = new BufferedReader(new FileReader(file));
		
		    while ((crtLine = reader.readLine()) != null) {
				if(crtLine.charAt(0) == '#' )
		    		continue;
		    	
		    	String[] stringLine = crtLine.split(" ");
		    	States sursa, dest;
		    	String transitionChar;
 		    	
		    	if(StatesMap.containsKey(stringLine[0])){
		    		sursa = StatesMap.get(stringLine[0]);
		    	}
		    	else {
		    		sursa = new States(stringLine[0]);
		    		StatesMap.put(stringLine[0], sursa);
		    	}
		        if(stringLine[1].equals("except")) {
		        	
		        }
	    	}
		    
		
		} 
		catch (IOException e) {
		    e.printStackTrace();
		} 
		finally {
		    reader.close();
		}
		
		
	}
}
