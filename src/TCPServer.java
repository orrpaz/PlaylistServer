import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    private int port;
    Socket connectionSocket;
    ServerSocket server;
    public TCPServer(int port){
        this.port = port;
    }
    public void startServer()  {
        while(true) {
            try {
                server = new ServerSocket(6789);
                System.out.println("Wait to client:");
                connectionSocket = server.accept();
                System.out.println("Client accepted");
                readFromSocket();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void readFromSocket(){
        String sentence = "start";
        while(sentence.compareTo("exit") != 0) {
            BufferedReader massage = null;
            try {
                massage = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                sentence = massage.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Received: " + sentence);
        }
        System.out.println("Client exit");
    }
}