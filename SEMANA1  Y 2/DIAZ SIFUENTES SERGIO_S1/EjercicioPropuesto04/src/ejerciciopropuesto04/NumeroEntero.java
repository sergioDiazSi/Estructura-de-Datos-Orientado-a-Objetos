/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciopropuesto04;

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
    
    private int sumaPar(int n){
        if (n==0)
            return 0;
        else
            return (2*n) + sumaPar(n-1);
    }
    
    public int sumaPar(){
        return sumaPar(numero);
    }
    
}
