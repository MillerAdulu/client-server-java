package app.sockets;

import java.io.IOException;
import java.net.ServerSocket;

public class SocketServer {

    public ServerSocket connect() throws IOException {
        ServerSocket serverSocket = new ServerSocket(7777);
        System.out.println("ServerSocket awaiting connections...");

        return serverSocket;
    }

    public void close(ServerSocket serverSocket) throws IOException {
        serverSocket.close();
    }
}