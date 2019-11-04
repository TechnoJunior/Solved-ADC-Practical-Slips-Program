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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TechnoBoy
 */
public class Server {
    public static void main(String[] args) throws SocketException{
        DatagramSocket ds=new DatagramSocket(5000);
        System.out.println("Server Ready!!!");
        DatagramPacket receivepacket,sendpacket;
        InetAddress ip;
        byte[] receive,send;
        while(true)
        {
        try {
            String msg;
            receive=new byte[1024];
            //receiving Data
            receivepacket=new DatagramPacket(receive, receive.length);
            ds.receive(receivepacket);
            msg=new String(receivepacket.getData()).trim();
            System.out.println(msg);
            ip=InetAddress.getLocalHost();
            
            if(msg.equalsIgnoreCase("date"))
            {
                DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyy");
                Date date=new Date();
                msg="Date : "+dateFormat.format(date);
            }
            if(msg.equalsIgnoreCase("time"))
            {
                DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                Date date=new Date();
                msg="Time : "+dateFormat.format(date);
            }
            //sending data
            send=msg.getBytes();
            sendpacket=new DatagramPacket(send, send.length,ip,receivepacket.getPort());
            System.out.println(msg);
            ds.send(sendpacket);
            
        } catch (SocketException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        }        
    }
}
