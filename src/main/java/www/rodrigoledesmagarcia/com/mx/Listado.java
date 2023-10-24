package www.rodrigoledesmagarcia.com.mx;

import www.rodrigoledesmagarcia.com.mx.personas.LogoListado;
import www.rodrigoledesmagarcia.com.mx.personas.Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Listado {
    public static void main(String[] args) {

        LogoListado logo = new LogoListado();

        System.out.println(" ");
        System.out.println(logo.verLogo());

        Scanner input = new Scanner(System.in);

        List<Persona> personas = new ArrayList<>();

        var salir = false;

        while (!salir) {
            mostrarMenu();
            try {
                salir = ejecutarOperacion(input, personas);
            }catch (Exception e){
                System.out.println("Error "+e.getMessage());
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println(" ");
        System.out.println("Precione 1 para agregar personas a la lista.");
        System.out.println("Precione 2 para ver el listado de personas");
        System.out.println("Precione 3 para salir");
        System.out.print  ("Propocionar opcion?: ");
    }

    private static boolean ejecutarOperacion(Scanner input, List<Persona> personas) {
        int opcion = Integer.parseInt(input.nextLine());
        var salir = false;
        System.out.println(" ");

        switch (opcion) {
            case 1 -> {
                System.out.print("Proporciona el nombre: ");
                var nombre = input.nextLine();
                System.out.print("Proporciona el telefono: ");
                var telefono = input.nextLine();
                System.out.print("Proporciona el email: ");
                var email = input.nextLine();

                var persona = new Persona(nombre, telefono, email);
                personas.add(persona);
                System.out.println(" ");
                System.out.println("La lista tiene: " + personas.size() + " elementos en ella.");
            }
            case 2 -> {
                System.out.println("Listado de Personas");
                personas.forEach(System.out::println);
            }
            case 3 -> {
                System.out.println("Hasta la proxima...");
                salir = true;
                break;
            }
            default -> {
            System.out.println("Ocurrio un error");
            salir = true;
             }
        }// fin del switch

        return salir;
    }
}
