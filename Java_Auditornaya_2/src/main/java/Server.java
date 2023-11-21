import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    public void start() throws IOException {
        serverSocket = new ServerSocket(27030);
        while(true){
            Socket incomingConnection = serverSocket.accept();
            ClientHandler client = new ClientHandler(incomingConnection);
            Thread clientThread = new Thread(client);
            clientThread.start();
        }
    }
}
