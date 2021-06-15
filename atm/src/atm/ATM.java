package atm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ATM {
	
	public static void main(String []args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = 0;
		System.out.println("1: Accedi\n2: Esci");
		System.out.print("Inserisci scelta: ");
		try {
			input = Integer.parseInt(br.readLine());
			if(input > 2) {
				System.out.println("Valore non valido.");
			} else {
				switch(input) {
				case 1:
					Conto.accessoConto();
				}
			}
			
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	
	
}

