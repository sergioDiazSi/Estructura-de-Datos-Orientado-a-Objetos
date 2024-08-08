/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListasCircularesDobles;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class ListasCircularesDobles {

    protected Nodo u;

    public ListasCircularesDobles() {
        u = null;
    }

    public Nodo getUltimo() {
        return u;
    }

    public void setUltimo(Nodo u) {
        this.u = u;
    }

    public boolean esVacia() {
        return u == null;
    }

    public Nodo getU() {
        return u;
    }

    public void insertarAlFinal(Alumno alumno) {
        Nodo nuevo = new Nodo(alumno);
        if (u == null) {
            u = nuevo;
            nuevo.setSgte(nuevo);
            nuevo.setAnt(nuevo);
        } else {
            nuevo.setAnt(u);
            nuevo.setSgte(u.getSgte());
            u.getSgte().setAnt(nuevo);
            u.setSgte(nuevo);
            u = nuevo;
        }
    }

    public void insertarAlInicio(Alumno alumno) {
        Nodo nuevo = new Nodo(alumno);
        if (u == null) {
            u = nuevo;
            nuevo.setSgte(nuevo);
            nuevo.setAnt(nuevo);
        } else {
            Nodo primerNodo = u.getSgte();
            nuevo.setAnt(u);
            nuevo.setSgte(primerNodo);
            primerNodo.setAnt(nuevo);
            u.setSgte(nuevo);
        }
    }

    public Nodo buscar(String codigo) {
        Nodo p = u.getSgte();

        if (esVacia()) {
            return null;
        } else {
            do {
                if (p.getInfo().getCodigo().equals(codigo)) {
                    return p;
                }
                p = p.getSgte();
            } while (p != u.getSgte());
        }
        return null;
    }

    public void mostrar(DefaultTableModel modelo) {
        modelo.setRowCount(0);

        Object[] titulos = {"Código", "Nombres", "Apellidos", "Correo", "Nota"};

        modelo.setColumnIdentifiers(titulos);
        Nodo p = u.getSgte();

        do {
            Object[] datos = {p.getInfo().getCodigo(), p.getInfo().getNombre(),
                p.getInfo().getApellidos(), p.getInfo().getCorreo(), p.getInfo().getNotas()};
            modelo.addRow(datos);

            p = p.getSgte();
        } while (p != u.getSgte());
    }

    public int contar() {
        Nodo p = u.getSgte();
        int c = 0;
        do {
            c++;
            p = p.getSgte();
        } while (p != u.getSgte());

        return c;
    }

    public boolean eliminar(String codigo) {
        Nodo p = u.getSgte();
        int c = contar();

        if (esVacia()) {
            return false;
        } else {
            if (c == 1 && u.getInfo().getCodigo().equals(codigo)) {
                u = null;
                return true;
            } else {
                do {
                    if (p.getInfo().getCodigo().equals(codigo)) {
                        if (p == u) {
                            p.getAnt().setSgte(p.getSgte());
                            p.getSgte().setAnt(p.getAnt());
                            u = p.getAnt();
                        } else {
                            p.getAnt().setSgte(p.getSgte());
                            p.getSgte().setAnt(p.getAnt());
                        }
                        return true;
                    } else {
                        p = p.getSgte();
                    }
                } while (p != u.getSgte());
            }
        }
        return false;
    }
    
    public ListasCircularesDobles aprobados() {
    ListasCircularesDobles a = new ListasCircularesDobles();
    
    if (u != null) {
        Nodo p = u.getSgte();
        
        do {
            if (p.getInfo().getNotas() >= 14) {
                a.insertarAlInicio(p.getInfo());
            }
            p = p.getSgte();
        } while (p != u.getSgte());
    }
    
    return a;
}

public ListasCircularesDobles desaprobados() {
    ListasCircularesDobles d = new ListasCircularesDobles();
    
    if (u != null) {
        Nodo p = u.getSgte();
        
        do {
            if (p.getInfo().getNotas() < 14) {
                d.insertarAlInicio(p.getInfo());
            }
            p = p.getSgte();
        } while (p != u.getSgte());
    }
    
    return d;
}

}


