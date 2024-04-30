import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        String menu = """
                ++++++++++++++++++++++++++++++++++++++++++++++++++
                Sea bienvenido/a al Conversor de Mónedas.
                
                -Seleccine una opción a convertir:
                
                1. Dólar  a Peso Argentino.
                2. Peso Argentino a Dólar.
                3. Dólar  a Real Brasileño.
                4. Real Brasileño a Dólar.
                5. Dólar a Peso Colombiano.
                6. Peso Colombiano a Dólar.
                7. Salir.
                
                Elija una opción válida:
                
                ++++++++++++++++++++++++++++++++++++++++++++++++++
                """;

        System.out.println(menu);
        Scanner teclado = new Scanner(System.in);
        DivisaApi convertir = new DivisaApi();
        int opcion = 0;
        double cantidad ;
        while (opcion != 7) {
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese le monto a convertir:");
                    cantidad = teclado.nextDouble();
                    Divisa resultado = convertir.ConvertirDivisa("USD","ARS", cantidad);
                    System.out.println(resultado.conversion_rate());
                    break;
                case 2:
                    System.out.println("Ingrese le monto a convertir:");
                    break;
            }

        }

    }
}
