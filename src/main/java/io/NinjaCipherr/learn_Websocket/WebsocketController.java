package io.NinjaCipherr.learn_Websocket;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;

/**
 * WebsocketController
 */
@Controller
public class WebsocketController {
  private final SimpMessagingTemplate simpMessagingTemplate;
  private final WebSocketSessionManager sessionManager;

  @Autowired
  public WebsocketController(SimpMessagingTemplate simpMessagingTemplate, WebSocketSessionManager sessionManager) {
    this.simpMessagingTemplate = simpMessagingTemplate;
    this.sessionManager = sessionManager;
  }

  @MessageMapping("/message")
  public void handleMessage(Message message) {
    System.out.println("Received message from user: " + message.getUser() + ":" + message.getMessage());
    simpMessagingTemplate.convertAndSend("/topic/message", message);
    System.out.println("Sent message to /topic/messages: " + message.getUser() + ": " + message.getMessage());
  }

}
