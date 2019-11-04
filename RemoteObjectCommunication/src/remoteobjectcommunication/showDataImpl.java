/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remoteobjectcommunication;

import java.beans.Statement;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TechnoBoy
 */
public class showDataImpl extends UnicastRemoteObject implements showData{

    List<Students> list;
    
    public showDataImpl() throws RemoteException {
        
    }

    @Override
    public List<Students> getDetails() throws RemoteException {
        try {
            list=new ArrayList<>();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","");
            java.sql.Statement st=con.createStatement();
            String Query="Select * from details";
            try{
                ResultSet rs=st.executeQuery(Query);
                while(rs.next()){
                    Students students =new Students();
                    students.setId(rs.getInt("Id"));
                    students.setName(rs.getString("Name"));
                    students.setAddress(rs.getString("Address"));
                    list.add(students);
                }
            }
            catch(Exception e){
                System.out.println(e);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(showDataImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
}
