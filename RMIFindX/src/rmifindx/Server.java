/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmifindx;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author TechnoBoy
 */
public class Server {
    public static void main(String[] args) throws RemoteException {
        Registry reg = LocateRegistry.createRegistry(5000);
        reg.rebind("findx", new findximpl());
        System.out.println("Server Ready!!!");
    }
}
