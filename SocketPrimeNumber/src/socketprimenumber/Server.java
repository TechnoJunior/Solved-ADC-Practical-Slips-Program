/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketprimenumber;

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
        String send,receive,reverse = "";
        while(true)
        {
            receive=br.readLine();
            int length=receive.length();
            for(int i=length-1;i>=0;i--){
                reverse=reverse+receive.charAt(i);
            }
            if(receive.equals(reverse)){
                send=receive+" is a Palindrome String";
            }
            else{
                send=receive+" is not a Palindrome String";
            }
            pr.println(send);
            pr.flush();
        }
    }
}
