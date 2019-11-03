/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

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
        String send = null;
        int number1,number2;
        while(true)
        {
            number1=Integer.parseInt(br.readLine());
            number2=Integer.parseInt(br.readLine());
            send="Addition of "+number1+" & "+number2+" = "+String.valueOf(number1+number2);
            pr.println(send);
            pr.flush();
        }
    }
}
