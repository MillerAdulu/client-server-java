package app.sockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import app.models.ToyMessage;

public class SocketProtocol {
    public Socket returnProtocol(ServerSocket socketServer) throws IOException {
        Socket socket = socketServer.accept();
        System.out.println("Connection from " + socket + "!");

        return socket;
    }

    public ToyMessage retrieveMessage(Socket mySocket) throws IOException, ClassNotFoundException {
        InputStream inputStream = mySocket.getInputStream();

        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        return (ToyMessage) objectInputStream.readObject();
    }

    public void printToyMessage(ToyMessage toyMessage) {
        System.out.println("::Toy Message Start::");
        System.out.println(toyMessage.getBatchNumber());
        System.out.println("::Toy Message End::");
    }

    public void close(Socket socket) throws IOException {
        System.out.println("Closing sockets.");
        socket.close();
    }
}