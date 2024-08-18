import java.util.Scanner;

public class CalculadoraApp{

    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        while (true) {
           System.out.println("****Aplicaion Calculadora****");
            //Mostrar el menu
            mostrarMenu();
            try {
                var operacion = Integer.parseInt(consola.nextLine());
                //Revisar que este dentro de las opciones
                if (operacion >= 1 && operacion <= 4) {
                    //Ejecutamos la operacion deseada
                    ejecutarOperacion (operacion, consola);
                } else if (operacion == 5) { //Salir
                    System.out.println("Hasta pronto... ");
                    break;
                } else {
                    System.out.println("Opcion erronea: " + operacion);
                }
                System.out.println();//Imprimimos un salto de linea antes de repetir el ciclo
                }//fin try
                catch (Exception e) {
                System.out.println("Ocurrio un error: " + e.getMessage());
                System.out.println();
            }//fin while
        }//Fin while
    }//Fin de main
    private static void mostrarMenu(){
        System.out.println("""
                    1.Suma
                    2.Resta
                    3.Multiplicacion
                    4.Division
                    5.Salir
                    """);
        System.out.print("Operacion a realizar?: ");
    }
    private static void ejecutarOperacion( int operacion, Scanner consola ){
        System.out.print("Proporciona valor operando1: ");
        var operando1 = Double.parseDouble(consola.nextLine());
        System.out.print("Proporciona valor operando2: ");
        var operando2 = Double.parseDouble(consola.nextLine());
        double resultado;
        switch (operacion) {
            case 1 -> { //Suma
                resultado = operando1 + operando2;
                System.out.println("Resultado suma: " + resultado);
            }
            case 2 -> { //Resta
                resultado = operando1 - operando2;
                System.out.println("Resultado resta: " + resultado);
            }
            case 3 -> { //Multiplicacion
                resultado = operando1 * operando2;
                System.out.println("Resultado multiplicacion: " + resultado);
            }
            case 4 -> { //Division
                resultado = operando1 / operando2;
                System.out.println("Resultado division: " + resultado);
            }
            default -> System.out.println("La pcion es erronea: " + operacion);
        }
    }
}//Fin de clase


