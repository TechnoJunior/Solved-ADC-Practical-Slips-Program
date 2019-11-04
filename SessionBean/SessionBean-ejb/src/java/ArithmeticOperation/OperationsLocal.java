/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArithmeticOperation;

import javax.ejb.Local;

/**
 *
 * @author TechnoBoy
 */
@Local
public interface OperationsLocal {

    int Addition(int a, int b);

    int Multiplication(int a, int b);

    int Division(int a, int b);

    int Substraction(int a, int b);
    
}
