package csc320Module3;

import java.util.Scanner;

public class CSC320Module3 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		 System.out.print("Enter the weekly income: ");
	        double weeklyIncome = scanner.nextDouble();
	        
	        double taxRate;
	        if (weeklyIncome < 500) {
	            taxRate = 0.10; 
	        } else if (weeklyIncome >= 500 && weeklyIncome < 1500) {
	            taxRate = 0.15; 
	        } else if (weeklyIncome >= 1500 && weeklyIncome < 2500) {
	            taxRate = 0.20; 
	        } else {
	            taxRate = 0.30;
	        }
	        
	        double taxWithholding = weeklyIncome * taxRate;
	        
	        System.out.printf("The weekly tax withholding is: $%.2f%n", taxWithholding);

	        scanner.close();
		
	}

}
