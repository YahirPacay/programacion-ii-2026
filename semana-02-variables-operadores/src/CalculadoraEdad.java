import java.util.Scanner;
//Wesley Yahir Pacay Díaz
public class CalculadoraEdad {
    public static void main(String[] args){
        //Se solicitan los datos de entrada para el calculo
        Scanner entrada = new Scanner(System.in);
        System.out.print("Ingrese su nombre: ");
        String nombre = entrada.nextLine();
        System.out.print("Ingrese su Carnet: ");
        String carnet = entrada.nextLine();
        System.out.print("Ingrese su año de nacimiento: ");
        int anioNacimiento = entrada.nextInt();
        System.out.print("Ingrese el año actual: ");
        int anioActual = entrada.nextInt();

        System.out.println("---Resultado---");

        //Se realizan los calculos de edad y meses y se imprimen
        int calculoEdad = anioActual - anioNacimiento;
        int calculoMeses = calculoEdad * 12;
        boolean esMayor = calculoEdad >= 18;
        System.out.println("Nombre: " + nombre);
        System.out.println("Carnet: "+ carnet);
        System.out.println("Edad Aproximada: " + calculoEdad);
        System.out.println("Meses aproximados: " + calculoMeses  );
        System.out.println("¿Es mayor de edad? " + esMayor);

    }

}
