import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        String menu = """
                -------------------------------------------------
                  Sea bienvenido/a al Conversor de Mónedas.
                    -Seleccine una opción a convertir:
                
                        1. Dólar  a Peso Argentino.
                        2. Peso Argentino a Dólar.
                        3. Dólar  a Real Brasileño.
                        4. Real Brasileño a Dólar.
                        5. Dólar a Boliviano.
                        6. Boliviano a Dólar.
                        7. Salir.
                
                    Elija una opción válida.
                -------------------------------------------------""";
        String TextoContinuar = """
                        __________________________
                        |    Desea continuar:    |
                        |       Si  o   No       |
                        |________________________|
                """;
        Scanner teclado = new Scanner(System.in);
        DivisaApi convertir = new DivisaApi();
        int opcion = 0;
        double cantidad ;
        Divisa resultado;
        String continuar;
        System.out.println(menu);
        try {
            while (opcion != 7) {
                opcion = teclado.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese la cantidad a convertir:");
                        cantidad = teclado.nextDouble();
                        resultado = convertir.ConvertirDivisa("USD", "ARS", cantidad);
                        System.out.println("La cantidad de : " + cantidad + " USD es igual a : " + resultado.conversion_result() +" ARS");
                        break;
                    case 2:
                        System.out.println("Ingrese la cantidad a convertir:");
                        cantidad = teclado.nextDouble();
                        resultado = convertir.ConvertirDivisa("ARS", "USD", cantidad);
                        System.out.println("La cantidad de : " + cantidad + " ARS es igual a : " + resultado.conversion_result() +" USD");
                        break;
                    case 3:
                        System.out.println("Ingrese la cantidad a convertir:");
                        cantidad = teclado.nextDouble();
                        resultado = convertir.ConvertirDivisa("USD", "BRL", cantidad);
                        System.out.println("La cantidad de : " + cantidad + " USD es igual a : " + resultado.conversion_result() +" BRL");
                        break;
                    case 4:
                        System.out.println("Ingrese la cantidad a convertir:");
                        cantidad = teclado.nextDouble();
                        resultado = convertir.ConvertirDivisa("BRL", "USD", cantidad);
                        System.out.println("La cantidad de : " + cantidad + " BRL es igual a : " + resultado.conversion_result() +" USD");
                        break;
                    case 5:
                        System.out.println("Ingrese la cantidad a convertir:");
                        cantidad = teclado.nextDouble();
                        resultado = convertir.ConvertirDivisa("USD", "BOB", cantidad);
                        System.out.println("La cantidad de : " + cantidad + " USD es igual a : " + resultado.conversion_result() +" BOB");
                        break;
                    case 6:
                        System.out.println("Ingrese la cantidad a convertir:");
                        cantidad = teclado.nextDouble();
                        resultado = convertir.ConvertirDivisa("BOB", "USD", cantidad);
                        System.out.println("La cantidad de : " + cantidad + " BOB es igual a : " + resultado.conversion_result() +" USD");
                        break;
                    case 7:
                        System.out.println("Gracias por utilízar el conversor de monedas.");
                        break;
                    default:
                        System.out.println("Seleccione una opción valída");
                        break;
                }
                System.out.println(TextoContinuar);
                continuar = teclado.next();
                if (continuar.equalsIgnoreCase("si")) {
                    System.out.println(menu);
                } else if (continuar.equalsIgnoreCase("no")){
                    System.out.println("Gracias por utilízar el conversor de monedas.");
                    break;
                }else{
                    System.out.println("Opcion no valida");
                    break;
                }
            }
        }catch (InputMismatchException e){
            System.out.println("Ingreso un dato invalido" +
                    "\nSe finalizo el programa");
        }

    }
}
