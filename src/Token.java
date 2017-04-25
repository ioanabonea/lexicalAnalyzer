public class Token {
	
	
	
	Token(){
		
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
	
	public static final char operators[] = { '+', '-', '*', '>', '<', '&','^' }; 
    public static final char separators[] = { ',',';', '{', '}', '(', ')', '[', ']',':', '.','~','%','?','_' };

}
