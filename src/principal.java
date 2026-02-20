
import com.google.gson.Gson;

import java.util.Scanner;

public class principal {
    public static void main(String[] args) {
        //menu de inicio
        System.out.println("------------Bienvenido al conversor de monedas----------------");
        System.out.println("Por favor ingrese la moneda que desea usar para cambio");
        System.out.println("Actualmente las opciones son");
        System.out.println("'UDS' para ----- Dolares");
        System.out.println("'BRL' para ------Real Brasileño");
        System.out.println("'MXN' para ------Pesos Mexicano");
        System.out.println("'EUR' para ------Euros");
        System.out.println("'JPY' para ------Yen japones");
        System.out.println("'RUB' para ------Rblo Ruso");

            int opcion1 = 0;
          do {
              System.out.println("---------A CONTINUACION INRESE LA CANTIDAD QUE DESA CAMBIAR---------\n");

              // valor de entrada usuario (cantidad de efectivo a cambiar)
              Scanner sc1 = new Scanner(System.in);
              Double ValorDeUsuario = sc1.nextDouble();
              System.out.println(ValorDeUsuario);


              //definir moneda de uso

              Scanner sc2 = new Scanner(System.in);
              System.out.println("ingrese la moneda que usara en con su denominacion en 3 letras");
              String textoMonedaUsiario = sc2.next().toUpperCase();
              var comprobacionTexto = textoMonedaUsiario.length();


              //condicion de seguridad
              if (comprobacionTexto == 3) {
                  consultaApi monedaUso = new consultaApi();
                  monedaUso.RespuestaApi(textoMonedaUsiario);
                  // seleccion de usuario (moneda base para el cambio)
                  System.out.println("inserte moneda para el cambio");

                  //ELECCION PARA EL CAMBIO
                  Scanner sc3 = new Scanner(System.in);
                  String monedaCambio = sc3.next().toUpperCase();


                  //cambio de json a gson
                  String json = monedaUso.RespuestaApi(textoMonedaUsiario);
                  Gson gson = new Gson();
                  MonedasDeCambio datos = gson.fromJson(json, MonedasDeCambio.class);

                  //OPERACION DE CAMBIO
                  Double tasaMXN = datos.getTasa(monedaCambio);
                  Double resultadoCmbio = tasaMXN * ValorDeUsuario;
                  System.out.println("resultados del cambio");
                  System.out.println(resultadoCmbio);


                  System.out.println("introdusca 1 para hacer su operacion de cambio");
                  System.out.println("introdusca 2 pra salir");

                  Scanner sc5 = new Scanner(System.in);
                  opcion1 = sc5.nextInt();
              } else {
                  System.out.println("INGRESE UN VALOR EN EL FORMATO CORRECTO");

                  System.out.println("introdusca 1 para hacer su operacion de cambio");
                  System.out.println("introdusca 2 pra salir");

                  Scanner sc4 = new Scanner(System.in);
                  opcion1 = sc4.nextInt();
              }

          } while (opcion1 == 1);

    }
}
