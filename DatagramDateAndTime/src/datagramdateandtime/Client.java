/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datagramdateandtime;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TechnoBoy
 */
public class Client {
    public static void main(String[] args) {
        DatagramSocket ds;
        DatagramPacket receivepacket,sendpacket;
        InetAddress ip;
        byte[] receive,send;
        String msg,recvdmsg;
        Scanner sc;
                
        while(true)
        {
        try {
            ds=new DatagramSocket();
            ip=InetAddress.getLocalHost();
            sc=new Scanner(System.in);
            System.out.println("Enter Operation to Perform (Date,Time)");
            msg=sc.next();
            send=msg.getBytes();
            
            //To Send Data
            sendpacket=new DatagramPacket(send, send.length, ip, 5000);
            ds.send(sendpacket);
            
            //To Receive Data
            receive=new byte[1024];
            receivepacket=new DatagramPacket(receive, receive.length);
            ds.receive(receivepacket);
            recvdmsg=new String(receivepacket.getData(),0,receivepacket.getLength());
            System.out.println(recvdmsg);
            
        } catch (SocketException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
}
