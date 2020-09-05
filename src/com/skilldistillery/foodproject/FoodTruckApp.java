package com.skilldistillery.foodproject;

import java.util.Scanner;

public class FoodTruckApp {

	private static int maxFoodTrucks = 5;
	private FoodTruck[] trucks = new FoodTruck[maxFoodTrucks];
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// create a new FoodTruckApp instance that we will be able to call methods from
		FoodTruckApp app = new FoodTruckApp();
		// Display the welcome message
		app.welcomeMessage();
		// User enters trucks
		app.truckEntryLoop();
		// Menu for displaying info about trucks
		app.menuLoop();
		sc.close();

	}
	
	// Welcome message displayed once at beginning
	private void welcomeMessage() {
		System.out.println("----------------------");
		System.out.println("--FOOD TRUCK PROGRAM--");
		System.out.println("----------------------");
	}
	
	// Add food trucks using createFoodTruck until the user is done or reaches the maximum number (5)
	private void truckEntryLoop() {
		for (int i = 0; i < maxFoodTrucks; i++) {
			trucks[i] = createFoodTruck();
			if (trucks[i] == null) {
				break;
			}
		}
	}
	
	// Method to prompt the user for input and create a food truck from it
	// Entering "quit" as a name will return a null truck
	private FoodTruck createFoodTruck() {
		System.out.println("Enter the food truck's name: ");
		String name = sc.nextLine();
		if (name.contentEquals("quit")) {
			System.out.println("Done entering trucks...");
			return null;
		}
		System.out.println("Enter the type of food: ");
		String foodType = sc.nextLine();
		System.out.println("Enter the rating (1 - 10): ");
		int rating = sc.nextInt();
		sc.nextLine();
		FoodTruck truck = new FoodTruck(name, foodType, rating);
		return truck;
	}

	// Loop that displays the menu, then perform the requested functions until the user decides
	// to exit
	private void menuLoop() {
		int choice = 0;
		while (choice != 4) {
			choice = displayMenu();
			switch (choice) {
			case 1:
				displayFoodTrucks();
				break;
			case 2:
				displayAverageRating();
				break;
			case 3:
				displayHighestRated();
				break;
			case 4:
				System.out.println("Exiting...");
				break;
			default:
				System.err.println("Invalid Input");
				break;
			}
		}
	}


	// Menu method displays the options and accepts/returns the choice
	private int displayMenu() {
		System.out.println("---------MENU---------");
		System.out.println("1. List food trucks");
		System.out.println("2. Display average rating");
		System.out.println("3. Show highest rated truck");
		System.out.println("4. Quit");
		int choice = sc.nextInt();
		sc.nextLine();
		return choice;
	}


	// Print the information for each truck, skipping null trucks
	private void displayFoodTrucks() {
		for (FoodTruck truck : trucks) {
			if (truck == null) {
				continue;
			} else {
				System.out.println(truck);
			}
		}
	}

	// Loop through the trucks and calculate the average rating
	// Sum the ratings and count the number of non null trucks to average by
	private void displayAverageRating() {
		double avgRating = 0;
		int numToAvg = 0;
		for (FoodTruck truck : trucks) {
			if (truck == null) {
				continue;
			}
			numToAvg++;
			avgRating += truck.getRating();
		}
		avgRating /= numToAvg;
		System.out.println("The average food truck rating is " + avgRating);
	}

	// Display the highest rated truck(s)
	private void displayHighestRated() {
		double highestRating = 0;
		double rating = 0;
		int highestRatedTruck = 0;
		boolean moreThanOneHighestRated = false;
		// Loop through trucks and get their ratings
		for (int i = 0; i < maxFoodTrucks; i++) {
			if (trucks[i] == null) {
				continue;
			}
			rating = trucks[i].getRating();
			// If the rating is higher than the current highest rating
			// then set that to be the new highest rating
			// also we know that so far there is a single highest rated truck
			// However if the rating equals the current highest rating
			// then there is now a tie for highest rating
			if (rating > highestRating) {
				highestRating = rating;
				highestRatedTruck = i;
				moreThanOneHighestRated = false;
			} else if (rating == highestRating) {
				moreThanOneHighestRated = true;
			}
		}
		// If there is a tie for highest rated truck
		// then display all the highest rated trucks
		// otherwise just display the single highest
		if (moreThanOneHighestRated) {
			System.out.println("Highest rated trucks:");
			for (FoodTruck truck : trucks) {
				if (truck == null) {
					continue;
				}
				if (truck.getRating() == highestRating) {
					System.out.println(truck);
				}
			}
		} else {
			System.out.println("Highest rated truck: ");
			System.out.println(trucks[highestRatedTruck]);
		}
	}
}
