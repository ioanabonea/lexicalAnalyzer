public class Transition {
	
	String stare_sursa;
	String stare_destinatie;
	char caracter_de_tranzitie;
	
	Transition(String stare_sursa, char caracter_de_tranzitie ,String stare_destinatie){
		this.stare_sursa = stare_sursa;
		this.caracter_de_tranzitie = caracter_de_tranzitie;
		this.stare_destinatie = stare_destinatie;
	}
}
