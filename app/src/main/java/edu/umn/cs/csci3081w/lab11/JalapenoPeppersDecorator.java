package edu.umn.cs.csci3081w.lab11;

public class JalapenoPeppersDecorator extends ToppingDecorator {

  public JalapenoPeppersDecorator(FastFoodItem fastFoodItem){
    super(fastFoodItem);
    calories = 5;
  }

  @Override
  public int getCalories(){
    return calories+ fastFoodItem.getCalories();
  }

  @Override
  public String getDescription(){
    return fastFoodItem.getDescription()+" jalapeno peppers";
  }

}
