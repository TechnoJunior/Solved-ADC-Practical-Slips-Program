/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketpalindrome;

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
        int number,temp,sum = 0,remainder;
        while(true)
        {
            number=Integer.parseInt(br.readLine());
            temp=number;
            while(number>0){
                remainder=number%10;
                sum=(sum*10)+remainder;
                number=number/10;
            }
            if(temp==sum){
                send=temp+" is a Palindrome Number";
            }
            else{
                send=temp+" is not a Palindrome Number";
            }
            pr.println(send);
            pr.flush();
        }
    }
}
