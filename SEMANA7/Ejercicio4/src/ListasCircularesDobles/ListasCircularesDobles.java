/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListasCircularesDobles;

import javax.swing.DefaultListModel;

/**
 *
 * @author Asus
 */
public class ListasCircularesDobles {
    protected Nodo u;
    
    public ListasCircularesDobles(){
        u = null;
    }   

    public Nodo getUltimo() {
        return u;
    }

    public void setUltimo(Nodo u) {
        this.u = u;
    }
    
    public boolean esVacia(){
        return  u == null;
    }
    
    public Nodo getU() {
        return u;
    }
    
    public void insertar(String ciudad){
        Nodo nuevo = new Nodo(ciudad);
        if(u == null){
            u=nuevo;
            nuevo.setSgte(nuevo);
            nuevo.setAnt(nuevo);
        }
        else{
            nuevo.setAnt(u);
            nuevo.setSgte(u.getSgte());
            u.getSgte().setAnt(nuevo);
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


    public String obtenerCiudadActual() {
        
        if (u == null || u.getSgte() == null) {
            return null;
        }

        int paisAleatorio = (int) (Math.random() * 14);
        Nodo p = u.getSgte();
        int c = 1;

        while (c != paisAleatorio) {
            p = p.getSgte();
            c++;
        }
        u = p;
        return p.getInfo();
    }

    // LA LOGICA PARA GIRAR A LA DERECHA O A LA IZQUIERDA LA HICE EN EL MISMO FRAME
    //private void btnPunteroActionPerformed(java.awt.event.ActionEvent evt) {                                           
//        btnPuntero.setEnabled(false);
//        LCD.insertar("Quito");
//        LCD.insertar("Leticia");
//        LCD.insertar("Macapá");
//        LCD.insertar("Sao Tomé");
//        LCD.insertar("Libreville");
//        LCD.insertar("Oyo");
//        LCD.insertar("Mbandaka");
//        LCD.insertar("Kampala");
//        LCD.insertar("Nanyuki");
//        LCD.insertar("Bosaso");
//        LCD.insertar("Malé");
//        LCD.insertar("Pontianak");
//        LCD.insertar("Kiritimati");
//        
//        String ciudad = LCD.obtenerCiudadActual();
//        p = LCD.getU();
//        txtCiudades.setText(ciudad);
//    }                                          
//
//    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {                                             
//
//        if (p != null) {
//            p = p.getSgte();
//        }
//        txtCiudades.setText(p.getInfo());
//            
//    }  
//    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {                                         
//        if (p != null) {
//            p = p.getAnt();
//        }
//        txtCiudades.setText(p.getInfo());
//    } 
}
