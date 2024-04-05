import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BankAccount {
    private static Integer id = 0; // como hago autoincremental????
    private Double balance;
    private ClientBank client;
    private List<Operation> operations;


    public BankAccount(Double balance, ClientBank client, List<Operation> operations) {
        id++;
        this.balance = balance;
        this.client = client;
        this.operations = operations;
    }

    public static Integer getId() {
        return id;
    }

    public Double getBalance() {
        return balance;
    }

    public ClientBank getClient() {
        return client;
    }


    public String debit(Double amount) {
        if (amount < this.balance) {
            Operation x = new Operation(-amount);
            operations.add(x);
            this.balance -= amount;
            return "Operacion exitosa";
        } else {
            return "Saldo insuficiente";
        }
    }

    public String overdraft(Double amount) {
        Double newBalance = this.balance - amount;
        if (newBalance >= -2000) {
            this.balance -= amount;
            return "Operacion exitosa";
        } else {
            return "Saldo insuficiente";
        }
    }

    public void credit(Double amount) {
        Operation x = new Operation(amount);
        operations.add(x);
        this.balance += amount;
    }

    public String printDetail() {
        int j = operations.size() - 1; // j es mi ultima posicion distinta de null del arreglo

        String data = "El cliente ";
        if (j > 10) {
            int k = j - 10; // k es hasta donde quiero llegar en el arreglo si tiene mas de 10 datos el arreglo
            for (int i = j; i > k; i--) {
                if (operations.get(i).getAmount() < 0) {
                    data += this.client.getName() + ", retiró " + operations.get(i).getAmount() + " pesos, \n";
                } else {
                    data += this.client.getName() + ", depositó " + operations.get(i).getAmount() + " pesos, \n";
                }
            }
        }
        else {
            for (int i = j; i > 0; i--) {
                if (operations.get(i).getAmount() < 0) {
                    data += this.client.getName() + ", retiró " + operations.get(i).getAmount() + ", \n";
                } else {
                    data += this.client.getName() + ", depositó " + operations.get(i).getAmount() + ", \n";
                }
            }
        }

        return data;
    }
}
