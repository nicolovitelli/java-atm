package atm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Conto {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static ATM saldotot = new ATM();
	
	protected static void accessoConto() {
		int pin = 0;
		System.out.print("Inserisci PIN del Conto: ");
		try {
			pin = Integer.parseInt(br.readLine());
			int numDigits = String.valueOf(pin).length();
			if (numDigits < 4) {
				System.out.println("Valore non valido.");
				accessoConto();
			} else {
				System.out.println("Accesso al Conto effettuato.");
				scelta(pin);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		
	}
	
	protected static void scelta(int pin) {
		int input = 0;
		try {
			System.out.println("1: Controlla il Saldo\n2: Deposita\n3: Preleva\n0: Esci");
			System.out.print("Effettua la scelta: ");
			input = Integer.parseInt(br.readLine());
			switch(input) {
			case 1:
				Conto.vediSaldo(saldotot.saldo, pin);
				break;
			case 2:
				depositaSaldo(saldotot.saldo, pin);
				break;
			case 3:
				prelevaSaldo(saldotot.saldo, pin);
				break;
			default:
				break;
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	protected static void vediSaldo(double saldo, int pin) {
		System.out.println(saldotot.saldo);
		scelta(pin);
	}
	
	protected static void depositaSaldo(double saldo, int pin) {
		int deposito = 0;
		System.out.print("Inserisci quanti soldi vuoi depositare: ");
		try {
			deposito = Integer.parseInt(br.readLine());
			if (deposito <= 0) {
				System.out.println("Scelta non valida.");
				depositaSaldo(saldo, pin);
			} else {
				saldotot.saldo = deposito + saldotot.saldo;
				System.out.println("Hai depositato: " + deposito + " euro.");
				System.out.println("Nuovo Saldo: " + saldotot.saldo);
				scelta(pin);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	protected static void prelevaSaldo(double saldo, int pin) {
		int preleva = 0;
		System.out.print("Inserisci la cifra da prelevare: ");
		try {
			preleva = Integer.parseInt(br.readLine());
			if (preleva > saldotot.saldo) {
				System.out.println("Cifra non valida.");
				prelevaSaldo(saldo, pin);
			} else {
				saldotot.saldo = saldotot.saldo - preleva;
				System.out.println("Hai prelevato: " + preleva + " euro.");
				System.out.println("Nuovo Saldo: " + saldotot.saldo);
				scelta(pin);
			}
			} catch (IOException e) {
				System.out.println(e);
		}
	}
}
