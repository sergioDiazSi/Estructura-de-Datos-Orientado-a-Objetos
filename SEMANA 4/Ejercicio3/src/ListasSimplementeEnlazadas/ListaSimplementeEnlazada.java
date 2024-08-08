/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListasSimplementeEnlazadas;

import java.util.ArrayList;
import java.util.List;
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
    
    public void insertaAlInicio(Carreras carrera){
        Nodo nuevo = new Nodo(carrera);
        nuevo.setSgte(L);
        L = nuevo;
    }
    
    public void mostrar(DefaultTableModel modelo) {
        modelo.setRowCount(0);

        Object[] titulos = {"Carrera", "Codigo","Nombre","Ciclo","Creditos"};
        
        modelo.setColumnIdentifiers(titulos);
        Nodo p = L;

        while (p != null) {
            Object[] datos = {p.getInfo().getCarrera(), p.getInfo().getCodigo(),p.getInfo().getNombre(),
                p.getInfo().getCiclo(),p.getInfo().getCreditos()};
            modelo.addRow(datos);
            
            p = p.getSgte();
        }
        
    }
    
    public Nodo buscar(String dato){
        Nodo p=L;
        while(p!=null){
            if(p.getInfo().getCodigo().equals(dato)){
                return p;
            }
            p = p.getSgte();
        }
        return null;
    }
    
    public boolean eliminar(String dato){
        if(L.getInfo().getCodigo().equals(dato)){
            L = L.getSgte();
            return true;
        }
        else{
            Nodo ant, p;
            ant = L;
            p = L.getSgte();
            while(p!=null && !p.getInfo().getCodigo().equals(dato)){
                ant = p;
                p = p.getSgte();
            }
            if(p!=null){
                ant.setSgte(p.getSgte());
                return true;
            }
            else return false;
        }
    }
    
    public void ordenamiento() {
        Nodo p, q;
        Carreras aux;
        p = L;
        while (p.getSgte() != null) {
            q = p.getSgte();
            while (q != null) {
                if (p.getInfo().getNombre().compareTo(q.getInfo().getNombre()) > 0) {
                    aux = p.getInfo();
                    p.setInfo(q.getInfo());
                    q.setInfo(aux);
                }
                q = q.getSgte();
            }
            p = p.getSgte();
        }
    }
    
    public List<String> buscarCarrera(String dato){
        Nodo p=L;
        List<String> cursos = new ArrayList<>();
        while(p!=null){
            if(p.getInfo().getCarrera().equals(dato)){
                cursos.add(p.getInfo().getNombre());
            }
            p = p.getSgte();
        }
        return cursos;
    }
}
