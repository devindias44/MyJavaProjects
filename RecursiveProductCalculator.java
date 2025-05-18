import java.util.Scanner;

public class RecursiveProductCalculator {

    //Recursively calculates the product of numbers in an array
    public static double recursiveProduct(double[] numbers, int index) {
        // Base case: if we've reached the end of the array, return 1 (multiplicative identity)
        if (index == numbers.length) {
            return 1;
        }
        // Recursive case: multiply current number by product of remaining numbers
        return numbers[index] * recursiveProduct(numbers, index + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numbers = new double[5];
        
        System.out.println("Recursive Product Calculator");
        System.out.println("Enter five numbers to calculate their product.");

        for (int i = 0; i < 5; i++) {
            while (true) {
                try {
                    System.out.print("Enter number " + (i + 1) + ": ");
                    numbers[i] = Double.parseDouble(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                }
            }
        }

        double product = recursiveProduct(numbers, 0);
        System.out.print("\nThe product of [");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            if (i < numbers.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("] is: " + product);
    }
}