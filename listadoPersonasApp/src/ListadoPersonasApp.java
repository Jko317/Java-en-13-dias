import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListadoPersonasApp {
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        // Definimos la lista fuera del ciclo while
        List<Persona> personas = new ArrayList<>();
        // Empezamos con el menú
        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            try {
                salir = ejecutarOperacion(consola, personas);
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingresa un número.");
            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            }
            System.out.println();
        }
        consola.close(); // Cerramos el scanner cuando ya no se necesita
    }

    private static void mostrarMenu() {
        // Mostramos las opciones
        System.out.println("""
                **** Listado de Personas App ****
                1. Agregar
                2. Listar
                3. Salir
                """);
        System.out.print("Proporciona una opción: ");
    }

    private static boolean ejecutarOperacion(Scanner consola, List<Persona> personas) {
        int opcion = Integer.parseInt(consola.nextLine());
        boolean salir = false;
        // Revisamos la opción proporcionada
        switch (opcion) {
            case 1: // Agregar persona a la lista
                System.out.print("Proporciona el nombre: ");
                String nombre = consola.nextLine();
                System.out.print("Proporciona el teléfono: ");
                String tel = consola.nextLine();
                System.out.print("Proporciona el email: ");
                String email = consola.nextLine();
                // Crear el objeto Persona
                Persona persona = new Persona(nombre, tel, email);
                // Lo agregamos a la lista
                personas.add(persona);
                System.out.println("La lista tiene: " + personas.size() + " elementos");
                break;
            case 2: // Listar personas
                System.out.println("Listado de Personas:");
                // Mejora usando lambda y método de referencia
                personas.forEach(System.out::println);
                break;
            case 3: // Salimos del ciclo
                System.out.println("Hasta pronto...");
                salir = true;
                break;
            default:
                System.out.println("Opción errónea: " + opcion);
        }
        return salir;
    }
}