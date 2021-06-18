package atm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ATM {
	
	static double saldo = 0.0;

	public static void main(String []args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = 0;
		System.out.print("Choose the Balance: ");
		try {
			saldo = Double.parseDouble(br.readLine());
			System.out.println("1: Log-in");
			System.out.println("2: Exit");
			System.out.print("Make Your Choice: ");
			input = Integer.parseInt(br.readLine());
			if(input > 2) {
				System.out.println("Invalid value, please retry.");
			} else {
				switch(input) {
				case 1:
					Conto.accessoConto();
				case 2:
					System.out.println("Come back soon, good bye!");
					break;
				}
			}
			
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	
	
}

