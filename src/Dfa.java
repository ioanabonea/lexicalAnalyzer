import java.util.ArrayList;

public class Dfa {
	
	States startState, crtState;
	
	Dfa (States state){
		this.startState = state;
		this.crtState = state;
	}
	
	public boolean tryTransition(char symbolCrt) {
		return crtState.tryTransition(symbolCrt);
	}
	
	public void makeTransition(char symbolCrt) {
		if(tryTransition(symbolCrt)) {
			crtState = crtState.makeTransition(symbolCrt);
		}
	}
	
	public boolean isInFinalState() {
		return crtState.isFinalState();
	}
	
	public void dfaReset() {
		crtState = startState;
	}
	
	public TypeToken getToken() {
		return crtState.getTypeToken();
	}
	
	public String getStateName() {
		return crtState.name;
	}
	
}
