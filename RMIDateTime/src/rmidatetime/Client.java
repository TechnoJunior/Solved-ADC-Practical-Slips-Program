/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmidatetime;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 *
 * @author TechnoBoy
 */
public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        time t=(time)Naming.lookup("rmi://localhost:5000/time");
        date d=(date)Naming.lookup("rmi://localhost:5000/date");
        Scanner sc=new Scanner(System.in);
        String op;
        while(true)
        {
            System.out.println("Enter Operation to Perform (Date,Time)");
            op=sc.next();
            if(op.compareToIgnoreCase("time")==0){
                System.out.println(t.getTime());
            }
            else if (op.compareToIgnoreCase("date")==0){
                System.out.println(d.getDate());
            }
            else{
                System.out.println("Invalid Selection");
            }
        }
    }
}
