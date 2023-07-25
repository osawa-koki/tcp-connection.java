package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
  public void run() {
    try {
      System.out.println("===== Server started! =====");
      try (ServerSocket server = new ServerSocket(8000)) {
        while (true) {
          try {
            Socket sc = server.accept();
            System.out.println("=====> クライアントからの接続がありました。");
            BufferedReader reader = null;
            PrintWriter writer = null;

            try {
              reader = new BufferedReader(new InputStreamReader(sc.getInputStream()));
              writer = new PrintWriter(sc.getOutputStream(), true);
              String line = null;

              writer.println("HTTP/1.1 200 OK");
              writer.println("Content-Type: text/plain; charset=utf-8");
              writer.println("");

              while (reader.ready()) {
                line = reader.readLine();
                System.out.println("=====> " + line);
                writer.println(line);
              }
              System.out.println("=====> クライアントとの通信が終了しました。");
            } catch (Exception e) {
              e.printStackTrace();
            } finally {
              // リソースの解放。
              System.out.println("=====> クライアントとの接続を閉じます。");
              if (reader != null) reader.close();
              if (writer != null) writer.close();
              if (sc != null) sc.close();
              System.out.println("=====> クライアントとの接続を閉じました。");
            }
          } catch (Exception ex) {
            ex.printStackTrace();
            break;
          }
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
      System.out.println("===== Server stopped! =====");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
