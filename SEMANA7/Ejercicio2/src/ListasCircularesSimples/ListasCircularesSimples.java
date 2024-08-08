/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListasCircularesSimples;

import javax.swing.DefaultListModel;

/**
 *
 * @author Asus
 */
public class ListasCircularesSimples {
    private Nodo u;
    
    public ListasCircularesSimples(){
        u = null;
    }
    
    public boolean esVacia(){
        return u == null;
    }
    
    public Nodo getU() {
        return u;
    }
    
    public void insertar(String nombre){
        Nodo nuevo = new Nodo(nombre);
        if(u==null){
            u=nuevo;
            nuevo.setSgte(u);
        }
        else{
            nuevo.setSgte(u.getSgte());
            u.setSgte(nuevo);
            u=nuevo;
        }
    }
    public void mostrarHaciaAdelante(DefaultListModel modelo) {
    if (!esVacia()) {
        Nodo p = u.getSgte();
        modelo.removeAllElements();
        do {
            modelo.addElement(p.getInfo());
            p = p.getSgte();
        } while (p != u.getSgte());
    }
    else if(u==null){
        modelo.removeAllElements();
    }
    }
    
    //INGENIERO A CONTINUACION HAY 2 METODOS JUEGO RESCATE, AMBOS SON LO MISMO PERO UNO SE PRUEBA EN EL MAIN, Y OTRO EN UN FRAME.
    
    
    public void juegoRescatePruebaMain(int n, String nombre) {
        int c;
        Nodo p = u.getSgte();
        Nodo q = p;

        do {
            while (!p.getInfo().equals(nombre)) {
                p = p.getSgte();
                q = p;
            }
            c = 1;
            Nodo ant = u;
            while (c <= n) {
                if (c == n) {
                    if (q == u) {
                        if(c==1 && n==1){
                            while(ant.getSgte()!=u){
                                ant = ant.getSgte();
                            }
                        }
                        ant.setSgte(q.getSgte());
                        u = ant;
                        System.out.println("Eliminado: " + q.getInfo());
                    } else {
                        if(c==1 && n==1){
                            while(ant.getSgte()!=q){
                                ant = ant.getSgte();
                            }
                        }
                        ant.setSgte(q.getSgte());
                        System.out.println("Eliminado: " + q.getInfo());
                    }

                } else {
                    ant = q;
                    q = q.getSgte();
                }
                c++;
            }
            q = ant.getSgte();
        } while (u != u.getSgte());

        System.out.println("La persona que escapa: " + u.getInfo());
    }
        
    public ListasCircularesSimples juegoRescate(int n, String nombre) {
        int c;
        Nodo p = u.getSgte();
        Nodo q = p;
        ListasCircularesSimples eliminacion = new ListasCircularesSimples();
        do {
            while (!p.getInfo().equals(nombre)) {
                p = p.getSgte();
                q = p;
            }
            c = 1;
            Nodo ant = u;
            while (c <= n) {
                if (c == n) {
                    if (q == u) {
                        if(c==1 && n==1){
                            while(ant.getSgte()!=u){
                                ant = ant.getSgte();
                            }
                        }
                        ant.setSgte(q.getSgte());
                        u = ant;
                        eliminacion.insertar(q.getInfo());
                    } else {
                        if(c==1 && n==1){
                            while(ant.getSgte()!=q){
                                ant = ant.getSgte();
                            }
                        }
                        ant.setSgte(q.getSgte());
                        eliminacion.insertar(q.getInfo());
                    }

                } else {
                    ant = q;
                    q = q.getSgte();
                }
                c++;
            }
            q = ant.getSgte();
        } while (u != u.getSgte());

        eliminacion.insertar(u.getInfo());
        
        return eliminacion;
    }
}
