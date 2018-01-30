
/* Steven Clauw 01/29/2018
 * 
 * Task: Write a program that will recognize invalid inputs when the user requests information about students in a class
 * 
 * The application will:
 * -Provide information about students in a class
 * -Prompt the user to ask about a particular student
 * -Give proper responses according to user-submitted information
 * -Ask if user would like to learn about another student
 * 
 * BUILD SPECS
 * -Account for invalid user input with exceptions
 * -Try to incorporate IndexOutOfBoundsException and IllegalArgumentException
 * 
 * XTRA XTRA
 * -Create other exceptions and catch those too.
 */

import java.util.Scanner;

public class LabNumber7 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String cont = "y";
		boolean validString = false;
		int studentNum;
		int studentIndex;

		while (cont.equalsIgnoreCase("y")) {

			// Parallel Arrays declared and initialized
			int[] studID = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
			String[] name = { "Vincent Beekel", "Emily Blanford", "Alex Brozovich", "Andrew Calabro-Cavin",
					"Steven Clauw", "James Drain", "Ben Fogt", "Blaise Pascal Gakwaya", "Mercy Harmon",
					"Kassondra Jones", "Ronald Kim", "Brad Malarkey", "David Musko", "Cara Reaume",
					"Abduljabar Shaamala", "Nikki Shah", "Nicholas Soule", "Zachariah Zatina", "Jordan Zwart" };
			String[] hometown = { "Boston, MA", "Hartford, CT", "Kalamazoo, MI", "Oakland, CA", "Detroit, MI",
					"Albany, NY", "Columbus, IN", "Kigali, Rwanda", "Chicago, IL", "Las Vegas, NV", "Troy, MI",
					"Ann Arbor, MI", "Seattle, WA", "Atlanta, GA", "Sana'a, Yemen", "Canton, MI", "Trenton, NJ",
					"Portland, ME", "New Orleans, LA" };
			String[] food = { "Sturgeon", "Veal", "Chicken Alfredo", "Granola", "Popcorn", "Bananas", "Pizza",
					"Hamburgers", "Filet Mignon", "Swordfish", "Cara's Mom's Cooking", "Spinach Atrichoke Dip",
					"Coney Dog", "Haggis", "Mac 'N' Cheese", "Sushi", "B.L.T.", "Apple Pie", "Po' Boy" };
			String[] fear = { "Alektorophobia - the fear of chickens", "Trypanophobia - the fear of needles",
					"Aerophobia - the fear of flying", "Basiphobia - the fear of falling",
					"Autophobia - the fear of abandonment", "Enochlophobia - the fear of crowds",
					"Mysophobia - the fear of germs", "Atychiphobia - the fear of failure",
					"Atraphobia - the fear of thunder / lightning", "Cynophobia - the fear of dogs",
					"Ophidophobia - the fear of snakes", "Gamophobia - the fear of commitment",
					"Vehophobia - the fear of driving", "Ornithophobia - the fear of birds",
					"Thanatophobia - the fear of death", "Koumpounophobia - the fear of buttons",
					"Pediophobia - the fear of dolls", "Athazagoraphobia - the fear of being forgotten",
					"Somniphobia - the fear of sleep" };

			System.out.print("Welcome to our Java class!");
			System.out.print("\nWhich student would you like to learn more about? ");
			studentNum = scan.nextInt();
			studentIndex = studentNum - 1;

			// try catch ArrayIndexOutOfBounds
			try {
				studID[studentIndex] = studentIndex;
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("That student doesn't exist.  Please try again. Enter a number 1-20: ");
				studentNum = scan.nextInt();
				studentIndex = studentNum - 1;
				continue;
			}

			System.out.println("\nStudent " + studentNum + " is " + name[studentIndex]
					+ ". What would you like to know about " + name[studentIndex] + "?");
			System.out.print("Enter \"hometown\" or \"favorite food\" or \"fear\": ");

			String response = scan.nextLine();

			//try catch IllegalArgumentException
			while (!(validString)) {
				try {
					response = scan.nextLine();
					if ((response.equals("hometown")) || (response.equals("favorite food"))
							|| (response.equals("fear"))) {
						validString = true;
					} else {
						System.out.println(
								"That data doesn't exist.  Please try again. Enter \"hometown\" or \"favorite food\" or \"fear\": ");
						response = scan.nextLine();
					}

					;
				} catch (IllegalArgumentException ex) {
					System.out.println(
							"That data doesn't exist.  Please try again. Enter \"hometown\" or \"favorite food\" or \"fear\": ");
					continue;
				}
			

				if (response.equals("hometown")) {
					System.out.println("\n" + name[studentIndex] + " is from " + hometown[studentIndex] + ".");
				}

				if (response.equals("favorite food")) {
					System.out
							.println("\n" + name[studentIndex] + " often has cravings for " + food[studentIndex] + ".");
				}
				if (response.equals("fear")) {
					System.out.println("\n" + name[studentIndex] + " is afflicted by " + fear[studentIndex] + ".");
				}
			}
			System.out.print("\nWould you like to know more? (y/n) ");
			cont = scan.next();
			System.out.println("");
			if (!cont.equalsIgnoreCase("y")) {
				System.out.println("Goodbye!");
			}
		}

		scan.close();

	}
}