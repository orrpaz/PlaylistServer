import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    private int port;
    private Socket connectionSocket;
    private ServerSocket server;
//    private static TCPServer instance = null;

    public TCPServer(int port){
        this.port = port;
        startServer();
    }
//    public static TCPServer getInstance()
//    {
//        if (instance == null)
//            instance = new TCPServer(6789);
//
//        return instance;
//    }
    public void startServer()  {
//        while(true) {
            try {
                server = new ServerSocket(6788);
                System.out.println("Wait to client:");
                connectionSocket = server.accept();
                System.out.println("Client accepted");
            } catch (IOException e) {
                e.printStackTrace();
            }
//        }
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
    public void sendToSocket(String message){
        OutputStream os = null;
        try {
            os = connectionSocket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(message);
            System.out.println("Message sent to the client is: \n"+message);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}