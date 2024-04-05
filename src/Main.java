import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*Crear un Cliente e imprimirlo en pantalla.*/
        ClientBank client1 = new ClientBank("Neira Maria Eugenia", 'F');
        System.out.println(client1);
    /*Crear una Cuenta bancaria para el Cliente anterior con un saldo inicial de
    10000.*/

        List<Operation> operations = new ArrayList<>();
        BankAccount account1 = new BankAccount(10000d, client1, operations);


    /*Realizar operaciones de depósito y extracción para probar esa
    funcionalidad.*/
        System.out.println(account1.debit(5000d));
        System.out.println("Balance del cliente " + client1.getName() + " es " + account1.getBalance());

        account1.credit(10000d);
        System.out.println("Balance del cliente " + client1.getName() + " es " + account1.getBalance());

        System.out.println(account1.debit(20000d));

    /*Es necesario agregar una variante de Cuenta que permita un saldo deudor,
    de máximo 2000 pesos. Esto significa que la cuenta puede aceptar un
    balance negativo con un máximo de - 2000. Realice los cambios y pruebas
    necesarias.*/
        System.out.println(account1.overdraft(16000d));
        System.out.println("Balance del cliente " + client1.getName() + " es " + account1.getBalance());

        /*Analice cómo implementaría con las herramientas conocidas hasta el momento, llevar
    un registro de como máximo 10 operaciones de depósito y extracción que se realizaron
    en la cuenta. En donde se almacene en memoria de alguna forma la siguiente cadena de texto:
    i. Depósito: "El {NombreCliente}, depositó {MontoDepositado}"
    ii. Extracción: "El {NombreCliente}, retiró {MontoRetirado}"*/
        account1.printDetail();

    }
}