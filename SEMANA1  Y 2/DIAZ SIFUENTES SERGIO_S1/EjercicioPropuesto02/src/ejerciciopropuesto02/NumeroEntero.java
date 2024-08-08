/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciopropuesto02;

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
    
    private int conteo(int n){
        if(n<10)
            return 1;
        else
            return 1 + conteo(n/10);
    }
    
    public int conteo(){
        return conteo(numero);
    }
    
}
