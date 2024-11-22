package edu.umn.cs.csci3081w.lab11;

public class Hamburger extends FastFoodItem {

  public Hamburger() {
    calories = 870;
  }

  @Override
  public int getCalories() {
    return calories;
  }

  @Override
  public String getDescription() {
    return "hamburger";
  }
}
