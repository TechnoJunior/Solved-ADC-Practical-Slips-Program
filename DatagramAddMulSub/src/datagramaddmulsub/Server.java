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

/**
 *
 * @author TechnoBoy
 */
public class Server {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        DatagramSocket ds=new DatagramSocket(5000);
        System.out.println("Server Ready!!!");
        InetAddress ip=InetAddress.getLocalHost();
        byte[] receivedata=new byte[1024];
        int no1,no2;
        String number,data = null;
        while(true)
        {
            DatagramPacket dp=new DatagramPacket(receivedata, receivedata.length);
            ds.receive(dp);
            number=new String(dp.getData()).toLowerCase();
            no1=Integer.parseInt(String.valueOf(number.charAt(3)));
            no2=Integer.parseInt(String.valueOf(number.charAt(4)));
            if(number.contains("add")){
                data="Addition of "+no1+" & "+no2+" : "+String.valueOf(no1+no2);
            }
            else if(number.contains("sub")){
                data="Subtraction of "+no1+" & "+no2+" : "+String.valueOf(no1-no2);
            }
            else if(number.contains("mul")){
                data="Multiplication of "+no1+" & "+no2+" : "+String.valueOf(no1*no2);
            }
            else if(number.contains("div")){
                data="Division of "+no1+" & "+no2+" : "+String.valueOf(no1/no2);
            }
            DatagramPacket dp1;
            dp1 = new DatagramPacket(data.getBytes(), data.length(), ip, dp.getPort());
            ds.send(dp1);
        }
    }
}
