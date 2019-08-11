package com.Chavez;

import com.Chavez.excepcion.ErrorValidacion;

public class Turistas {

    public String nombre;
    public String telefono;
    public int contador = 1;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws ErrorValidacion {
        if (nombre.length() > 50){
            throw new ErrorValidacion("El nombre sobrepasa el limite de caracteres");
        }
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) throws ErrorValidacion{
        if (!telefono.matches("^[0-9]{4}\\-[0-9]{4}")) {
            throw new ErrorValidacion("El numero de telefono es invalido");
        }
        this.telefono = telefono;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador += contador;
    }
}
