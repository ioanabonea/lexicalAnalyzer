import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Scanner {
	
	String fisInput;
	Dfa dfa;
	int crtIndex;
	final static String skipCh = " \n\t\r";
	
	
	Scanner(String filepath,Dfa dfa) throws IOException{
		
		File file = new File(filepath);
		FileInputStream fis = new FileInputStream(file);
		byte[] data = new byte[(int) file.length()];
		fis.read(data);
		fis.close();

		fisInput = new String(data, "UTF-8");
		this.dfa = dfa;
		crtIndex = 0;
		
	}
	
	public Token getNextToken() {
		
		
		dfa.dfaReset();
		
		//skip characters 
		while(crtIndex < fisInput.length() && (skipCharacters() || skipComments()));
		
		StringBuilder tokenValue = new StringBuilder();
		while( crtIndex < fisInput.length() && dfa.tryTransition(fisInput.charAt(crtIndex))) {
			dfa.makeTransition(fisInput.charAt(crtIndex));
			tokenValue.append(fisInput.charAt(crtIndex));
			crtIndex++;
		}
		if(dfa.isInFinalState()) {
			return new Token(dfa.getToken(),tokenValue.toString());
		}
		String mess = "Automatul s-a blocat in starea "+ dfa.getStateName()+" incercand sa proceseze caracterul "
						+fisInput.charAt(crtIndex)+" de pe pozitia "+crtIndex;
		return new Token(TypeToken.ERROR,mess);
		
	}
	
	public boolean skipCharacters() {
		int auxIndex = crtIndex;
		while( crtIndex < fisInput.length() && skipCh.indexOf(fisInput.charAt(crtIndex)) != -1 ){
			crtIndex++;
		}
		return crtIndex != auxIndex;
	}
	
	public boolean skipComments() {
		int auxIndex = crtIndex;
		if(crtIndex < fisInput.length()-1 && fisInput.charAt(crtIndex) == '/' && fisInput.charAt(crtIndex+1) == '*' ) {
			crtIndex += 2;
			while( crtIndex < fisInput.length()  && fisInput.charAt(crtIndex-1) == '*' && fisInput.charAt(crtIndex) == '/') {
				crtIndex++;
			}
		}
		if(crtIndex < fisInput.length()-1 && fisInput.charAt(crtIndex) == '/' && fisInput.charAt(crtIndex+1) == '/') {
			crtIndex += 2;
			while( crtIndex < fisInput.length() && fisInput.charAt(crtIndex) != '\n') {
				crtIndex++;
			}
		}
		return crtIndex != auxIndex;
	}
	

}
