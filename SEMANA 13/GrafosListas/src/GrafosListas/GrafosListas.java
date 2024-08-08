/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GrafosListas;

import javax.swing.DefaultListModel;

/**
 *
 * @author Asus
 */
public class GrafosListas {
    private ListasSimplementeEnlazadas listaAdyacencia[];
    private int numVertices;
    public Pila pila;
    public Cola cola;
    private boolean visitadoAnchura[];
    private boolean visitadoProfundidad[];
    
    public GrafosListas(int n) {
        numVertices = n;
        listaAdyacencia = new ListasSimplementeEnlazadas[numVertices + 1];
        for (int i = 1; i <= numVertices; i++) {
            listaAdyacencia[i] = new ListasSimplementeEnlazadas();
        }
        visitadoAnchura = new boolean[n+1];
        visitadoProfundidad = new boolean[n+1];
        pila = new Pila();
        cola = new Cola();
    }
    
    public void insertarArista(int i, int j){
        listaAdyacencia[i].insertaAlFinal(j);
        //listaAdyacencia[j].insertaAlFinal(i);  NO DIRIGIDO
    }
    
    public void eliminarArista(int i, int j){
        listaAdyacencia[i].eliminar(j);
    }

    public int gradoEntrada(int vertice) {
        int gradoE = 0;
        for (ListasSimplementeEnlazadas lista : listaAdyacencia) {
            Nodo p = lista.getL();
            while (p != null) {
                if (p.getInfo() == vertice) {
                    gradoE++;
                }
                p = p.getSgte();
            }
        }
        return gradoE;
    }
    
    public int gradoSalida(int vertice){
        return listaAdyacencia[vertice].contar();
    }
    
    public String mostrarAdyacentes(int vertice){
        ListasSimplementeEnlazadas lista = listaAdyacencia[vertice];
        Nodo p = lista.getL();
        String cadena = " ";
        
        while(p!=null){
            cadena = cadena + " " + p.getInfo();
            p = p.getSgte();
        }
        
        return cadena;
    }
    
    public void recorridoAnchura(int vertice, DefaultListModel modelo) {
        modelo.clear();
        cola.encolar(vertice);
        visitadoAnchura[vertice] = true;
        
        while (!cola.isEmpty()) {
            int actual = cola.desencolar();
            modelo.addElement(actual);
            Nodo p = listaAdyacencia[actual].getL();
            while (p != null) {
                int vecino = p.getInfo();
                if (!visitadoAnchura[vecino]) {
                    visitadoAnchura[vecino] = true;
                    cola.encolar(vecino);
                } 
                p = p.getSgte();
            }
        }
    }
    
    public void recorridoProfundidad(int vertice, DefaultListModel modelo) {
        modelo.clear();        
        pila.push(vertice);
        visitadoProfundidad[vertice] = true;

        while (!pila.isEmpty()) {
            int actual = pila.pop();
            modelo.addElement(actual);
            Nodo p = listaAdyacencia[actual].getL();
            while (p != null) {
                int vecino = p.getInfo();
                if (!visitadoProfundidad[vecino]) {
                    visitadoProfundidad[vecino] = true;
                    pila.push(vecino);
                } 
                p = p.getSgte();
            }
        }
    }
    
    public boolean esDirigido(){
        for (int i = 1; i <= numVertices; i++) {
            Nodo actual = listaAdyacencia[i].getL();
            while (actual != null) {
                int j = actual.getInfo();
                if (listaAdyacencia[i].buscar(j) != null && listaAdyacencia[j].buscar(i) == null) {
                    return true;
                }
                actual = actual.getSgte();
            }
        }
        return false;
    }

}
