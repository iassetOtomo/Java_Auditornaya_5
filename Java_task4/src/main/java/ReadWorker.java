import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;

class ReadWorker implements Runnable {
    private Socket serverSocket;
    private BufferedReader in;
    public ReadWorker(Socket serverSocket, BufferedReader in) {
        this.serverSocket = serverSocket;
        this.in = in;
    }

    @Override
    public void run() {
        try {
            while (serverSocket.isConnected()) {
                String serverStr = in.readLine();
                if (serverStr != null) {
                    System.out.println("Server : " + serverStr);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}