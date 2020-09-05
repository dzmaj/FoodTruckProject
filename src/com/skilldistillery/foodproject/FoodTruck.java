package com.skilldistillery.foodproject;

public class FoodTruck {

	private static int numTrucksCreated = 0;
	// Used for aligning output when displaying trucks
	private static int longestNameStrLen;
	private static int longestFoodTypeStrLen;

	private int truckId;
	private String name;
	private String foodType;
	private int rating;

	public FoodTruck(String name, String foodType, int rating) {
		this.name = name;
		this.foodType = foodType;
		this.rating = rating;
		// Start IDs off at 1000, and increment every time a truck is created
		this.truckId = 1000 + numTrucksCreated;
		numTrucksCreated++;
		// Every time a truck is created, set how many characters the longest
		// name/foodType is. Used for aligning toStrings
		if (name.length() > longestNameStrLen) {
			longestNameStrLen = name.length();
		}
		if (foodType.length() > longestFoodTypeStrLen) {
			longestFoodTypeStrLen = foodType.length();
		}
	}

	public int getTruckId() {
		return truckId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Truck: ").append(name);
		// Add spaces depending on how long the longest name is
		for (int i = 0; i < longestNameStrLen - name.length(); i++) {
			builder.append(" ");
		}
		builder.append(" | Food Type: ").append(foodType);
		// Add spaces depending on how long the longest foodType is
		for (int i = 0; i < longestFoodTypeStrLen - foodType.length(); i++) {
			builder.append(" ");
		}
		builder.append(" | Rating: ").append(rating).append("/10");
		builder.append(" | ID: ").append(truckId);
		return builder.toString();
	}

}
