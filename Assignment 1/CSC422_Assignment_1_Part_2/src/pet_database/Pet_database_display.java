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
						System.out.printf("\n|%3s | %-10s|%4s |",  i, petDB.get(i).getName(), petDB.get(i).getAge());
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
					System.out.println("+----------------------+");
					System.out.println("| ID | NAME      | AGE |");
					System.out.print("+----------------------+");
					for(int i = 0; i < petDB.size(); i++) {
						System.out.printf("\n|%3s | %-10s|%4s |",  i, petDB.get(i).getName(), petDB.get(i).getAge());
					}
					System.out.println("\n+----------------------+");
					System.out.println(petDB.size() + " rows in set.");
					System.out.print("Enter the pet ID you want to update: ");
					int idUpdate = s.nextInt();
					System.out.print("Enter new name and new age ");
					String newName = s.next();
					int newAge = s.nextInt();
					System.out.println(petDB.get(idUpdate).getName() + " " + petDB.get(idUpdate).getAge() + " changed to " + newName + " " + newAge);
					petDB.get(idUpdate).setName(newName);
					petDB.get(idUpdate).setAge(newAge);
					break;
				case 4:
					System.out.println("+----------------------+");
					System.out.println("| ID | NAME      | AGE |");
					System.out.print("+----------------------+");
					for(int i = 0; i < petDB.size(); i++) {
						System.out.printf("\n|%3s | %-10s|%4s |",  i, petDB.get(i).getName(), petDB.get(i).getAge());
					}
					System.out.println("\n+----------------------+");
					System.out.println(petDB.size() + " rows in set.");
					System.out.print("Enter the pet ID to remove: ");
					int idRemove = s.nextInt();
					System.out.println(petDB.get(idRemove).getName() + " " + petDB.get(idRemove).getAge() + " is removed.");
					petDB.remove(idRemove);
					break;
				case 5:
					System.out.print("Enter a name to search: ");
					String name = s.next();
					int rows = 0;
					System.out.println("+----------------------+");
					System.out.println("| ID | NAME      | AGE |");
					System.out.print("+----------------------+");
					for(int i = 0; i < petDB.size(); i++) {
						if(petDB.get(i).getName().equalsIgnoreCase(name)) {
							System.out.printf("\n|%3s | %-10s|%4s |",  i, petDB.get(i).getName(), petDB.get(i).getAge());
							rows++;
						}
					}
					System.out.println("\n+----------------------+");
					System.out.println(rows + " rows in set.");
					break;
				case 6:
					System.out.print("Enter a name to search: ");
					int age = s.nextInt();
					int rows1 = 0;
					System.out.println("+----------------------+");
					System.out.println("| ID | NAME      | AGE |");
					System.out.print("+----------------------+");
					for(int i = 0; i < petDB.size(); i++) {
						if(petDB.get(i).getAge() == age) {
							System.out.printf("\n|%3s | %-10s|%4s |",  i, petDB.get(i).getName(), petDB.get(i).getAge());
							rows1++;
						}
					}
					System.out.println("\n+----------------------+");
					System.out.println(rows1 + " rows in set.");
					
					break;
				case 7:
					System.out.println("Goodbye!");
					exit = true;
					break;
					
			}
		}
	}
	
}
