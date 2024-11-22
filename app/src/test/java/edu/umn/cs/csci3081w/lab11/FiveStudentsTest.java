package edu.umn.cs.csci3081w.lab11;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import javax.websocket.Session;

public class FiveStudentsTest {

  @Test
  public void testValidOrder_HamburgerWithGrilledMushrooms() {
    FiveStudentsWebServer server = spy(FiveStudentsWebServer.class);
    doNothing().when(server).sendJson(isA(JsonObject.class));
    Session sessionDummy = mock(Session.class);
    server.onOpen(sessionDummy);

    JsonObject order = new JsonObject();
    order.addProperty("text", "hamburger grilledmushrooms");
    server.onMessage(order.toString());

    ArgumentCaptor<JsonObject> captor = ArgumentCaptor.forClass(JsonObject.class);
    verify(server).sendJson(captor.capture());
    JsonObject response = captor.getValue();
    String expected = "Description:hamburger grilled mushrooms Calories:890";
    assertEquals(expected, response.get("text").getAsString());
  }

  @Test
  public void testValidOrder_HotDogWithMultipleToppings() {
    FiveStudentsWebServer server = spy(FiveStudentsWebServer.class);
    doNothing().when(server).sendJson(isA(JsonObject.class));
    Session sessionDummy = mock(Session.class);
    server.onOpen(sessionDummy);

    JsonObject order = new JsonObject();
    order.addProperty("text", "hotdog grilledonions,grilledmushrooms,jalapenopeppers");
    server.onMessage(order.toString());

    ArgumentCaptor<JsonObject> captor = ArgumentCaptor.forClass(JsonObject.class);
    verify(server).sendJson(captor.capture());
    JsonObject response = captor.getValue();
    String expected = "Description:hotdog grilled onions grilled mushrooms jalapeno peppers Calories:555";
    assertEquals(expected, response.get("text").getAsString());
  }

  @Test
  public void testValidOrder_SandwichWithoutToppings() {
    FiveStudentsWebServer server = spy(FiveStudentsWebServer.class);
    doNothing().when(server).sendJson(isA(JsonObject.class));
    Session sessionDummy = mock(Session.class);
    server.onOpen(sessionDummy);

    JsonObject order = new JsonObject();
    order.addProperty("text", "sandwich");
    server.onMessage(order.toString());

    ArgumentCaptor<JsonObject> captor = ArgumentCaptor.forClass(JsonObject.class);
    verify(server).sendJson(captor.capture());
    JsonObject response = captor.getValue();
    String expected = "Description:sandwich Calories:290";
    assertEquals(expected, response.get("text").getAsString());
  }

  @Test
  public void testInvalidOrder_UnknownFoodItem() {
    FiveStudentsWebServer server = spy(FiveStudentsWebServer.class);
    doNothing().when(server).sendJson(isA(JsonObject.class));
    Session sessionDummy = mock(Session.class);
    server.onOpen(sessionDummy);

    JsonObject order = new JsonObject();
    order.addProperty("text", "pizza grilledmushrooms");
    server.onMessage(order.toString());

    ArgumentCaptor<JsonObject> captor = ArgumentCaptor.forClass(JsonObject.class);
    verify(server).sendJson(captor.capture());
    JsonObject response = captor.getValue();
    String expected = "we do not have this type of fast food item";
    assertEquals(expected, response.get("text").getAsString());
  }

  @Test
  public void testInvalidOrder_WrongFormat() {
    FiveStudentsWebServer server = spy(FiveStudentsWebServer.class);
    doNothing().when(server).sendJson(isA(JsonObject.class));
    Session sessionDummy = mock(Session.class);
    server.onOpen(sessionDummy);

    JsonObject order = new JsonObject();
    order.addProperty("text", "hamburger grilledmushrooms extra");
    server.onMessage(order.toString());

    ArgumentCaptor<JsonObject> captor = ArgumentCaptor.forClass(JsonObject.class);
    verify(server).sendJson(captor.capture());
    JsonObject response = captor.getValue();
    String expected = "the fast food item order is not right";
    assertEquals(expected, response.get("text").getAsString());
  }

  @Test
  public void testEdgeCase_EmptyOrder() {
    FiveStudentsWebServer server = spy(FiveStudentsWebServer.class);
    doNothing().when(server).sendJson(isA(JsonObject.class));
    Session sessionDummy = mock(Session.class);
    server.onOpen(sessionDummy);

    JsonObject order = new JsonObject();
    order.addProperty("text", "");
    server.onMessage(order.toString());

    ArgumentCaptor<JsonObject> captor = ArgumentCaptor.forClass(JsonObject.class);
    verify(server).sendJson(captor.capture());
    JsonObject response = captor.getValue();
    String expected = "the fast food item order is not right";
    assertEquals(expected, response.get("text").getAsString());
  }

  @Test
  public void testEdgeCase_EmptyToppings() {
    FiveStudentsWebServer server = spy(FiveStudentsWebServer.class);
    doNothing().when(server).sendJson(isA(JsonObject.class));
    Session sessionDummy = mock(Session.class);
    server.onOpen(sessionDummy);

    JsonObject order = new JsonObject();
    order.addProperty("text", "hotdog ");
    server.onMessage(order.toString());

    ArgumentCaptor<JsonObject> captor = ArgumentCaptor.forClass(JsonObject.class);
    verify(server).sendJson(captor.capture());
    JsonObject response = captor.getValue();
    String expected = "Description:hotdog Calories:520";
    assertEquals(expected, response.get("text").getAsString());
  }
}
