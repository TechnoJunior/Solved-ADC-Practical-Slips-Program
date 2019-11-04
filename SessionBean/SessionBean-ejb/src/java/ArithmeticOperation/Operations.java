/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArithmeticOperation;

import javax.ejb.Stateless;

/**
 *
 * @author TechnoBoy
 */
@Stateless
public class Operations implements OperationsLocal {

    @Override
    public int Addition(int a, int b) {
        return a+b;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public int Multiplication(int a, int b) {
        return a*b;
    }

    @Override
    public int Division(int a, int b) {
        return a/b;
    }

    @Override
    public int Substraction(int a, int b) {
        return a-b;
    }
}
