import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {
	
	
	static HashMap <String,States> StatesMap;
	static States startState;

	public static void main(String[] args) throws Exception {
	      
		BufferedReader reader = null;
		StatesMap = new HashMap<String,States>();
		String crtLine;
		States sursa, dest;

		try {
		    File file = new File("transitions.txt");
		    reader = new BufferedReader(new FileReader(file));
		
		    while ((crtLine = reader.readLine()) != null) {
				if(crtLine.charAt(0) == '#' )
		    		continue;
		    	
		    	String[] stringLine = crtLine.split(" ");
		    	
 		    	
		    	if(StatesMap.containsKey(stringLine[0])){
		    		sursa = StatesMap.get(stringLine[0]);
		    	}
		    	else {
		    		sursa = new States(stringLine[0]);
		    		StatesMap.put(stringLine[0], sursa);
		    	}
		    	
		        if(stringLine[1].equals("except")) {
		        	if (stringLine[2].equals("endline")) {
		        		sursa.setExceptChar('\n');
		        		continue;
		        	}
		        	else {
		        		System.out.println("Caracter except nerecunoscut " + stringLine[1]);
		        	}
		        }
		        
		        if(StatesMap.containsKey(stringLine[2])){
		    		dest = StatesMap.get(stringLine[2]);
		    	}
		    	else {
		    		dest = new States(stringLine[2]);
		    		StatesMap.put(stringLine[2], dest);
		    	}
		        if(stringLine[1].equals("default")) {
		        	sursa.setDefaultState(dest);
		        }
		        else {
		        	if(stringLine[1].equals(""))
		        		sursa.addTransition(' ', dest);
		        	else {
		        		sursa.addTransition(stringLine[1].charAt(0), dest);
		        	}
		        }
	    	}
		    
		} 
		catch (IOException e) {
		    e.printStackTrace();
		} 
		finally {
		    reader.close();
		}
		
		
		reader = new BufferedReader(new FileReader("statesType.txt"));
		while( (crtLine = reader.readLine()) != null) {
			String[] line = crtLine.split(" ");
			sursa =  StatesMap.get(line[0]);
			if(line[1].equals("start")) {
				startState = sursa;
			}
			else {
				sursa.setFinalState(true);
				sursa.setTypeToken(TypeToken.valueOf(line[2]));
			}
		}
		
		
	}
}
