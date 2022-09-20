package client;

import java.util.Scanner;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import server.DaoCalculadora;
import server.Methods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class ClientRPC {

    static Scanner leer = new Scanner(System.in);

    static String response;

    public static void main(String[] args) throws MalformedURLException, XmlRpcException {
        String option = "", firstNumber = "", secondNumber = "", r="";

        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);

        Methods operations = new Methods();
        do {
            System.out.println("1.- Suma");
            System.out.println("2.- Resta");
            System.out.println("3.- Multiplicacion");
            System.out.println("4.- Division");
            System.out.println("5.- Exponente");
            System.out.println("6.- Raíz");
            System.out.println("7.- Consultar historial");
            System.out.println("8.- Salír");
            System.out.println("Selecciona una opción");
            option = leer.next();

            if (isNumber(option)) {
                switch (Integer.parseInt(option)) {
                    case 1:
                        //Validación de numeros
                        do {
                            System.out.println("SUMA");
                            System.out.println("Ingresa el primer número");
                            firstNumber = leer.next();

                            if (!isDouble(firstNumber))
                                System.out.println("Ingresa un número válido");
                            Object[] data = {firstNumber, secondNumber};
                        } while (!isDouble(firstNumber));

                        do {
                            System.out.println("SUMA");
                            System.out.println("Ingresa el segundo número");
                            secondNumber = leer.next();

                            if (!isDouble(secondNumber))
                                System.out.println("Ingresa un número válido");

                        } while (!isDouble(secondNumber));
                        //Ejecución en el servidor
                        Object[] data = {Double.parseDouble(firstNumber), Double.parseDouble(secondNumber)};
                        response = (String) client.execute("Methods.suma", data);
                        System.out.println("El resultado es: " + response);
                        r = "suma";
                        break;
                    case 2:
                        //Validación de numeros
                        do {
                            System.out.println("RESTA");
                            System.out.println("Ingresa el primer número");
                            firstNumber = leer.next();

                            if (!isDouble(firstNumber))
                                System.out.println("Ingresa un número válido");
                            Object[] data2 = {firstNumber, secondNumber};
                        } while (!isDouble(firstNumber));

                        do {
                            System.out.println("RESTA");
                            System.out.println("Ingresa el segundo número");
                            secondNumber = leer.next();

                            if (!isDouble(secondNumber))
                                System.out.println("Ingresa un número válido");

                        } while (!isDouble(secondNumber));
                        //Ejecución en el servidor
                        Object[] data2 = {Double.parseDouble(firstNumber), Double.parseDouble(secondNumber)};
                        String response2 = (String) client.execute("Methods.resta", data2);
                        System.out.println("El resultado es: " + response2);
                        r = "resta";
                        break;
                    case 3:
                        //Validación de numeros
                        do {
                            System.out.println("MULTIPLICACION");
                            System.out.println("Ingresa el primer número");
                            firstNumber = leer.next();

                            if (!isDouble(firstNumber))
                                System.out.println("Ingresa un número válido");
                            Object[] data3 = {firstNumber, secondNumber};
                        }while (!isDouble(firstNumber));

                        do {
                            System.out.println("MULTIPLICACION");
                            System.out.println("Ingresa el segundo número");
                            secondNumber = leer.next();

                            if (!isDouble(secondNumber))
                                System.out.println("Ingresa un número válido");

                        }while (!isDouble(secondNumber));
                        //Ejecución en el servidor
                        Object[] data3 = {Double.parseDouble(firstNumber),Double.parseDouble(secondNumber)};
                        response = (String) client.execute("Methods.multi", data3);
                        System.out.println("El resultado es: "+response);
                        r = "multiplicacion";
                        break;
                    case 4:
                        //No se puede dividir entre 0
                        //Validación de numeros
                        do {
                            System.out.println("DIVISION");
                            System.out.println("Ingresa el primer número");
                            firstNumber = leer.next();

                            if (!isDouble(firstNumber))
                                System.out.println("Ingresa un número válido");
                            Object[] data4 = {firstNumber, secondNumber};
                        }while (!isDouble(firstNumber));

                        do {
                            System.out.println("DIVISION");
                            System.out.println("Ingresa el segundo número");
                            secondNumber = leer.next();

                            if (!isDouble(secondNumber))
                                System.out.println("Ingresa un número válido");

                        }while (!isDouble(secondNumber));
                        //Ejecución en el servidor
                        Object[] data4 = {Double.parseDouble(firstNumber),Double.parseDouble(secondNumber)};
                         response = (String) client.execute("Methods.divi", data4);
                        System.out.println("El resultado es: "+response);
                        r = "division";
                        break;
                    case 5:
                        //Validación de numeros
                        do {
                            System.out.println("EXPONENTE");
                            System.out.println("Ingresa el primer número");
                            firstNumber = leer.next();

                            if (!isDouble(firstNumber))
                                System.out.println("Ingresa un número válido");
                            Object[] data5 = {firstNumber, secondNumber};
                        }while (!isDouble(firstNumber));

                        do {
                            System.out.println("EXPONENTE");
                            System.out.println("Ingresa el segundo número para el exponente");
                            secondNumber = leer.next();

                            if (!isDouble(secondNumber))
                                System.out.println("Ingresa un número válido");

                        }while (!isDouble(secondNumber));
                        //Ejecución en el servidor
                        Object[] data5 = {Double.parseDouble(firstNumber),Double.parseDouble(secondNumber)};
                         response = (String) client.execute("Methods.expo", data5);
                        System.out.println("El resultado es: "+response);
                        r = "exponente";
                        break;
                    case 6:
                        //No hay raiz de negativos
                        //Validación de numeros
                        do {
                            System.out.println("RAIZ");
                            System.out.println("Ingresa el primer número");
                            firstNumber = leer.next();

                            if (!isDouble(firstNumber))
                                System.out.println("Ingresa un número válido");
                            Object[] data6 = {firstNumber, secondNumber};
                        }while (!isDouble(firstNumber));

                        do {
                            System.out.println("RAIZ");
                            System.out.println("Ingresa el segundo número");
                            secondNumber = leer.next();

                            if (!isDouble(secondNumber))
                                System.out.println("Ingresa un número válido");

                        }while (!isDouble(secondNumber));
                        //Ejecución en el servidor
                        Object[] data6 = {Double.parseDouble(firstNumber),Double.parseDouble(secondNumber)};
                         response = (String) client.execute("Methods.raiz", data6);
                        System.out.println("El resultado es: "+response);
                        r = "raiz";
                        break;
                    case 7:
                        new DaoCalculadora();
                        break;
                    default:
                        System.out.println("No existe la opción");
                }

                operations.setR(r);
                operations.setFirstNumber(Double.parseDouble(firstNumber));
                operations.setSecondNumber(Double.parseDouble(secondNumber));
                operations.setResponse(response);
                response = String.valueOf(Methods.guardar(operations));
                System.out.println(response);

            } else {
                System.err.println("Opción incorrecta");
            }

        } while (!option.equals("8"));

    }

    public static boolean isNumber(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isDouble(String number) {
        try {
            Double.parseDouble(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
