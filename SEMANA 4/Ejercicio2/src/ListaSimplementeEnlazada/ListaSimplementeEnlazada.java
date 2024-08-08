/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListaSimplementeEnlazada;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class ListaSimplementeEnlazada {
    private Nodo L;
    
    public ListaSimplementeEnlazada(){
        L = null;
    }
    
    public boolean esVacia(){
        return L == null;
    }
    
    public Nodo getL() {
        return L;
    }
    
    public void insertaAlInicio(Pelicula pelicula){
        Nodo nuevo = new Nodo(pelicula);
        nuevo.setSgte(L);
        L = nuevo;
    }
    
    public void mostrar(DefaultTableModel modelo) {
        modelo.setRowCount(0);

        Object[] titulos = {"Titulo", "Duración"};
        
        modelo.setColumnIdentifiers(titulos);
        Nodo p = L;

        while (p != null) {
            Object[] datos = {p.getInfo().getTitulo(), p.getInfo().getHoras()+ ":" 
            + p.getInfo().getMinutos() + ":" + p.getInfo().getSegundos()};
            modelo.addRow(datos);
            
            p = p.getSgte();
        }
        
    }
    
    public void ordenamiento(){
        Nodo p,q;
        Pelicula aux;
        p = L;        
        while(p.getSgte()!=null){
            q=p.getSgte();
            while(q!=null){
                if (p.getInfo().getHoras() > q.getInfo().getHoras() ||
               (p.getInfo().getHoras() == q.getInfo().getHoras() && p.getInfo().getMinutos() > q.getInfo().getMinutos()) ||
               (p.getInfo().getHoras() == q.getInfo().getHoras() && p.getInfo().getMinutos() == q.getInfo().getMinutos() &&
                p.getInfo().getSegundos() > q.getInfo().getSegundos())) {

                aux = p.getInfo();
                p.setInfo(q.getInfo());
                q.setInfo(aux);
            }
                q = q.getSgte();
            }
            p=p.getSgte();
        }
    }
}
