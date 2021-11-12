package pet_database;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Pet_database_display {

	public static void main(String[] args) {
		ArrayList<Pet> petDB = new ArrayList<Pet>();
		Scanner s = new Scanner(System.in);
		boolean exit = false;
		
		File petDBFile = new File("src/pet_database/petDBFile.txt");
		try {
			Scanner fileReader = new Scanner(petDBFile);
			while(fileReader.hasNextLine()) {
				String data = fileReader.nextLine();
				String[] tempData = data.split(" ");
				Pet tempFilePet = new Pet(tempData[0], Integer.parseInt(tempData[1]));
				petDB.add(tempFilePet);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Pet Database Program.");
		
		while(exit == false) {
			System.out.println();
			System.out.println("1) View all pets");
			System.out.println("2) Add more pets");
			//System.out.println("3) Update an existing pet");
			System.out.println("3) Remove an existing pet");
			//System.out.println("5) Search pets by name");
			//System.out.println("6) Search pets by age ");
			System.out.println("4) Exit program");
			System.out.print("Your choice: ");
			int userChoice = s.nextInt();
			System.out.println();
			
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
					System.out.println();
					break;
				case 2:
					boolean exitAdd = false;
					s.nextLine();
					int petCount = 0;
					while(exitAdd == false) {
						System.out.print("add pet (name, age): ");
						String newPetLine = s.nextLine();
						if(newPetLine.equalsIgnoreCase("done")) {
							System.out.println();
							break;
						}
						String[] tempNewPetData = newPetLine.split(" ");
						if(tempNewPetData.length != 2) {
							System.out.println("Error: " + newPetLine + " is not a valid input.");
						} else if(Integer.parseInt(tempNewPetData[1]) > 20 || Integer.parseInt(tempNewPetData[1]) < 1) {
							System.out.println("Error: " + Integer.parseInt(tempNewPetData[1]) + " is not a valid age.");
						} else if(petDB.size() >= 5) {
							System.out.println("Error: Database is full.");
							System.out.println();
							break;
						}  else {
							petDB.add(new Pet(tempNewPetData[0], Integer.parseInt(tempNewPetData[1])));
							petCount++;
						}
					}
					System.out.println(petCount + " pets added.");
					System.out.println();
					break;
				/*case 3:
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
					*/
				case 3:
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
					if(idRemove < petDB.size() && idRemove >= 0) {
						System.out.println(petDB.get(idRemove).getName() + " " + petDB.get(idRemove).getAge() + " is removed.");
						petDB.remove(idRemove);
					} else {
						System.out.println("Error: ID " + idRemove + " does not exist.");
					}
					System.out.println();
					break;
				/*case 5:
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
					*/
				/*case 6:
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
					*/
				case 4:
				try {
					FileWriter petFileWriter = new FileWriter(petDBFile);
					for(int i = 0; i < petDB.size(); i++) {
						petFileWriter.write(petDB.get(i).getName() + " " + petDB.get(i).getAge() + "\n");
					}
					petFileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
					System.out.println("Goodbye!");
					exit = true;
					break;
					
			}
		}
	}
	
}
