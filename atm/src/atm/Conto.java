package atm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Conto {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static ATM saldotot = new ATM();
	
	protected static void accessoConto() {
		int pin = 0;
		System.out.print("Please insert your PIN: ");
		try {
			pin = Integer.parseInt(br.readLine());
			int numDigits = String.valueOf(pin).length();
			if (numDigits < 4 || numDigits > 4) {
				System.out.println("The PIN must be 4 digits long.");
				accessoConto();
			} else {
				System.out.println("Logged-in successfully.");
				scelta(pin);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		
	}
	
	protected static void scelta(int pin) {
		int input = 0;
		try {
			System.out.println("1: Check your Balance");
			System.out.println("2: Pay in");
			System.out.println("3: Withdraw");
			System.out.println("4: Exit");
			System.out.print("Make Your Choice: ");
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
				System.out.println("Come back soon, good bye!");
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
		System.out.print("Please insert the amount of money you want to pay in: ");
		try {
			deposito = Integer.parseInt(br.readLine());
			if (deposito <= 0) {
				System.out.println("Invalid value, please retry.");
				depositaSaldo(saldo, pin);
			} else {
				saldotot.saldo = deposito + saldotot.saldo;
				System.out.println("You deposited: " + deposito + " dollars.");
				System.out.println("New Balance: " + saldotot.saldo);
				scelta(pin);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	protected static void prelevaSaldo(double saldo, int pin) {
		int preleva = 0;
		System.out.print("Please insert the amount of money you want to withdraw: ");
		try {
			preleva = Integer.parseInt(br.readLine());
			if (preleva > saldotot.saldo) {
				System.out.println("Invalid value, please retry.");
				prelevaSaldo(saldo, pin);
			} else {
				saldotot.saldo = saldotot.saldo - preleva;
				System.out.println("You have withdrawn: " + preleva + " dollars.");
				System.out.println("New Balance: " + saldotot.saldo);
				scelta(pin);
			}
			} catch (IOException e) {
				System.out.println(e);
		}
	}
}
