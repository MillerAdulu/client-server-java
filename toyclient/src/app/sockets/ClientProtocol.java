package app.sockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

import app.models.Message;

public class ClientProtocol {
    public static Socket socket;

    public Message retrieveMessage() throws IOException, ClassNotFoundException {
        InputStream inputStream = socket.getInputStream();

        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        return (Message) objectInputStream.readObject();
    }
}