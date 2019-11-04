/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmidatetime;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author TechnoBoy
 */
public interface date extends Remote{
    public String getDate() throws RemoteException;
}
