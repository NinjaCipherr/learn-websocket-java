package io.NinjaCipherr.learn_Websocket;

import java.util.ArrayList;

import org.springframework.messaging.simp.SimpMessagingTemplate;

/**
 * WebSocketSessionManager
 */
public class WebSocketSessionManager {
  private final ArrayList<String> activeUsername = new ArrayList<>();

  private final SimpMessagingTemplate messagingTemplate;

  public WebSocketSessionManager(SimpMessagingTemplate messagingTemplate) {
    this.messagingTemplate = messagingTemplate;
  }

  public void addUsername(String username) {
    activeUsername.add(username);
  }

  public void removeUsername(String username) {
    activeUsername.remove(username);
  }

  public void broadcastActiveUsernames() {
    messagingTemplate.convertAndSend("/topic/users", activeUsername);
    System.out.println("broadcastActiveUsernames to /topic/users");
  }

}
