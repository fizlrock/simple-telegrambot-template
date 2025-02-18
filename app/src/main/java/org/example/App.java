package org.example;

/** App */
public class App extends TGBot {

  public static void main(String[] args) {
    setToken("PLACE_YOUR TOKEN HERE");
    start();
  }

  @Command("start")
  String startCommand() {
    return "Привет";
  }

  @Command("square")
  String authorCommand(int a, int b) {

    return a * b + "";
  }
}
