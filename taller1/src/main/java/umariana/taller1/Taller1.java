package umariana.taller1;

import Tarea.Tarea;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Taller1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Tarea> misTareas = new ArrayList<>();

        boolean activo = true;
        do {
            System.out.println("---Menu de opciones---------");
            System.out.println("---1.Agregar tarea----------");
            System.out.println("---2.Mostrar tareas---------");
            System.out.println("---3.Tarea con mayor prioridad");
            System.out.println("---4.Terminar programa-------");
            System.out.println("---Seleccione una opcion----");
            System.out.println("----------------------------");

            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el id de la tarea");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Ingrese la descripcion de la tarea");
                    String descripcion = sc.nextLine();

                    System.out.println("Ingrese la prioridad de 1-5");
                    int prioridad = sc.nextInt();

                    if (prioridad < 1 || prioridad > 5) {
                        System.out.println("La prioridad debe estar en el rango de 1 a 5");
                    } else {
                        Tarea nuevaTarea = new Tarea(id, descripcion, prioridad);
                        misTareas.add(nuevaTarea);
                        System.out.println("Tarea agregada satisfactoriamente ");
                    }
                    break;

                case 2:
                    if (misTareas.isEmpty()) {
                        System.out.println("No hay tareas registradas.");
                    } else {
                        System.out.println("TAREAS REGISTRADAS:");

                        for (Tarea t : misTareas) {
                            System.out.println("id: " + t.getIdTarea());
                            System.out.println("descripcion: " + t.getDescripcion());
                            System.out.println("prioridad: " + t.getPrioridad());
                            System.out.println("--------------------------");
                        }
                    }
                    break;

                case 3:
                    if (misTareas.isEmpty()) {
                        System.out.println("No hay tareas registradas.");
                    } else {
                        // Ordenar las tareas por prioridad
                        Collections.sort(misTareas, Collections.reverseOrder(Comparator.comparingInt(Tarea::getPrioridad)));

                        // Mostrar la tarea con mayor prioridad
                        Tarea tareaPrioritaria = misTareas.get(0);
                        System.out.println("TAREA CON MAYOR PRIORIDAD:");
                        System.out.println("id: " + tareaPrioritaria.getIdTarea());
                        System.out.println("descripcion: " + tareaPrioritaria.getDescripcion());
                        System.out.println("prioridad: " + tareaPrioritaria.getPrioridad());
                    }
                    break;

                case 4:
                    activo = false;
                    System.out.println("Programa Terminado");
                    break;

                default:
                    System.out.println("Opcion no valida");
            }

        } while (activo);
    }
}
