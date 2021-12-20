package Sockets;

import java.io.*;
import java.net.Socket;

public class TcpClient {
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("127.0.0.1",3000);
        System.out.println("*****Client Side******");
        System.out.println("Enter file name: ");
        BufferedReader clientBr = new BufferedReader(new InputStreamReader(System.in));
        String fileName = clientBr.readLine();
        OutputStream clientOs = clientSocket.getOutputStream();
        PrintWriter printWriter = new PrintWriter(clientOs,true);
        printWriter.println("File: "+fileName);
        InputStream is = clientSocket.getInputStream();
        BufferedReader fileBr = new BufferedReader(new InputStreamReader(is));
        String lines;
        while((lines=fileBr.readLine()) != null){
            System.out.println(lines);
        }
        clientSocket.close();
    }
}
