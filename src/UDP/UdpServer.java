package UDP;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class UdpServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket serverDatagramSocket = new DatagramSocket();
        Scanner sc = new Scanner(System.in);
        DatagramPacket datagramPacket;
        String info;
        byte[] buffer;
        while (true){
            info = sc.nextLine();
            buffer = info.getBytes(StandardCharsets.UTF_8);
            datagramPacket = new DatagramPacket(buffer,buffer.length, InetAddress.getByName("127.0.0.1"),3000);
            serverDatagramSocket.send(datagramPacket);
            if (info.equalsIgnoreCase("exit")){
                break;
            }
        }
        serverDatagramSocket.close();
        sc.close();
    }
}
