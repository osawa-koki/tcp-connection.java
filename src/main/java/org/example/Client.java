package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
  public static void run() {
    try (
      Socket socket = new Socket("localhost", 8000);
      PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
      BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    ) {
      writer.println("GET / HTTP/1.1");
      writer.println("Host: localhost:8000");
      writer.println("");
      writer.println("1: Apple");
      writer.println("2: Banana");
      writer.println("3: Cherry");
      writer.flush();

      String line = null;
      while ((line = reader.readLine()) != null) {
        System.out.println("<<<<<< " + line);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
