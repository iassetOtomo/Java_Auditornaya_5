import java.io.BufferedWriter;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

class WriteWorker implements Runnable {
    private Socket serverSocket;
    private BufferedWriter out;
    public WriteWorker(Socket serverSocket, BufferedWriter out){
        this.serverSocket = serverSocket;
        this.out = out;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String userMsg;

        try {
            while (serverSocket.isConnected()) {
                userMsg = scanner.nextLine();
                out.write(userMsg + "\n");
                out.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}