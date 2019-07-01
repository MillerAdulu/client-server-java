package app;

import static app.ToyUI.setSessionSocket;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

import app.models.Message;
import app.sockets.ClientProtocol;

public class App {

    private static ClientProtocol clientProtocol;

    private static ToyUI newToy;

    public static void main(String[] args) {
        ObjectInputStream objInpStream;
        InputStream inputStream;

        try (Socket socket = new Socket("localhost", 7777)) {

            socket.setKeepAlive(true);
            System.out.println("Connected!");
            newToy = new ToyUI();
            setSessionSocket(socket);
            clientProtocol = new ClientProtocol();
            ClientProtocol.socket = socket;
            newToy.prepUI();
            inputStream = socket.getInputStream();

            while (true) {
                System.out.println("Whiling..");

                Message msg = clientProtocol.retrieveMessage();
                System.out.println(msg.getMessage());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
