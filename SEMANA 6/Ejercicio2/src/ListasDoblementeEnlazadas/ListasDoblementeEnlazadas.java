
package ListasDoblementeEnlazadas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author Asus
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
    
    public void insertaAlInicio(int valor){
        Nodo nuevo = new Nodo(valor);
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
    
    public void insertaAlFinal(int valor){
        Nodo nuevo = new Nodo(valor);
        if(primero == null){
            nuevo.setSgte(null);
            nuevo.setAnt(null);
            primero = nuevo;
            ultimo = nuevo;
        }
        else{
            nuevo.setSgte(null);
            nuevo.setAnt(ultimo);
            ultimo.setSgte(nuevo);
            ultimo = nuevo;
        }
    }
    
    public void mostrarHaciaAdelante(DefaultListModel modelo){
        Nodo p = primero;
        modelo.removeAllElements();
        while(p!=null){
            modelo.addElement(p.getInfo());
            p = p.getSgte();
        }
    }
    
    public void ordenar(){
        Nodo p,q;
        int aux;
        p=primero;
        while(p.getSgte()!=null){
            q=p.getSgte();
            while(q!=null){
                if(p.getInfo()>q.getInfo()){
                    aux = p.getInfo();
                    p.setInfo(q.getInfo());
                    q.setInfo(aux);
                }
                q=q.getSgte();
            }
            p = p.getSgte();
        }
    }
    
    public int contar(){
        int c = 0;
        Nodo p = primero;
        while(p!=null){
            c++;
            p = p.getSgte();
        }
        return c;
    }
    
    public int mediana(){
        Nodo p = primero;
        int totalElementos = contar();
        int c=0,med=0;
        
        while(p!=null){
            if(totalElementos%2 != 0){
                if(totalElementos/2 == c){
                    med = p.getInfo();
                    break;
                }                   
            }
            else{
                if(totalElementos/2 == c){
                    med = (p.getInfo()+p.getAnt().getInfo())/2;
                    break;
                }     
            }
            p = p.getSgte();
            c++;
        }
        return med;
    }
    
    private double media() {
        Nodo p = primero;
        int totalElementos = contar();
        int suma = 0;

        while (p != null) {
            suma += p.getInfo();
            p = p.getSgte();
    }

    return (double) suma / totalElementos;
    }
    
    public double desviacionEstandar(){
        double media = media();
        Nodo p = primero;
        int totalElementos = contar();        
        double diferenciaCuadrado = 0;
        
        while(p!=null){
            double diferencia = p.getInfo() - media;
            diferenciaCuadrado = diferenciaCuadrado + (diferencia * diferencia);
            p = p.getSgte();
        }
        
        double varianza = diferenciaCuadrado / totalElementos;
        double desviacionEstandar = Math.sqrt(varianza);
                
        return desviacionEstandar;
    } 
    
    public List<Integer> primos() {
        Nodo p = primero;

        List<Integer> primoss = new ArrayList<>();

        while (p != null) {
            if (p.getInfo() >= 2) {
                for (int c = 2; p.getInfo() >= c; c++) {
                    if (p.getInfo() == c) {
                        primoss.add(p.getInfo());
                        break;
                    } else if (p.getInfo() % c == 0) {
                        break;
                    }
                }
            }
            p = p.getSgte();
        }
        return primoss;
    }
    
    public int menor(){
        Nodo p,q;
        int aux,menor=0;
        p=primero;
        while(p.getSgte()!=null){
            q=p.getSgte();
            while(q!=null){
                if(p.getInfo()>q.getInfo()){
                    menor = q.getInfo();
                }
                q=q.getSgte();
            }
            p = p.getSgte();
        }
        return menor;
    }
}
//primoss.add(p.getInfo());