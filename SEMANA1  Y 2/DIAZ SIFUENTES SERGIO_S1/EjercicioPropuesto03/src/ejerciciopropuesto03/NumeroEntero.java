/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciopropuesto03;

/**
 *
 * @author Asus
 */
public class NumeroEntero {
    
    private int numero;
    
    public NumeroEntero(int numero){
        this.numero=numero;
}

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    private int suma(int n){
        if (n==0)
            return 0;
        else
            return n + suma(n-1);
    }
    
    public int suma(){
        return suma(numero);
    }
}
