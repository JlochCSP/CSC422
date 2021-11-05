package pet_database;

import java.util.ArrayList;
import java.util.Scanner;

public class Pet_database_display {

	public static void main(String[] args) {
		ArrayList<Pet> petDB = new ArrayList<Pet>();
		Scanner s = new Scanner(System.in);
		boolean exit = false;
		System.out.println("Pet Database Program.");
		
		while(exit == false) {
			System.out.println();
			System.out.println("1) View all pets");
			System.out.println("2) Add more pets");
			System.out.println("3) Update an existing pet");
			System.out.println("4) Remove an existing pet");
			System.out.println("5) Search pets by name");
			System.out.println("6) Search pets by age ");
			System.out.println("7) Exit program");
			System.out.print("Your choice: ");
			int userChoice = s.nextInt();
			
			switch(userChoice) {
				case 1:
					System.out.println("+----------------------+");
					System.out.println("| ID | NAME      | AGE |");
					System.out.print("+----------------------+");
					for(int i = 0; i < petDB.size(); i++) {
						System.out.printf("\n|%3s | %-10s|%4s |",  i+1, petDB.get(i).getName(), petDB.get(i).getAge());
					}
					System.out.println("\n+----------------------+");
					System.out.println(petDB.size() + " rows in set.");
					break;
				case 2:
					boolean exitAdd = false;
					while(exitAdd == false) {
						System.out.print("add pet (name, age): ");
						String name = s.next();
						int age = s.nextInt();
						if(name.equals("done")) {
							exitAdd = true;
						} else {
							Pet tempPet = new Pet(name, age);
							petDB.add(tempPet);
						}
					}
					break;
				case 3:
					
					break;
				case 4:
					
					break;
				case 5:
					
					break;
				case 6:
					
					break;
				case 7:
					System.out.println("Goodbye!");
					exit = true;
					break;
					
			}
		}
	}
	
}
