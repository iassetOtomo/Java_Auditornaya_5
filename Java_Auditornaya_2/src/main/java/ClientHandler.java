import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientHandler implements Runnable{
    private Socket clientSocket;
    private BufferedReader in;
    private BufferedWriter out;
    public ClientHandler(Socket clientSocket){
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try{

            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            String msg = in.readLine();

            System.out.println(msg);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
