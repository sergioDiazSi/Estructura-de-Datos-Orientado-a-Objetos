/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArbolBinario;

import javax.swing.DefaultListModel;

/**
 *
 * @author Asus
 * @param <T>
 */
public class ArbolBinario {

    private Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    public ArbolBinario(Nodo raiz) {
        this.raiz = raiz;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public boolean isEmpty() {
        return raiz == null;
    }


    public void insertar(int valor) {
        raiz = insertar(raiz, valor);
    }

    private Nodo insertar(Nodo r, int valor) {
        if (r == null) {
            r = new Nodo(valor);
        }

        if (valor < r.getInfo()) {
            r.setIzquierdo(insertar(r.getIzquierdo(), valor));
        } else if (valor > r.getInfo()) {
            r.setDerecho(insertar(r.getDerecho(), valor));
        }

        return r;
    }

    public Nodo buscar(Nodo r, int valor) {
        if (r != null) {
            if (valor == r.getInfo()) {
                return r;
            } else {
                if (valor < r.getInfo()) {
                    return buscar(r.getIzquierdo(), valor);
                } else {
                    return buscar(r.getDerecho(), valor);
                }
            }
        } else {
            return null;
        }
    }

    public Nodo buscar(int valor) {
        return buscar(raiz, valor);
    }

    private void preOrden(Nodo r, DefaultListModel modelo) {
        if (r != null) {
            modelo.addElement(r.getInfo());
            preOrden(r.getIzquierdo(), modelo);
            preOrden(r.getDerecho(), modelo);
        }
    }
    
    public void preOrden(DefaultListModel modelo){
        modelo.removeAllElements();
        preOrden(raiz,modelo);
    }
    
    private void enOrden(Nodo r, DefaultListModel modelo) {
        if (r != null) {
            enOrden(r.getIzquierdo(), modelo);
            modelo.addElement(r.getInfo());            
            enOrden(r.getDerecho(), modelo);
        }
    }
    
    public void enOrden(DefaultListModel modelo){
        modelo.removeAllElements();
        enOrden(raiz,modelo);
    }
    
    private void postOrden(Nodo r, DefaultListModel modelo) {
        if (r != null) {
            postOrden(r.getIzquierdo(), modelo);
            postOrden(r.getDerecho(), modelo);            
            modelo.addElement(r.getInfo());            
        }
    }
    
    public void postOrden(DefaultListModel modelo){
        modelo.removeAllElements();
        postOrden(raiz,modelo);
    }
    
    private int buscarMax(Nodo r){
        if(r.getDerecho()==null)
            return r.getInfo();
        else 
            return buscarMax(r.getDerecho());
    }
    
    public int buscarMax(){
        return buscarMax(raiz);
    }
    private int buscarMin(Nodo r){
        if(r.getIzquierdo()==null)
            return r.getInfo();
        else 
            return buscarMax(r.getIzquierdo());
    }
    
    public int buscarMin(){
        return buscarMin(raiz);
    }
    
    public int contar(Nodo r){
        if(r==null) return 0;
        else return 1 + contar(r.getIzquierdo())+contar(r.getDerecho());
    }
    
    public int contar(){
        return contar(raiz);
    }
    
    private Nodo eliminaMin(Nodo r){
        if(r.getIzquierdo()==null)
            r=r.getDerecho();
        else
            r.setIzquierdo(eliminaMin(r.getIzquierdo()));        
        return r;
    }
    
    public void eliminaMin(){
        raiz = eliminaMin(raiz);
    }
    
    private Nodo eliminar(Nodo r, int valor){
        if(r!=null){
            if(valor < r.getInfo())
                r.setIzquierdo(eliminar(r.getIzquierdo(),valor));
            else if(valor > r.getInfo())
                r.setDerecho(eliminar(r.getDerecho(),valor));
            else{ //si solo tiene un hijo o es hoja
              if(r.getIzquierdo()==null)
                  r = r.getDerecho();
              else if (r.getDerecho()== null)
                  r = r.getIzquierdo();
              else{
                  r.setInfo(buscarMin(r.getDerecho()));
                  r.setDerecho(eliminaMin(r.getDerecho()));
              }
            }
        }
        return r;
    }
    
    public void eliminar(int x){
        raiz = eliminar(raiz,x);
    }
    
    private int alturaArbol(Nodo r){
        int alturaIzquierda, alturaDerecha;
        if(r == null) return -1;
        else{
            alturaIzquierda = 1 + alturaArbol(r.getIzquierdo());
            alturaDerecha = 1 + alturaArbol(r.getDerecho());
        }
        
        if(alturaIzquierda>alturaDerecha) return alturaIzquierda;
        else return alturaDerecha;
    }
    
    public int alturaArbol(){
       return alturaArbol(raiz); 
    }
    
    public int sumar(Nodo r){
        if(r==null) return 0;
        else return r.getInfo() + sumar(r.getIzquierdo())+sumar(r.getDerecho());
    }
    
    public int sumar(){
        return sumar(raiz);
    }
    
    public int contarHojas(Nodo r) {
        if (r == null) {
            return 0;
        }
        if (r.getIzquierdo() == null && r.getDerecho() == null) {
            return 1;
        }
        return contarHojas(r.getIzquierdo()) + contarHojas(r.getDerecho());
    }

    public int contarHojas() {
        return contarHojas(raiz);
    }
    
    private int profundidad(Nodo r, Nodo n){
        int pi, pd;
        if(r == null || n == null) return -1;
        if(r==n) return 0;
        else{
            pi = 1 + profundidad(r.getIzquierdo(),n);
            pd = 1 + profundidad(r.getDerecho(),n);
        }
        
        if(pi>pd) return pi;
        else return pd;
    }
    
    public int profundidad(Nodo n){
       return profundidad(raiz,n); 
    }
    
    public String resultados(){
        return "El mayor es: " + buscarMax()+ "\n" + 
               "\nEl menor es: " + buscarMin() + "\n" + 
               "\nNumero de nodos: " + contar() + "\n" + 
               "\nAltura del arbol: " + alturaArbol() +
               "\nSuma total: " + sumar() + 
               "\nConteo de hojas: " + contarHojas()
               ;
    }
    

}
