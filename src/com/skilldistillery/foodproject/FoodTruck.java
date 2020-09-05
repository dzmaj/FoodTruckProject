package com.skilldistillery.foodproject;

public class FoodTruck {
	private static int numTrucksCreated = 0;
	private int truckId;
	private String name;
	private String foodType;
	private int rating;
	
	public FoodTruck(String name, String foodType, int rating) {
		this.name = name;
		this.foodType = foodType;
		this.rating = rating;
		this.truckId = 1000 + numTrucksCreated;
		numTrucksCreated++;
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
		builder.append("Truck: ")
				.append(name)
				.append("\tFood Type: ")
				.append(foodType)
				.append("\tRating: ")
				.append(rating)
				.append("\tID: ")
				.append(truckId);
		return builder.toString();
	}
	
	
	
}
