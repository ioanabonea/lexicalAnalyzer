import java.util.ArrayList;
import java.util.HashMap;

public class States {
	
	String name;
	boolean isFinalState = false;
	TypeToken typeToken;
	HashMap<Character,States> transitions;
	States defaultState = null;
	Character except = null; 

	public States(String name) {
		super();
		this.name = name;
		transitions = new HashMap<Character,States>();
	}
	
	public void addTransition(char transitionSymbol,States dest) {
		transitions.put(transitionSymbol, dest);
	}
	
	public void setDefaultState(States state) {
		this.defaultState = state;
	}
	
	public void setExceptChar(char c) {
		this.except = c;
	}
	
	public boolean tryTransition(char crtSymbol) {
		
		if( this.except != null && crtSymbol == this.except) {
			return false;
		}
		if(this.transitions.containsKey(crtSymbol)) {
			return true;
		}
		if( this.defaultState != null) {
			return true;
		}
		return false;
	}
	
	public States makeTransition(char crtSymbol) {

		if(tryTransition(crtSymbol) == false ) {
			return null;
		}
		if(this.transitions.containsKey(crtSymbol)) {
			return transitions.get(crtSymbol);
		}
		return this.defaultState;
	}

	public boolean isFinalState() {
		return isFinalState;
	}

	public void setFinalState(boolean isFinalState) {
		this.isFinalState = isFinalState;
	}

	public TypeToken getTypeToken() {
		return typeToken;
	}

	public void setTypeToken(TypeToken typeToken) {
		this.typeToken = typeToken;
	}
	
	
}
