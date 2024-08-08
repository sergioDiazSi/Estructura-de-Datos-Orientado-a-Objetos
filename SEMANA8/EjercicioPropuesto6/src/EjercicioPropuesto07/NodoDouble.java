/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPropuesto07;

/**
 *
 * @author Asus
 */
public class NodoDouble {

    private double info;
    private NodoDouble sgte;

    public NodoDouble() {
    }

    public NodoDouble(double info) {
        this.info = info;
    }

    public NodoDouble(double info, NodoDouble sgte) {
        this.info = info;
        this.sgte = sgte;
    }

    public double getInfo() {
        return info;
    }

    public void setInfo(double info) {
        this.info = info;
    }

    public NodoDouble getSgte() {
        return sgte;
    }

    public void setSgte(NodoDouble sgte) {
        this.sgte = sgte;
    }

}
