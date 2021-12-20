package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket clientDatagramSocket = new DatagramSocket(3000);
        DatagramPacket dp;
        byte [] buffer;
        String info;
        while (true){
            buffer = new byte[4000];
            dp = new DatagramPacket(buffer,buffer.length);
            clientDatagramSocket.receive(dp);
            info = new String(buffer);
            System.out.println(info);
            if(info.trim().equalsIgnoreCase("exit")){
                break;
            }
        }
        clientDatagramSocket.close();
    }
}
