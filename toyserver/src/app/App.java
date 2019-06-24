package app;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import app.models.ToyMessage;

public class App {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ServerSocket ss = new ServerSocket(7777);
        System.out.println("ServerSocket awaiting connections...");

        Socket socket = ss.accept(); // blocking call, this will wait until a connection is attempted on this port.
        System.out.println("Connection from " + socket + "!");

        // get the input stream from the connected socket
        InputStream inputStream = socket.getInputStream();

        // create a DataInputStream so we can read data from it.
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        ToyMessage message = (ToyMessage) objectInputStream.readObject();

        System.out.println("Messages:");
        System.out.println(message.getBatchNumber());

        System.out.println("Closing sockets.");

        ss.close();
        socket.close();
    }
}