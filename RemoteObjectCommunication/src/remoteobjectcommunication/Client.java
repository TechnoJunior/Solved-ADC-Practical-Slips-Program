/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remoteobjectcommunication;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TechnoBoy
 */
public class Client {
    public static void main(String[] args) {
        try {
            showData showdata=(showData)Naming.lookup("rmi://localhost:5000/data");
            List<Students> list=showdata.getDetails();
            System.out.println("Id --> Name --> Address");
            for(Students s:list){
                System.out.println(s.getId()+" --> "+s.getName()+" --> "+s.getAddress());
            }
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
