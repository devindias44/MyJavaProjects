import java.util.Scanner;
public class CSC320Mod4 {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
	        float total = 0;
	        float max = Float.MIN_VALUE;
	        float min = Float.MAX_VALUE;
	        int count = 0;

	        System.out.println("Enter five floating-point values:");

	        while (count < 5) {
	            System.out.print("Enter value " + (count + 1) + ": ");
	            if (scanner.hasNextFloat()) {
	                float value = scanner.nextFloat();
	                total += value;
	                if (value > max) {
	                    max = value;
	                }
	                if (value < min) {
	                    min = value;
	                }
	                count++;
	            } else {
	                System.out.println("Invalid input. Please enter a floating-point number.");
	                scanner.next(); 
	            }
	        }

	        float average = total / 5;
	        float interest = total * 0.20f;

	        System.out.println("\nResults:");
	        System.out.println("Total: " + total);
	        System.out.println("Average: " + average);
	        System.out.println("Maximum: " + max);
	        System.out.println("Minimum: " + min);
	        System.out.println("Interest on total at 20%: " + interest);

	        scanner.close();

	}

}
