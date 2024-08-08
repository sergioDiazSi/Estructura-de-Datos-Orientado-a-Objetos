/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciopropuesto08;

/**
 *
 * @author Asus
 */
public class Perimetro {
    private double lado;

    public Perimetro(double lado) {
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }
    
    private double suma(double l, int n){
        if(n==0)
            return 0;
        else
            return 4*l + suma(l*(Math.sqrt(2)/2),n-1);
    }
    public double suma(int n){
        return suma(lado,n);
    }

}
