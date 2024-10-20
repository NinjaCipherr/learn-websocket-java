package io.greenCode.learn_Websocket;

/**
 * Message
 */
public class Message {
  private String user;
  private String message;

  public Message() {
  }

  public Message(String user, String message) {
    this.user = user;
    this.message = message;
  }

  public String getUser() {
    return this.user;
  }

  public String getMessage() {
    return this.message;
  }
}
