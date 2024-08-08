/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1;

import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sistemas
 */
public class ListasDoblementeEnlazadas {
    protected Nodo primero;
    protected Nodo ultimo;
    
    public ListasDoblementeEnlazadas(){
        primero = null;
        ultimo = null;
    }
    
    public Nodo getPrimero(){
        return primero;
    }
    
    public void setPrimero(Nodo primero){
        this.primero = primero;
    }

    public Nodo getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }
    
    public boolean esVacia(){
        return primero == null && ultimo == null;
    }
    
    public void insertaAlInicio(Empleado empleado){
        Nodo nuevo = new Nodo(empleado);
        if(primero == null){
            nuevo.setSgte(null);
            nuevo.setAnt(null);
            primero = nuevo;
            ultimo = nuevo;
        }
        else{
            nuevo.setSgte(primero);
            nuevo.setAnt(null);
            primero.setAnt(nuevo);
            primero = nuevo;
        }
    }
    
    public Nodo buscar(String dato){
        Nodo p = primero;
        while(p!=null){
            if(p.getInfo().getCodigo().equals(dato))
                return p;
            p=p.getSgte();
        }
        return null;
    }
    
    public boolean eliminar(String dato){
        if(primero.getInfo().getCodigo().equals(dato)){
            if(primero.getSgte()==null){
                primero = null;
                ultimo = null;
            }
            else{
                primero = primero.getSgte();
                primero.setAnt(null);
            }
            return true;
        }
        else{
            Nodo p = primero.getSgte();
            while(p!=null && !p.getInfo().getCodigo().equals(dato))
                p=p.getSgte();
            if(p!=null){
                if(p==ultimo){
                    ultimo = ultimo.getAnt();
                    ultimo.setSgte(null);
                }
                else{
                    p.getAnt().setSgte(p.getSgte());
                    p.getSgte().setAnt(p.getAnt());
                }
                return true;
            }      
            else return false;
        }        
    }
    
    
    public void mostrarHaciaAdelante(DefaultTableModel modelo) {
        modelo.setRowCount(0);

        Object[] titulos = {"Código", "Nombres", "Apellidos", "Sexo", "Sueldo"};
        
        modelo.setColumnIdentifiers(titulos);
        Nodo p = primero;

        while (p != null) {
            Object[] datos = {p.getInfo().getCodigo(), p.getInfo().getNombre(), 
            p.getInfo().getApellidos(), p.getInfo().getSexo(),p.getInfo().getSueldo()};
            modelo.addRow(datos);
            
            p = p.getSgte();
        }
        
    }

    
    public void mostrarHaciaAtras(DefaultTableModel modelo) {
        modelo.setRowCount(0);

        Object[] titulos = {"Código", "Nombres", "Apellidos", "Sexo", "Sueldo"};
        
        modelo.setColumnIdentifiers(titulos);
        Nodo p = ultimo;

        while (p != null) {
            Object[] datos = {p.getInfo().getCodigo(), p.getInfo().getNombre(), 
            p.getInfo().getApellidos(), p.getInfo().getSexo(),p.getInfo().getSueldo()};
            modelo.addRow(datos);
            
            p = p.getAnt();
        }
    }
}
