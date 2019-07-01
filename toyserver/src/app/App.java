package app;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import app.models.Batch1;
import app.models.Batch2;
import app.models.Batch3;
import app.models.ToyMessage;
import app.sockets.SocketProtocol;

public class App {
    private static Socket socket;
    private static ServerSocket serverSocket;
    private static SocketProtocol socketProtocol;
    private static InputStream inputStream;

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        try {

            serverSocket = new ServerSocket(7777);
            System.out.println("ServerSocket awaiting connections...");

            while (true) {
                socket = serverSocket.accept();
                socketProtocol = new SocketProtocol();
                socket.setKeepAlive(true);

                System.out.println("Connection from " + socket + "!");

                SocketProtocol.socket = socket;

                socketProtocol.sendMessage("Send Batch 1");

                inputStream = socket.getInputStream();

                while (true) {

                    Batch1 batch1 = socketProtocol.retrieveBatch1();
                    socketProtocol.batch1Print(batch1);

                    socketProtocol.sendMessage("Send Batch 2");

                    Batch2 batch2 = socketProtocol.retrieveBatch2();
                    socketProtocol.batch2Print(batch2);

                    socketProtocol.sendMessage("Send Batch 3");

                    Batch3 batch3 = socketProtocol.retrieveBatch3();
                    socketProtocol.batch3Print(batch3);

                    socketProtocol.sendMessage("Send eveerything");

                    ToyMessage toyMessage = socketProtocol.retrieveToyMessage();
                    socketProtocol.toyMessagePrint(toyMessage);
                    
                    socketProtocol.sendMessage("It's finished");

                }

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                System.out.println("Closing socket server.");
                serverSocket.close();
                System.out.println("Closing sockets.");
                socket.close();

            } catch (Exception ex1) {
            }
        }
    }
}