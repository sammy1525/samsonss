package edu.umn.cs.csci3081w.lab11;

public class HotDog extends FastFoodItem {

  public HotDog() {
    calories = 520;
  }

  @Override
  public int getCalories() {
    return calories;
  }

  @Override
  public String getDescription() {
    return "hotdog";
  }
}
