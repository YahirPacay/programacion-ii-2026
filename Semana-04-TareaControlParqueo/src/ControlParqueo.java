import java.util.Scanner;

public class ControlParqueo {
    public static void main(String[] args) {
        //Nombre: Wesley Yahir
        //Carnet: 9941-25-6309

        Scanner scanner = new Scanner(System.in);
        System.out.println("--------Parqueo--------");


        int cantidadVehiculos = obtenerCantidadVehiculos();
        int contadorMotos = 0;
        int contadorAutomoviles = 0;
        int contadorPickups = 0;
        double totalDineroRecaudado = 0;
        int totalTicketPerdidos = 0;

        String placaGuardar = "";
        double vehiculoCuotaGrande = 0;

        for (int i = 1; i <= cantidadVehiculos; i++){

            System.out.print("Ingresar Placa de vehiculo: ");
            String placa = scanner.nextLine();
            int tipoVehiculo = registroVehiculo();
            int horas = horas();
            boolean ticket = ticket();
            double tarifa = tarifa(tipoVehiculo);
            double recargo = recargoTicket(ticket);
            double subTotal = calcularPago(horas, tarifa);
            double descuento = descuento(horas);
            double total;

            if(ticket){
                total = calcularPago(horas, tarifa,descuento,ticket, recargo);
                totalDineroRecaudado += total;
                totalTicketPerdidos++;
            }else {
                total = calcularPago(horas, tarifa);
                totalDineroRecaudado += total;
            }

            mostrarComprobante(tipoVehiculo, horas, tarifa,subTotal,recargo, descuento,total );

            switch (tipoVehiculo){
                case 1:
                    contadorMotos++;
                    break;
                case 2:
                    contadorAutomoviles++;
                    break;
                case 3:
                    contadorPickups++;
                    break;
            }

            if (total > vehiculoCuotaGrande){
                vehiculoCuotaGrande = total;
                placaGuardar = placa;

            }

        }
        System.out.println("-----Resumen Jornada-----");
        System.out.println("Conteo Motos: " + contadorMotos);
        System.out.println("Conteo Automoviles: " + contadorAutomoviles);
        System.out.println("Conteo Pickups: " + contadorPickups);
        System.out.println("Total Ticket Perdidos: " + totalTicketPerdidos);
        System.out.println("Total Dinero Recaudado: "+ totalDineroRecaudado);
        System.out.println("Placa Vehiculo que mas pago: " + placaGuardar +" Q"+ vehiculoCuotaGrande);
        System.out.println("-------------------------");


    }

    public static int obtenerCantidadVehiculos() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Registre cantidad de Vehiculos: ");
            if (scanner.hasNextInt()) {
                int cantidadVehiculos = scanner.nextInt();
                if (cantidadVehiculos > 0) {
                    System.out.println("Cantidad de vehiculos valido");
                    return cantidadVehiculos;
                } else {
                    System.out.println("Cantidad mayour a 0");
                }
            } else {
                System.out.println("Numero de Vehiculos no valido");
                scanner.next();
            }
        } while (true);
    }

    public static String placa(String placa){

        return placa;
    }



    public static int registroVehiculo() {
        Scanner scanner = new Scanner(System.in);



        System.out.println("Tipo de Vehiculo");
        System.out.println("1. Motocicleta");
        System.out.println("2. automovil");
        System.out.println("3. pickup camioneta");
        do {

            System.out.print("Ingrese el numero de tipo de sus vehiculo: ");

            if (scanner.hasNextInt()) {
                int tipoVehiculo = scanner.nextInt();
                switch (tipoVehiculo) {
                    case 1:
                        System.out.println("Motocicleta");
                        return 1;

                    case 2:
                        System.out.println("Automovil");
                        return 2;

                    case 3:
                        System.out.println("Pickup o Camioneta");
                        return 3;

                    default:
                        System.out.println("Opcion invalida, Intente de nuevo");
                        break;
                }


            } else {
                System.out.println("Opcion Invalida");
                scanner.next();

            }

        } while (true);

    }

    public static int horas() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Horas estacionadas: ");
            if (scanner.hasNextInt()) {
                int hora = scanner.nextInt();
                if (hora > 0) {
                    System.out.println("Hora registrada");
                    return hora;
                } else {
                    System.out.println("La hora no puede ser menor a 0");
                }
            } else {
                System.out.println("Hora Invalida, ingrese la hora exacta");
                scanner.next();
            }
        } while (true);


    }

    public static boolean ticket() {
        Scanner scanner = new Scanner(System.in);
        boolean ticketPer;
        do {
            System.out.print("Perdio el ticket? Escrbe S/N: ");
            String usuarioTicket = scanner.nextLine().toLowerCase();
            if (usuarioTicket.equalsIgnoreCase("s")) {
                ticketPer = true;
                return ticketPer;

            } else if (usuarioTicket.equalsIgnoreCase("n")) {
                ticketPer = false;
                return ticketPer;
            } else {
                System.out.println("Ingreso no valido, intente de nuevo");
            }
        } while (true);

    }

    public  static  double recargoTicket(boolean ticket){
        if (ticket){
            return 50;
        }
        return 0;
    }

    public static double tarifa (int tipoVehiculo){
        double tarifaPrecio ;
        switch (tipoVehiculo){
            case 1:
                tarifaPrecio = 5;
                return tarifaPrecio;
            case 2:
                tarifaPrecio = 8;
                return tarifaPrecio;
            case 3:
                tarifaPrecio = 12;
                return tarifaPrecio;
            default:
                return 0;
        }

    }

    public  static double descuento(int hora){
        if (hora > 8){
            return  0.15;
        }
        return 0;
    }

    public static double calcularPago(int hora, double tarifa) {
        double subTotal = tarifa * hora ;
        return  subTotal - (subTotal * descuento(hora));

    }

    public  static  double calcularPago(int hora, double tarifa, double descuento,boolean tikcket,double recargoIicket){
        if (tikcket){

            double subtotal = tarifa * hora;
            double total = (subtotal - (subtotal * descuento))+ recargoIicket;
            return  total;
        }else {

            return calcularPago(hora, tarifa);
        }

    }

    public static void mostrarComprobante(int tipoVehiculo, int horas, double tarifa , double calculoPago, double recargo, double descuento,double total ){
        System.out.println("-----Comprobante-----");
        System.out.print("Tipo de Vehiculo: ");
        switch (tipoVehiculo){
            case 1:
                System.out.println("Motocicleta");
                break;
            case 2:
                System.out.println("Automovil");
                break;
            case 3:
                System.out.println("pickup Camioneta");
                break;
            default:
                break;
        }
        System.out.println("Horas estacionadas: "  + horas);
        System.out.println("Tarifa por hora: "  + tarifa);
        System.out.println("Subtotal: " + calculoPago);
        System.out.println("Descuento: " + (calculoPago * descuento));
        System.out.println("Recargo por ticket: " + recargo);
        System.out.println("Total: " + total);

        System.out.println("------------------");

    }


}

