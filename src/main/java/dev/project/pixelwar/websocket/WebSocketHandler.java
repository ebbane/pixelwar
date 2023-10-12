package dev.project.pixelwar.websocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.project.pixelwar.model.PixelMessageFront;
import dev.project.pixelwar.service.PixelwarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class WebSocketHandler extends TextWebSocketHandler {

  @Autowired
  private PixelwarService pixelwarService;

  @Override
  protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    super.handleTextMessage(session, message);
    try {
      String jsonMessage = message.getPayload();
      ObjectMapper objectMapper = new ObjectMapper();
      PixelMessageFront pixel = objectMapper.readValue(jsonMessage, PixelMessageFront.class);
      pixelwarService.savePixel(pixel);

      String response = objectMapper.writeValueAsString(pixelwarService.getPixels());
      session.sendMessage(new TextMessage(response));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}


