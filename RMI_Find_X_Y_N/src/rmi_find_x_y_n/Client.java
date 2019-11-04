/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi_find_x_y_n;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TechnoBoy
 */
public class Client {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double a,b;
        try {
            find f=(find)Naming.lookup("rmi://localhost:5000/find");
            System.out.println("X=Y^N");
            System.out.print("Enter the Value of Y : ");
            a=sc.nextDouble();
            System.out.print("Enter the Value of N : ");
            b=sc.nextDouble();
            System.out.println(f.findx(a, b));
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
