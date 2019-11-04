/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datagramoddoreven;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author TechnoBoy
 */
public class Server {
    public static void main(String[] args) throws SocketException, IOException {
        DatagramSocket ds=new DatagramSocket(5000);
        System.out.println("Server Ready!!!");
        InetAddress ip=InetAddress.getLocalHost();
        byte[] receivedata=new byte[1024];
        byte[] senddata;
        String data,number;
        while(true)
        {
            DatagramPacket dp=new DatagramPacket(receivedata, receivedata.length);
            ds.receive(dp);
            number=new String(dp.getData());
            int no=Integer.parseInt(number.trim());
                        
            if(no%2==0)
            {
                data=no+" is Even Number";
            }
            else
            {
                data=no+" is Odd Number";
            }
            DatagramPacket dp1=new DatagramPacket(data.getBytes(), data.length(), ip, dp.getPort());
            ds.send(dp1);
        }
        
    }
}
