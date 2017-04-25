public enum TypeToken {
	
	KEYWORD (1),
	DENTIFIER (2),
	STRING_LITERAL (3),
	PUNCTUATOR (4),
	CONSTANT_INTEGRAL_DEC (5),
	CONSTANT_INTEGRAL_OCT (6),
	CONSTANT_INTEGRAL_HEX (7),
	CONSTANT_INTEGRAL (8),
	CONSTANT_FLOAT_DEC (9), 
	CONSTANT_FLOAT_OCT (10),
	CONSTANT_FLOAT_HEX (11),
	CONSTANT_FLOAT (12),
	INCLUDE_HEADER (13),
	CHAR_LITERAL (14);
	
	private final int type;
	
	TypeToken(int type){
		this.type = type;
	}
	
}