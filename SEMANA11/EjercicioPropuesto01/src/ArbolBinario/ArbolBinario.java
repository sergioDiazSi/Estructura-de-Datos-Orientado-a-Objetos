/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArbolBinario;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
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

    public boolean esRaiz(Nodo nodo) {
        return raiz == nodo;
    }

    public boolean esHoja(Nodo nodo) {
        return nodo.getIzquierdo() == null && nodo.getDerecho() == null;
    }

    public boolean esInterno(Nodo nodo) {
        return !esHoja(nodo);
    }

    public void insertar(Cursos valor) {
        raiz = insertar(raiz, valor);
    }

    private Nodo insertar(Nodo r, Cursos valor) {
        if (r == null) {
            r = new Nodo(valor);
        }

        if (valor.getCodigo().compareToIgnoreCase(r.getInfo().getCodigo()) < 0) {
            r.setIzquierdo(insertar(r.getIzquierdo(), valor));
        } else if (valor.getCodigo().compareToIgnoreCase(r.getInfo().getCodigo()) > 0) {
            r.setDerecho(insertar(r.getDerecho(), valor));
        }

        return r;
    }
    
    public Nodo buscar(Nodo r, Cursos valor) {
        if (r != null) {
            if (valor.getCodigo().equalsIgnoreCase(r.getInfo().getCodigo())) {
                return r;
            } else {
                if (valor.getCodigo().compareToIgnoreCase(r.getInfo().getCodigo()) < 0) {
                    return buscar(r.getIzquierdo(), valor);
                } else {
                    return buscar(r.getDerecho(), valor);
                }
            }
        } else {
            return null;
        }
    }

    public Nodo buscar(Cursos valor) {
        return buscar(raiz, valor);
    }
    
    public void agregarFila(DefaultTableModel modelo, Cursos x){
        Object fila[] = {x.getCodigo(),x.getNombre(),x.getCiclo(),
            x.getCreditos(),x.getCarrera()
        };
        modelo.addRow(fila);
    }
    
    public void limpiarTabla(DefaultTableModel modelo){
        int filas = modelo.getRowCount();
        for (int i = 0; i < filas; i++) {
            modelo.removeRow(0);
        }
    }
    
    public void enOrden(DefaultTableModel modelo){
        String titulos[]={"CODIGO","NOMBRE","ICLO","CREDITOS","CARRERA"};
        modelo.setColumnIdentifiers(titulos);
        limpiarTabla(modelo);
        enOrden(raiz,modelo);
    }
    
    private void enOrden(Nodo r, DefaultTableModel modelo){
        if(r!=null){
            enOrden(r.getIzquierdo(),modelo);
            agregarFila(modelo,r.getInfo());
            enOrden(r.getDerecho(),modelo);
        }
    }
    
    public void preOrden(DefaultTableModel modelo){
        String titulos[]={"CODIGO","NOMBRE","ICLO","CREDITOS","CARRERA"};
        modelo.setColumnIdentifiers(titulos);
        limpiarTabla(modelo);
        preOrden(raiz,modelo);
    }
    
    private void preOrden(Nodo r, DefaultTableModel modelo){
        if(r!=null){
            agregarFila(modelo,r.getInfo());
            preOrden(r.getIzquierdo(),modelo);
            preOrden(r.getDerecho(),modelo);
        }
    }
    
    public void postOrden(DefaultTableModel modelo){
        String titulos[]={"CODIGO","NOMBRE","ICLO","CREDITOS","CARRERA"};
        modelo.setColumnIdentifiers(titulos);
        limpiarTabla(modelo);
        postOrden(raiz,modelo);
    }
    
    private void postOrden(Nodo r, DefaultTableModel modelo){
        if(r!=null){            
            postOrden(r.getIzquierdo(),modelo);
            postOrden(r.getDerecho(),modelo);
            agregarFila(modelo,r.getInfo());
        }
    }
    
    public Cursos buscarMax(){
        return buscarMax(raiz);
    }
    
    private Cursos buscarMax(Nodo r){
        Cursos x;
        if(r.getDerecho()==null)
            x = r.getInfo();
        else
            x = buscarMax(r.getDerecho());
        return x;
    }
    
    public Cursos buscarMin(){
        return buscarMin(raiz);
    }
    
    private Cursos buscarMin(Nodo r){
        Cursos x;
        if(r.getIzquierdo()==null)
            x = r.getInfo();
        else
            x = buscarMax(r.getIzquierdo());
        return x;
    }
    
    public int contar(){
        return contar(raiz);
    }
    
    public int contar(Nodo r){
        if(r==null) return 0;
        else return 1 + contar(r.getIzquierdo())+contar(r.getDerecho());
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
    
    public void elimina(Cursos x){
        raiz = elimina(raiz,x);
    }
    
    private Nodo elimina(Nodo r, Cursos x){
        if(r!=null){
            if(x.getCodigo().compareToIgnoreCase(r.getInfo().getCodigo()) < 0)
                r.setIzquierdo(elimina(r.getIzquierdo(),x));
            else if(x.getCodigo().compareToIgnoreCase(r.getInfo().getCodigo()) > 0)
                r.setDerecho(elimina(r.getDerecho(),x));
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
}
