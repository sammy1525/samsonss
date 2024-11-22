package edu.umn.cs.csci3081w.lab11;

public class OrderBasedFastFoodItemFactory extends FastFoodItemFactory {

  public FastFoodItem makeFastFoodItem(String type, String toppings){
    FastFoodItem fastFoodItem = null;
    if(type.equals("hotdog")){
      fastFoodItem = new HotDog();
    }
    else if(type.equals("hamburger")){
      fastFoodItem = new Hamburger();
    }
    else if(type.equals("sandwich")){
      fastFoodItem = new Sandwich();
    }
    else{
      return null;
    }
    String toppingsArray[] = toppings.split(",");
    for(String topping:toppingsArray){
      if(topping.equals("grilledonions")){
        fastFoodItem = new GrilledOnionsDecorator(fastFoodItem);
      }
      else if(topping.equals("grilledmushrooms")) {
        fastFoodItem = new GrilledMushroomsDecorator(fastFoodItem);
      }
      else if(topping.equals("jalapenopeppers")) {
        fastFoodItem = new JalapenoPeppersDecorator(fastFoodItem);
      }
    }
    return fastFoodItem;
  }

}
