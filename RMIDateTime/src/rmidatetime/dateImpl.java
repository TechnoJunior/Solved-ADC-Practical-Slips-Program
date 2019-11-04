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
public class dateImpl extends UnicastRemoteObject implements date{

    public dateImpl() throws RemoteException {
    }

    @Override
    public String getDate() throws RemoteException {
        DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyy");
        Date date=new Date();
        return "Date : "+dateFormat.format(date);
    }
    
}
