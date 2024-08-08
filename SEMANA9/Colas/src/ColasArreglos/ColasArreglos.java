/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColasArreglos;

import javax.swing.DefaultListModel;

/**
 *
 * @author Asus
 */
public class ColasArreglos {
    private int cola[];
    private int inicio;
    private int fin;
    private int totalElementos;
    private static final int MAX = 50;
    
    public ColasArreglos(){
        this.cola = new int[MAX];
        this.inicio = 0;
        this.fin = -1;
        this.totalElementos = 0;
    }

    public boolean isEmpty(){
        return totalElementos==0;
    }
    
    public void encolar(int valor){        
        if(totalElementos == MAX){
            return;
        }        
        fin = (fin+1)%MAX;
        cola[fin] = valor;
        totalElementos++;
    }
    
    public int desencolar(){
        if(isEmpty()) return -1;
        int x = cola[inicio];
        inicio = (inicio +1)% MAX;
        totalElementos--;
        return x;
    }
    
    public int frente(){
        return cola[inicio];
    }
    
    public void clear(){
        totalElementos = 0;
        inicio=0;
        fin=-1;
    }
    
    public void mostrar(DefaultListModel modelo) {
        int i;
        modelo.removeAllElements();

        for (i = inicio; i <= fin; i++) {
            modelo.addElement(cola[i]);
        }
    }
}
