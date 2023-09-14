package studio2;

import java.util.Scanner;

public class Ruin {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("The amount of money that you start? ");
		int startAmount = scanner.nextInt();
		
		System.out.print("The win probability? ");
		double winChance = scanner.nextDouble();
		
		System.out.print("The amount of money you are happy with? ");
		int winLimit = scanner.nextInt();
		
		System.out.print("The number of day’s you’ll simulate? ");
		int totalSimulations = scanner.nextInt();
		
		double expectedRuin;
		if (winChance == 0.5) {
			expectedRuin = 1 - (double) startAmount / winLimit;
		} else {
			double a = (1 - winChance) / winChance;
			expectedRuin = (Math.pow(a, startAmount) - Math.pow(a, winLimit)) / (1 - Math.pow(a, winLimit));
		}
		
		int loseCounter = 0;
		
		for (int i = 0; i < totalSimulations; i++) {
			int play = 0;
			int money = startAmount;
			
			while (money < winLimit && money > 0) {
				double prob = Math.random();
				if (prob <= winChance) {
					money++;
				} else {
					money--;
				}
				play++;
				}
			if (money == winLimit) {
				System.out.println("Simulation " + (i + 1) + ": " + play + " WIN");
			} else {
				System.out.println("Simulation " + (i + 1) + ": " + play + " LOSE");
				loseCounter++;
			}
		}
		System.out.println("Losses: " + loseCounter + " Simulations: " + totalSimulations);
		System.out.println("Ruin Rate from Simulation: " + (double) loseCounter/totalSimulations + " Expected Ruin Rate: " + expectedRuin);
	}
}
