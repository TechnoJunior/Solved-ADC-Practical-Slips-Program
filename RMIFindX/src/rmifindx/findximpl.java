/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmifindx;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author TechnoBoy
 */
public class findximpl extends UnicastRemoteObject implements findx{

    public findximpl() throws RemoteException {
    }

    @Override
    public String find(int a,int b,int c) throws RemoteException {
        String data;
        double root1,root2,determinant;
        
        determinant= b * b - 4 * a * c;
        //condifition for real and different roots
        if(determinant>0){
            root1=(-b + Math.sqrt(determinant))/(2 * a);
            root2=(-b - Math.sqrt(determinant))/(2 * a);
        }
        
        //condition for real and equal roots
        else if(determinant==0){
            root1= - b / (2 * a);
            root2=root1;
        }
        //If roots are not real
        else{
            root1= -b / (2 * a);
            root2= Math.sqrt(-determinant) / (2 * a);
        }
        
        data= "Value of A, B, C = "+a+" "+ b+" "+c+"\nx = "+root1+" x = "+root2;
        return data;
    }
    
}
