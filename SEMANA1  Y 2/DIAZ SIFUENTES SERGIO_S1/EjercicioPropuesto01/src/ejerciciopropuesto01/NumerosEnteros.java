/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciopropuesto01;

/**
 *
 * @author Asus
 */
public class NumerosEnteros {
    private int numero;

    public NumerosEnteros(int numero) {
        if (validarNumeroBinario(numero)) {
            this.numero = numero;
        } else {
            throw new IllegalArgumentException("El número proporcionado no es un número binario válido.");
        }
    }

    private boolean validarNumeroBinario(int num) {
        while (num != 0) {
            int digito = num % 10;
            if (digito != 0 && digito != 1) {
                return false; // Hay un dígito no binario
            }
            num /= 10;
        }
        return true; // Todos los dígitos son binarios
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        if (validarNumeroBinario(numero)) {
            this.numero = numero;
        } else {
            throw new IllegalArgumentException("El número proporcionado no es un número binario válido.");
        }
    }

    private int decimal(int n, int base) {
        if (n == 0) {
            return 0;
        } else {
            return (n % 10) * base + decimal(n / 10, base * 2);
        }
    }

    public int decimal() {
        
        return decimal(numero, 1);
    }

}

