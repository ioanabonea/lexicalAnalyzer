import java.util.ArrayList;

public class Token {
	
	private static ArrayList<String> values;
	TypeToken type;
	int value;
	
	Token(TypeToken type,String value){
		this.type =  type;
		this.value = getIndex(value);
		
		if(this.type == TypeToken.IDENTIFIER) {
			for( String s : keywords ) {
				if(s.equals(value)) {
					this.type = TypeToken.KEYWORD;
					break;
				}
			}
		}
	}
	
	private static int getIndex(String value) {
		int index = -1;
		for(int i=0; i < values.size(); i++) {
			if(values.get(i).equals(values)) {
				index = i;
				break;
			}
		}
		values.add(value);
		index = values.size()-1;
		return index;
	}
	
	private static final String keywords[] = { 
    		"abstract","auto","assert",
    		"boolean", "break", "byte",
            "case", "catch", "char", "class", "continue","const", 
            "default", "do","double", 
            "else", "extends","enum","extern",
            "final", "finally", "float", "for",
            "goto",
            "if", "implements", "import", "instanceof", "int", "interface","inline",
            "long", 
            "main",
            "native", "new", 
            "package", "private", "protected","public",
            "return", "register","restrict",
            "short", "static", "super", "switch","signed","synchronized","sizeof","struct","strictfp",
            "this", "throw", "throws", "transient", "try","typedef",
            "union","unsigned",
            "void", "volatile", 
            "while",
            "_Bool","_Complex","_Imaginary"};
	@Override
	public String toString(){
		return type.toString() + " " + value;
	}
	

}
