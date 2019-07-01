package app;

import static app.ToyUI.setSessionSocket;

import java.net.Socket;

import app.models.Message;
import app.sockets.ClientProtocol;

public class SocketClient {

    private static ClientProtocol clientProtocol;

    private static ToyUI newToy;

    public static void main(String[] args) {

        try (Socket socket = new Socket("localhost", 7777)) {

            socket.setKeepAlive(true);
            setSessionSocket(socket);

            System.out.println("Connected!");

            newToy = new ToyUI();

            clientProtocol = new ClientProtocol();
            ClientProtocol.socket = socket;

            newToy.prepUI();

            while (true) {
                Message msg = clientProtocol.retrieveMessage();
                System.out.println(msg.getMessage());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
