package app.sockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import app.models.Batch1;
import app.models.Batch2;
import app.models.Batch3;
import app.models.Message;
import app.models.ToyMessage;

public class ClientProtocol {
    public static Socket socket;

    public Message retrieveMessage() throws IOException, ClassNotFoundException {
        InputStream inputStream = socket.getInputStream();

        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        return (Message) objectInputStream.readObject();
    }

    public void sendBatch1(Batch1 batch1) throws IOException {
        OutputStream outputStream = socket.getOutputStream();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(batch1);
    }

    public void sendBatch2(Batch2 batch2) throws IOException {
        OutputStream outputStream = socket.getOutputStream();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(batch2);
    }

    public void sendBatch3(Batch3 batch3) throws IOException {
        OutputStream outputStream = socket.getOutputStream();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(batch3);
    }

    public void sendToyMessage(ToyMessage toyMessage) throws IOException {
        OutputStream outputStream = socket.getOutputStream();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(toyMessage);
    }

    public void sendMessage(String message) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        Message msg = new Message();
        msg.setMessage(message);

        objectOutputStream.writeObject(msg);
    }
}