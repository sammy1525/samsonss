package edu.umn.cs.csci3081w.lab11;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import javax.websocket.Session;

public class FiveStudentsTest {

  @Test
  public void testHamburgerWithGrilledMushrooms() {
    //we are using the Mockito spy API method as we want to
    //preserve the implementation of the methods inside FiveStudentsWebServer.
    //Please note that the spy method does not mean that we are creating a
    // test double of type spy
    FiveStudentsWebServer fiveStudentsWebServer = spy(FiveStudentsWebServer.class);
    //tell the test double to not do anything when the method sendJson is
    //called with a JSON object parameter
    doNothing().when(fiveStudentsWebServer).sendJson(Mockito.isA(JsonObject.class));
    //create a dummy object for the session as we need it to open the session
    Session sessionDummy = mock(Session.class);
    //open session
    fiveStudentsWebServer.onOpen(sessionDummy);
    //prepare input to send to fiveStudentsWebServer
    JsonObject order = new JsonObject();
    order.addProperty("text", "hamburger grilledmushrooms");
    //send the input to the FiveStudents software
    fiveStudentsWebServer.onMessage(order.toString());
    //capture the JSON object passed to the sendJson method of the fiveStudentsWebServer
    ArgumentCaptor<JsonObject> messageCaptor = ArgumentCaptor.forClass(JsonObject.class);
    verify(fiveStudentsWebServer).sendJson(messageCaptor.capture());
    //check that we have the expected output
    JsonObject message = messageCaptor.getValue();
    String expected = "Description:hamburger grilled mushrooms Calories:890";
    assertEquals(expected, message.get("text").getAsString());
  }

}
