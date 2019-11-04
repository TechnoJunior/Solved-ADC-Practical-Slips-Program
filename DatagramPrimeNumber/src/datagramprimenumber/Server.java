/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datagramprimenumber;

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
        String data = null,number;
        while(true)
        {
            DatagramPacket dp=new DatagramPacket(receivedata, receivedata.length);
            ds.receive(dp);
            number=new String(dp.getData());
            int no=Integer.parseInt(number.trim());
            boolean flag =false;
            for(int i=2;i<=no/2;++i){
                if(no%i==0){
                    flag=true;
                    break;
                }
            }
            if(!flag){
                data=no+" is a Prime Number";
            }
            else{
                data=no+" is not a Prime Number";
            }                
            DatagramPacket dp1=new DatagramPacket(data.getBytes(), data.length(), ip, dp.getPort());
            ds.send(dp1);
            receivedata=new byte[1024];
        }
        
    }
}
