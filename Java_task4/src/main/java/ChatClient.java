import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    private static Socket serverSocket;

    public static void main(String[] args) throws IOException {
        serverSocket = new Socket("services.tms-studio.ru", 27015);
        BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(serverSocket.getOutputStream()));

        Scanner scanner = new Scanner(System.in);
        String nickName = scanner.nextLine();
        System.out.println("Ваш ник: "+nickName);

        out.write(nickName + "\n");
        out.flush();

        if(serverSocket.isConnected()){
            Thread readThread = new Thread(new ReadWorker(serverSocket, in));
            Thread writeTread = new Thread(new WriteWorker(serverSocket, out));

            readThread.start();
            writeTread.start();

            while(serverSocket.isConnected()){
                Thread.onSpinWait();
            }
        }
    }
}
