/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciopropuesto07;

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
    
    private String digitos(int n){
       if(n<10)
           return "Son iguales";
       else if (n%10==(n/10)%10){
           return digitos(n/10);
       }
       else
           return "No son iguales";
    }
    
    public String digitos(){
        return digitos(numero);
    }
}
