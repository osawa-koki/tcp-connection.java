package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
  public static void main(String[] args) {
    // Press Opt+Enter with your caret at the highlighted text to see how
    // IntelliJ IDEA suggests fixing it.
    System.out.println("");
    System.out.println("----- Hello and welcome! -----");
    System.out.println("");

    try {
      Server server = new Server();
      server.start();
      System.out.println("start...");

      // 待機する。
      server.join();
      System.out.println("all completed!");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
