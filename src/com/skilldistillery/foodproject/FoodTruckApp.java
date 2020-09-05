package com.skilldistillery.foodproject;

import java.util.Scanner;

public class FoodTruckApp {

	private static int maxFoodTrucks = 5;
	private FoodTruck[] trucks = new FoodTruck[maxFoodTrucks];
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		FoodTruckApp app = new FoodTruckApp();
		app.welcomeMessage();
		for (int i = 0; i < maxFoodTrucks; i++) {
			app.trucks[i] = app.createFoodTruck();
			if (app.trucks[i] == null) {
				break;
			}
		}
		int choice = 0;
		while (choice != 4) {
			choice = app.displayMenu();
			switch (choice) {
			case 1:
				app.displayFoodTrucks();
				break;
			case 2:
				app.displayAverageRating();
				break;
			case 3:
				app.displayHighestRated();
				break;
			case 4:
				System.out.println("Exiting...");
				break;
			default:
				System.err.println("Invalid Input");
				break;
			}
		}
		sc.close();
		
	}
	
	private void welcomeMessage() {
		System.out.println("----------------------");
		System.out.println("--FOOD TRUCK PROGRAM--");
		System.out.println("----------------------");
	}
	
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
	
	private void displayFoodTrucks() {
		for (FoodTruck truck : trucks) {
			if (truck == null) {
				continue;
			} else {
				System.out.println(truck);
			}
		}
	}
	
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
	
	private void displayHighestRated() {
		double highestRating = 0;
		double rating = 0;
		int highestRatedTruck = 0;
		boolean moreThanOneHighestRated = false;
		for (int i = 0; i < maxFoodTrucks; i++) {
			if (trucks[i] == null) {
				continue;
			}
			rating = trucks[i].getRating();
			if (rating > highestRating) {
				highestRating = rating;
				highestRatedTruck = i;
				moreThanOneHighestRated = false;
			} else if (rating == highestRating) {
				moreThanOneHighestRated = true;
			}
		}
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
