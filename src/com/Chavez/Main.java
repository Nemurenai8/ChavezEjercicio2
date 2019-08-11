package com.Chavez;

import com.Chavez.excepcion.ErrorValidacion;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Turistas> turistas = new ArrayList();
        Scanner lector = new Scanner(System.in);

        boolean x = true;
        System.out.println("<><><><> Bienvenido <><><><>");
        while (x == true) {
            System.out.println("1. Ingresar un turista");
            System.out.println("2. Mostrar turistas");
            System.out.println("3. Salir");
            int opcion = LectorDeDatos.solicitarEntero("Ingrese una opcion: ");

            switch (opcion) {
                case 1:
                    int c = 0;
                    System.out.println("<><><> Ingresando un turista <><><>");

                    Turistas nuevoTurista = new Turistas();
                    boolean i = true;
                    while (i == true) {
                        System.out.println("Nombre del turista: ");
                        String nombreTurista = lector.nextLine();
                        System.out.println("Numero telefonico: ");
                        String telefonoTurista = lector.nextLine();
                        try {
                            nuevoTurista.setNombre(nombreTurista);
                            nuevoTurista.setTelefono(telefonoTurista);
                            i = false;
                        } catch (ErrorValidacion errorValidacion) {
                            System.err.println(errorValidacion.getMessage());
                            i = true;
                        }
                            for (Turistas t : turistas) {
                                if (telefonoTurista.equals(t.telefono)) {
                                    t.setContador(1);
                                    c = 1;
                                    break;
                                }
                            }
                    }
                    if (c == 0) {
                        nuevoTurista.setContador(0);
                        turistas.add(nuevoTurista);
                    }
                    break;
                case 2:
                    if (turistas.isEmpty()) {
                        System.out.println("-- No ha ingresado ningun turista --");
                    } else {
                        System.out.println("<><> Mostrando Turistas <><>");
                    }
                    for (Turistas t : turistas){
                        System.out.println(t.getNombre() + " - " + t.getTelefono() + " - Visitas: " + t.getContador());
                    }
                    break;
                case 3:
                    x = false;
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }
    }
}
