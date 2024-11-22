package edu.umn.cs.csci3081w.lab11;

public class Sandwich extends FastFoodItem {

  public Sandwich() {
    calories = 290;
  }

  @Override
  public int getCalories() {
    return calories;
  }

  @Override
  public String getDescription() {
    return "sandwich";
  }
}
