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
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author TechnoBoy
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("localhost",5000);
        System.out.println("Server Connected");
        PrintWriter pr=new PrintWriter(socket.getOutputStream());
        BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Scanner sc=new Scanner(System.in);
        int number1,number2;
        
        while(true){
            System.out.print("Enter First Number : ");
            number1=sc.nextInt();
            pr.println(number1);
            System.out.print("Enter Second Number : ");
            number2=sc.nextInt();
            pr.println(number2);
            pr.flush();
            System.out.println(br.readLine());
        }
    }
}