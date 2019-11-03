/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketdateandtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author TechnoBoy
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server=new ServerSocket(5000);
        System.out.println("Server Ready!!");
        Socket client=server.accept();
        System.out.println("Client Connected!!");
        PrintWriter pr=new PrintWriter(client.getOutputStream(), true);
        BufferedReader br=new BufferedReader(new InputStreamReader(client.getInputStream()));
        String receive,send = null;
        while(true)
        {
            receive=br.readLine();
            if(receive.compareToIgnoreCase("date")==0){
                DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyy");
                Date date=new Date();
                send="Date : "+dateFormat.format(date);
            }
            else if(receive.compareToIgnoreCase("time")==0){
                DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                Date date=new Date();
                send="Time : "+dateFormat.format(date);
            }
            else{
                send="Invalid Selection";
            }
            pr.println(send);
            pr.flush();
        }
    }
}
