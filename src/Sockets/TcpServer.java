package Sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static void main(String[] args) throws IOException {
        System.out.println("*******Server Side*****");
        ServerSocket serverSocket = new ServerSocket(3000);
        System.out.println("Server is listening!");
        Socket server = serverSocket.accept();
        System.out.println("Connection established!");
        InputStream serverIs = server.getInputStream();
        BufferedReader serverBr = new BufferedReader(new InputStreamReader(serverIs));
        String filename = serverBr.readLine();
        System.out.println("File Name: " + filename);
        BufferedReader fileCheckBr = new BufferedReader(new FileReader(filename));
        OutputStream serverOs = server.getOutputStream();
        PrintWriter serverPw = new PrintWriter(serverOs,true);
        String lines;
        while((lines = fileCheckBr.readLine())!= null){
            serverPw.println(lines);
        }
        serverSocket.close();
        fileCheckBr.close();
    }
}
