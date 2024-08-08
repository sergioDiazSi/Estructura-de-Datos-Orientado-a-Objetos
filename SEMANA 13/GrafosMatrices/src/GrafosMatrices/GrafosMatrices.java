/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GrafosMatrices;

import javax.swing.DefaultListModel;

/**
 *
 * @author Asus
 */
public class GrafosMatrices {
    private int numVertices;
    private int matriz[][];
    private boolean visitadoAnchura[];
    private boolean visitadoProfundidad[];
    public Pila pila;
    public Cola cola;
    
    public GrafosMatrices(int n){
        numVertices = n;
        matriz = new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j = 1;j<=n;j++){
                matriz[i][j] = 0;
            }
        }
        visitadoAnchura = new boolean[n+1];
        visitadoProfundidad = new boolean[n+1];
        pila = new Pila();
        cola = new Cola();
    }
    
    public void insertarArista(int i, int j){
        matriz[i][j] = 1;
    }
    
    public void eliminarArista(int i, int j){
        matriz[i][j] = 0;
    }
    
    public int gradoEntrada(int v) {
        int entrada = 0;
        for (int i = 1; i <= numVertices; i++) {
            if (matriz[i][v] == 1) {
                entrada++;
            }
        }
        return entrada;
    }
    
    public int gradoSalida(int v) {
        int salida = 0;
        for (int j = 1; j <= numVertices; j++) {
            if (matriz[v][j] == 1) {
                salida++;
            }
        }
        return salida;
    }
    
    public String mostrarAdyacentes(int v){
        String cadena = " ";
        for (int j = 1; j <= numVertices; j++) {
            if (matriz[v][j] == 1) {
                cadena = cadena + ", " + j;
            }
        }
        return cadena;
    }
    
    
    public boolean esDirigido(){
        for (int i=1;i<=numVertices;i++){
            for (int j=1;j<=numVertices;j++){
                if(matriz[i][j]!=matriz[j][i]){              
                    return true;
                } 
            }
        }   
        return false;
    }

    
    public int gradoNoDirigidos(int v){
        int g=0;
        for (int j=1;j<=numVertices;j++){
            if(matriz[v][j]==matriz[j][v]){
                g++;
            } 
        }
        return g;    
    }

    
    public void recorridoAnchura(int v, DefaultListModel modelo) {
        modelo.clear();
        cola.encolar(v);
        visitadoAnchura[v] = true;

        while (!cola.isEmpty()) {
            int frente = cola.desencolar();
            modelo.addElement(frente);
            for (int j = 1; j <= numVertices; j++) {
                if (matriz[frente][j] == 1 && !visitadoAnchura[j]) {
                    visitadoAnchura[j] = true;
                    cola.encolar(j);
                }
            }
        }
    }
    
    public void recorridoProfundidad(int v, DefaultListModel modelo){
        modelo.clear();
        pila.push(v);
        visitadoProfundidad[v] = true;
        while (!pila.isEmpty()) {
            int el = pila.pop();
            modelo.addElement(el);
            for (int j = 1; j <= numVertices; j++) {
                if (matriz[el][j] == 1 && !visitadoProfundidad[j]) {
                    visitadoProfundidad[j] = true;
                    pila.push(j);
                }
            }
        }
    }
}
