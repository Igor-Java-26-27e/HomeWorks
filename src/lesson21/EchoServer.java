package lesson21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        new EchoServer();
    }

    EchoServer() {
        try (ServerSocket server = new ServerSocket(2048)) {
            System.out.println("Server started ...");
            while (true) {
                Socket socket = server.accept();
                System.out.println("Connection to client...");
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                String msg;
                do {
                    msg = reader.readLine();
                    writer.println("Echo: " + msg);
                    writer.flush();
                    System.out.println("Client: " + msg);
                }while(!msg.equals("exit"));
                writer.close();
                reader.close();
                System.out.println("Client diconected.");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
