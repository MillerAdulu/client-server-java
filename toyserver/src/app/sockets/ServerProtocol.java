package app.sockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import app.models.Batch1;
import app.models.Batch2;
import app.models.Batch3;
import app.models.ToyMessage;
import app.models.Message;

public class ServerProtocol {
    public static Socket socket;

    public Socket returnProtocol(ServerSocket socketServer) throws IOException {
        Socket socket = socketServer.accept();
        System.out.println("Connection from " + socket + "!");

        return socket;
    }

    public Batch1 retrieveBatch1() throws IOException, ClassNotFoundException {
        InputStream inputStream = socket.getInputStream();

        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        return (Batch1) objectInputStream.readObject();
    }

    public void batch1Print(Batch1 targetMessage) {
        System.out.println("Batch 1 Received");
        System.out.println(":: Batch 1 Start ::");
        System.out.println(targetMessage);
        System.out.println(":: Batch 1 End ::");
    }

    public Batch2 retrieveBatch2() throws IOException, ClassNotFoundException {
        InputStream inputStream = socket.getInputStream();

        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        return (Batch2) objectInputStream.readObject();
    }

    public void batch2Print(Batch2 targetMessage) {
        System.out.println("Batch 2 Received");
        System.out.println("::Toy Message Start::");

        System.out.println(targetMessage);

        System.out.println("::Toy Message End::");
    }

    public Batch3 retrieveBatch3() throws IOException, ClassNotFoundException {
        InputStream inputStream = socket.getInputStream();

        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        return (Batch3) objectInputStream.readObject();
    }

    public void batch3Print(Batch3 targetMessage) {
        System.out.println("Batch 3 Received");
        System.out.println("::Toy Message Start::");

        System.out.println(targetMessage);

        System.out.println("::Toy Message End::");
    }

    public Message retrieveThanksMessage() throws IOException, ClassNotFoundException {
        System.out.println("Thanks message received");
        InputStream inputStream = socket.getInputStream();

        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        return (Message) objectInputStream.readObject();
    }

    public void thanksMessagePrint(Message targetMessage) {
        System.out.println("Thanks Received");
        System.out.println("::Thanks Message Start::");

        System.out.println(targetMessage.getMessage());

        System.out.println("::Thanks Message End::");
    }

    public ToyMessage retrieveToyMessage() throws IOException, ClassNotFoundException {
        InputStream inputStream = socket.getInputStream();

        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        return (ToyMessage) objectInputStream.readObject();
    }

    public void toyMessagePrint(ToyMessage targetMessage) {
        System.out.println("Toy Message Received");
        System.out.println("::Toy Message Start::");

        System.out.println(targetMessage);

        System.out.println("::Toy Message End::");
    }

    public void sendMessage(String message) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        Message msg = new Message();
        msg.setMessage(message);

        objectOutputStream.writeObject(msg);
    }

    public void close(Socket socket) throws IOException {
        System.out.println("Closing sockets.");
        socket.close();
    }
}