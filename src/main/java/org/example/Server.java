package org.example;

public class Server extends Thread {
  public void run() {
    try {
      System.out.println("===== Server started! =====");
      Thread.sleep(5000);
      System.out.println("===== Server stopped! =====");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
