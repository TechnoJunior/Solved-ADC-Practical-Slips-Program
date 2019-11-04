/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi_find_x_y_n;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author TechnoBoy
 */
public class findImpl extends UnicastRemoteObject implements find{

    public findImpl() throws RemoteException {
    }

    @Override
    public String findx(double y, double n) throws RemoteException {
        return "X = "+Math.pow(y, n);
    }
    
}
