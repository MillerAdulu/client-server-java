package app;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import app.models.Batch1;
import app.models.Batch2;
import app.models.Batch3;
import app.models.Message;
import app.models.ToyMessage;
import app.sockets.ServerProtocol;

public class SocketServer {
    private static Socket socket;
    private static ServerSocket serverSocket;
    private static ServerProtocol socketProtocol;

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        try {

            serverSocket = new ServerSocket(7777);
            System.out.println("ServerSocket awaiting connections...");

            while (true) {
                socket = serverSocket.accept();
                socketProtocol = new ServerProtocol();
                socket.setKeepAlive(true);

                System.out.println("Connection from " + socket + "!");

                ServerProtocol.socket = socket;

                while (true) {
                    socketProtocol.sendMessage("Send Batch 1");

                    Batch1 batch1 = socketProtocol.retrieveBatch1();
                    socketProtocol.batch1Print(batch1);
                    socketProtocol.sendMessage("Send Batch 2");

                    Batch2 batch2 = socketProtocol.retrieveBatch2();
                    socketProtocol.batch2Print(batch2);
                    socketProtocol.sendMessage("Send Batch 3");

                    Batch3 batch3 = socketProtocol.retrieveBatch3();
                    socketProtocol.batch3Print(batch3);
                    socketProtocol.sendMessage("Send thank you message with unique ID");

                    Message thanks = socketProtocol.retrieveThanksMessage();
                    socketProtocol.thanksMessagePrint(thanks);
                    socketProtocol.sendMessage("Please send everything now");

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