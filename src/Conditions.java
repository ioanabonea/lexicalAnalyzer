public class Conditions {
	
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
	
	public boolean is_letter(char c) {
		return Character.isLetter(c);
	}
	
	public boolean is_digit(char c) {
		return Character.isDigit(c);
	}
	
	public boolean is_e(char c) {
		return c == 'e';
	}
	
	public boolean is_hexa(char c) {
		return is_digit(c) || ('a' <= c  && c<= 'f');
	}
	
	public boolean is_point(char c) {
		return c =='.';
	}
	
	public boolean is_negative_nr(char c) {
		return c == '-';
	}
	
	public boolean is_whatever(char c) {
		return true;
	}
	
	public boolean is_space(char c) {
		return c == ' ';
	}
	
	public boolean id_newline(char c) {
		return c == '\n';
	}
	
	public boolean id_tab(char c) {
		return c == '\t';
	}
	
	public boolean is_escape(char c) {
		return c == '\\';
	}
	
	public boolean is_simple_quote(char c) {
	    return c == '\'' || c =='"';
	}
	    
	public boolean is_double_quote(char c) {
	    return c =='"';
	}   

	public boolean is_first_char_for_id(char c) {
	    return is_letter(c) || c == '_';
	}

	public boolean is_operator(char c) {
		for( int i : operators) 
			return c == i;
		return false;
	}
	
	public boolean is_separator(char c) {
		for( int i : separators) 
			return c == i;
		return false;
	}
	
	public boolean is_keyword(String s) {
		for( String i : keywords) 
			return i.equals(s);
		return false;
	}
	
}
