package lesson22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChatServer {
    public static final int SERVER_PORT = 2048;
    public static final String EXIT_COMMAND = "/exit";
    public static final String RENAME_COMMAND = "/rename";
    public static final String WHO_COMMAND = "/who";

    private List<ClientHandler> clients;

    public static void main(String[] args) {
        new ChatServer();

    }

    public ChatServer() {
        int clientCount = 0;
        clients = new ArrayList<>();
        System.out.println("Server started ...");
        try (ServerSocket server = new ServerSocket(SERVER_PORT)) {
            while (true) {
                Socket socket = server.accept();
                String name = "Client #" + (++clientCount);
                sendToAll(name, "joined.");
                System.out.println(name + ": joined.");
                ClientHandler client = new ClientHandler(socket, name);
                clients.add(client);
                new Thread(client).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendToAll(String name, String message) {
        for (ClientHandler client : clients) {
            if (!name.equals(client.getName())) {
                client.send(name + ": " + message);
            }
        }
    }

    private class ClientHandler implements Runnable {
        private BufferedReader reader;
        private PrintWriter writer;
        private Socket socket;
        private String name;

        public ClientHandler(Socket socket, String name) {
            this.socket = socket;
            this.name = name;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void send(String message) {
            writer.println(message);
            writer.flush();
        }

        public String getName() {
            return name;
        }

        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);
            String message;
            try {
                do {
                    message = reader.readLine();
                    if (message.equalsIgnoreCase(RENAME_COMMAND)) {
                        send(message);
                        message = reader.readLine();
                        name = message;

                    }

                    if (message.equalsIgnoreCase(EXIT_COMMAND)) {
                        send(message);
                    }
                    sendToAll(name, message);
                    System.out.println(name + ": " + message);


                } while (!message.equalsIgnoreCase(EXIT_COMMAND));
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            clients.remove(this);
            System.out.println(name + "disconnected.");
        }
    }
}
