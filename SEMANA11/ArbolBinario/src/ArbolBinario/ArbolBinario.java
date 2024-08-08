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
public class ArbolBinario<T extends Comparable<T>> {

    private Nodo<T> raiz;

    public ArbolBinario() {
        raiz = null;
    }

    public ArbolBinario(Nodo<T> raiz) {
        this.raiz = raiz;
    }

    public Nodo<T> getRaiz() {
        return raiz;
    }

    public boolean isEmpty() {
        return raiz == null;
    }

    public boolean esRaiz(Nodo<T> nodo) {
        return raiz == nodo;
    }

    public boolean esHoja(Nodo<T> nodo) {
        return nodo.getIzquierdo() == null && nodo.getDerecho() == null;
    }

    public boolean esInterno(Nodo<T> nodo) {
        return !esHoja(nodo);
    }

    public void insertar(T valor) {
        raiz = insertar(raiz, valor);
    }

    private Nodo<T> insertar(Nodo<T> r, T valor) {
        if (r == null) {
            r = new Nodo<>(valor);
        }

        if (valor.compareTo(r.getInfo()) < 0) {
            r.setIzquierdo(insertar(r.getIzquierdo(), valor));
        } else if (valor.compareTo(r.getInfo()) > 0) {
            r.setDerecho(insertar(r.getDerecho(), valor));
        }

        return r;
    }

    public Nodo<T> buscar(Nodo<T> r, T valor) {
        if (r != null) {
            if (valor == r.getInfo()) {
                return r;
            } else {
                if (valor.compareTo(r.getInfo()) < 0) {
                    return buscar(r.getIzquierdo(), valor);
                } else {
                    return buscar(r.getDerecho(), valor);
                }
            }
        } else {
            return null;
        }
    }

    public Nodo<T> buscar(T valor) {
        return buscar(raiz, valor);
    }

    private void preOrden(Nodo<T> r, DefaultListModel modelo) {
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
    
    private void enOrden(Nodo<T> r, DefaultListModel modelo) {
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
    
    private void postOrden(Nodo<T> r, DefaultListModel modelo) {
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
    
    private T buscarMax(Nodo<T> r){
        if(r.getDerecho()==null)
            return r.getInfo();
        else 
            return (T) buscarMax(r.getDerecho());
    }
    
    public T buscarMax(){
        return buscarMax(raiz);
    }
    private T buscarMin(Nodo<T> r){
        if(r.getIzquierdo()==null)
            return r.getInfo();
        else 
            return (T) buscarMax(r.getIzquierdo());
    }
    
    public T buscarMin(){
        return buscarMin(raiz);
    }
    
    public int contar(Nodo<T> r){
        if(r==null) return 0;
        else return 1 + contar(r.getIzquierdo())+contar(r.getDerecho());
    }
    
    public int contar(){
        return contar(raiz);
    }
    
    private Nodo<T> eliminaMin(Nodo<T> r){
        if(r.getIzquierdo()==null)
            r=r.getDerecho();
        else
            r.setIzquierdo(eliminaMin(r.getIzquierdo()));        
        return r;
    }
    
    public void eliminaMin(){
        raiz = eliminaMin(raiz);
    }
    
    private Nodo<T> eliminar(Nodo<T> r, T valor){
        if(r!=null){
            if(valor.compareTo(r.getInfo()) < 0)
                r.setIzquierdo(eliminar(r.getIzquierdo(),valor));
            else if(valor.compareTo(r.getInfo()) > 0)
                r.setDerecho(eliminar(r.getDerecho(),valor));
            else{ //si solo tiene un hijo o es hoja
              if(r.getIzquierdo()==null)
                  r = r.getDerecho();
              else if (r.getDerecho()== null)
                  r = r.getIzquierdo();
              else{
                  r.setInfo((T) buscarMin(r.getDerecho()));
                  r.setDerecho(eliminaMin(r.getDerecho()));
              }
            }
        }
        return r;
    }
    
    public void eliminar(T x){
        raiz = eliminar(raiz,x);
    }
    
    private int alturaArbol(Nodo<T> r){
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
    
    public String resultados(){
        return "El mayor es: " + buscarMax()+ "\n" + 
               "\nEl menor es: " + buscarMin() + "\n" + 
               "\nNumero de nodos: " + contar() + "\n" + 
               "\nAltura del arbol: " + alturaArbol();
    }
    

}
