
import java.util.Scanner;

public class ParcialI {
    //NOmbre: Wesley Pacay
    //Carnet: 9941-25-6309

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        double saldo = 1000;
        double retiro;
        int opcion;

        // Menú
        do {

            System.out.println("===== CAJERO AUTOMÁTICO =====");
            System.out.println("1. Ver saldo");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = entrada.nextInt();

            switch (opcion) {

                case 1:
                    // Se utiliza el método sobrecargado aqui
                    mostrarMensaje("Su saldo actual es:", saldo);
                    break;

                case 2:
                    System.out.print("Ingrese la cantidad a retirar: ");
                    retiro = entrada.nextDouble();

                    if (retiro > 0 && retiro <= saldo) {

                        saldo = saldo - retiro;

                        //método sobrecargado
                        mostrarMensaje("Retiro realizado correctamente.", retiro);


                        mostrarMensaje("Gracias por utilizar el cajero.");

                    } else {


                        mostrarMensaje("No tiene suficiente saldo o la cantidad no es válida.");
                    }

                    break;

                case 3:
                    mostrarMensaje("Gracias por utilizar el cajero.");
                    break;

                default:
                    mostrarMensaje("Opcion no valida.");
            }

        } while (opcion != 3);

        entrada.close();
    }


    public static void mostrarMensaje(String mensaje) {

        System.out.println(mensaje);
    }

    // Método sobrecargado
    public static void mostrarMensaje(String mensaje, double cantidad) {

        System.out.println(mensaje + " Q" + cantidad);
    }
}
