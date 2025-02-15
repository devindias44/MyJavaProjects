import java.util.Scanner;

public class CSC320mod1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("First Name: ");
		String firstName = scanner.nextLine();
		
		System.out.print("Last Name: ");
	    String lastName = scanner.nextLine();

	    System.out.print("Street Address: ");
	    String streetAddress = scanner.nextLine();

	    System.out.print("City: ");
	    String city = scanner.nextLine();

	    System.out.print("Zip Code: ");
	    String zipCode = scanner.nextLine();

	    System.out.println("\n---------------------");
	    System.out.println("Personal Information");
	    System.out.println("---------------------");
	    System.out.println("First Name: " + firstName);
	    System.out.println("Last Name: " + lastName);
	    System.out.println("Street Address: " + streetAddress);
	    System.out.println("City: " + city);
	    System.out.println("Zip Code: " + zipCode);

	        scanner.close();
		
	}

}
