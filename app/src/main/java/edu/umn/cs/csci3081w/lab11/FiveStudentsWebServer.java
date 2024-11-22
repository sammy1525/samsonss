package edu.umn.cs.csci3081w.lab11;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint(
    value = "/lab11",
    subprotocols = {"web_server"}
)
public class FiveStudentsWebServer {

  private Session session;

  @OnOpen
  public void onOpen(Session session) {
    this.session = session;
  }

  @OnMessage
  public void onMessage(String message) {
    JsonObject orderJson = JsonParser.parseString(message).getAsJsonObject();
    String order = orderJson.get("text").getAsString();
    String[] orderArray = order.split(" ");
    String type = "";
    String toppings = "";
    if(orderArray.length==1){
      type = orderArray[0];
    }
    else if(orderArray.length==2){
      type = orderArray[0];
      toppings = orderArray[1];
    }
    else{
      JsonObject confirmation = new JsonObject();
      confirmation.addProperty("text", "the fast food item order is not right");
      sendJson(confirmation);
      return;
    }
    FastFoodItemFactory fastFoodItemFactory = new OrderBasedFastFoodItemFactory();
    FastFoodItem fastFoodItem = fastFoodItemFactory.makeFastFoodItem(type,toppings);
    if(fastFoodItem==null){
      JsonObject confirmation = new JsonObject();
      confirmation.addProperty("text", "we do not have this type of fast food item");
      sendJson(confirmation);
      return;
    }
    else {
      JsonObject confirmation = new JsonObject();
      confirmation.addProperty("text", "Description:"+fastFoodItem.getDescription()+" Calories:"+fastFoodItem.getCalories());
      sendJson(confirmation);
      return;
    }
  }

  public void sendJson(JsonObject message) {
    try {
      session.getBasicRemote().sendText(message.toString());
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  @OnError
  public void onError(Throwable e) {
    e.printStackTrace();
  }

  @OnClose
  public void onClose(Session session) {
    //make session null as the session is closed
    this.session = null;
  }
}
