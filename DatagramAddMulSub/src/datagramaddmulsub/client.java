/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datagramaddmulsub;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author TechnoBoy
 */
public class client {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        DatagramSocket ds=new DatagramSocket();
        Scanner sc=new Scanner(System.in);
        InetAddress ip=InetAddress.getLocalHost();
        byte[] senddata,receivedata;        
        String number1,number2,op,send,data;
        
        while(true)
        {
            System.out.print("Enter operation to Perform(add,sub,mul,div)");
            op=sc.next();
            System.out.print("Enter a number : ");
            number1=sc.next();
            System.out.print("Enter a number : ");
            number2=sc.next();
            send=op+number1+number2;
            senddata=send.getBytes();
            DatagramPacket dp=new DatagramPacket(send.getBytes(), senddata.length, ip, 5000);
            ds.send(dp);
            
            receivedata=new byte[1024];
            DatagramPacket dp1=new DatagramPacket(receivedata,receivedata.length);
            ds.receive(dp1);
            data=new String(dp1.getData());
            System.out.println(data);
        }
    }
}
