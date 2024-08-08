/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio05;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class VectorAlumnos {

    private Alumno vector[];
    private int totalElementos;

    public VectorAlumnos() {
        vector = new Alumno[50];
        totalElementos = 0;
    }

    public VectorAlumnos(int limite) {
        vector = new Alumno[limite];
        totalElementos = 0;
    }

    public void mostrar(DefaultTableModel modelo) {
        Object datos[][] = new Object[totalElementos][2];
        String titulos[] = {"Alumno", "Nota"};
        for (int i = 0; i < totalElementos; i++) {
            datos[i][0] = vector[i].getNombre();
            datos[i][1] = vector[i].getNota();
        }
        modelo.setDataVector(datos, titulos);
    }

    public boolean agregar(Alumno x) {
        if (totalElementos < vector.length) {
            vector[totalElementos] = x;
            totalElementos++;
            return true;
        } else {
            return false;
        }
    }

    private void qsort(Alumno v[], int l, int r) {
        int i = l, j = r;
        Alumno temp, x;
        x = v[(l + r) / 2];
        do {
            while (v[i].getNombre().compareTo(x.getNombre()) < 0 && i < r) {
                i++;
            }
            while (v[j].getNombre().compareTo(x.getNombre()) > 0 && j > l) {
                j--;
            }
            if (i <= j) {
                temp = v[i];
                v[i] = v[j];
                v[j] = temp;
                i++;
                j--;
            }
        } while (i <= j);
        if (i < r) {
            qsort(v, i, r);
        }
        if (l < j) {
            qsort(v, l, j);
        }
    }

    public void qsort() {
        qsort(vector, 0, totalElementos - 1);
    }
    
    private void qsortMerito(Alumno v[], int l, int r) {
        int i = l, j = r;
        Alumno temp, x;
        x = v[(l + r) / 2];
        do {
            while (v[i].getNota()>x.getNota() && i < r) {
                i++;
            }
            while (v[j].getNota()<x.getNota()  && j > l) {
                j--;
            }
            if (i <= j) {
                temp = v[i];
                v[i] = v[j];
                v[j] = temp;
                i++;
                j--;
            }
        } while (i <= j);
        if (i < r) {
            qsortMerito(v, i, r);
        }
        if (l < j) {
            qsortMerito(v, l, j);
        }
    }

    public void qsortMerito() {
        qsortMerito(vector, 0, totalElementos - 1);
    }
}
