/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmidatetime;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author TechnoBoy
 */
public class timeImpl extends UnicastRemoteObject implements time{

    public timeImpl() throws RemoteException {
    }

    @Override
    public String getTime() throws RemoteException {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date=new Date();
        return "Time : "+dateFormat.format(date);
    }
    
}
