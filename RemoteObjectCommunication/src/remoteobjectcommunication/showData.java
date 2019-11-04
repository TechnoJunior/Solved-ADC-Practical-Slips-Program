/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remoteobjectcommunication;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author TechnoBoy
 */
public interface showData extends Remote{
    public List<Students> getDetails() throws RemoteException;
}
