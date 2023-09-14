package studio2;

import java.util.Scanner;

public class Pi {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Total Simulations? ");
		int totalSimulations = scanner.nextInt();
		int winCounter = 0;
		for (int i = 0; i < totalSimulations; i++) {
			double dartX = Math.random();
			double dartY = Math.random();
			double distance = Math.sqrt(Math.pow(dartX, 2) + Math.pow(dartY, 2));
			if (distance <= 1) {
				winCounter++;
			}
		}
		double prob = (double) winCounter / totalSimulations;
		System.out.println("Approximate Pi: " + prob * 4);
	}
}
