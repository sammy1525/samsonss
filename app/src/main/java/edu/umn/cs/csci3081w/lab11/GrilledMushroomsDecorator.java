package edu.umn.cs.csci3081w.lab11;

public class GrilledMushroomsDecorator extends ToppingDecorator {

  public GrilledMushroomsDecorator(FastFoodItem fastFoodItem){
    super(fastFoodItem);
    calories = 20;
  }

  @Override
  public int getCalories(){
    return calories+ fastFoodItem.getCalories();
  }

  @Override
  public String getDescription(){
    return fastFoodItem.getDescription()+" grilled mushrooms";
  }

}
