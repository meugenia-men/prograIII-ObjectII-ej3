public class BankAccount {
    private static Integer id = 0;
    private Double balance;
    private ClientBank client;

    public BankAccount() {
    }

    public BankAccount(Double balance, ClientBank client) {
        this.balance = balance;
        this.client = client;
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

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void setClient(ClientBank client) {
        this.client = client;
    }

    public String debit(Double amount){
        if(amount<this.balance){
            this.balance-=amount;
            return "Operacion exitosa";
        }
        else{
            return "Saldo insuficiente";
        }
    }

    public  String overdraft(Double amount){
        Double newBalance=this.balance-amount;
        if(newBalance>=-2000){
            this.balance-=amount;
            return "Operacion exitosa";
        }
        else{
            return "Saldo insuficiente";
        }
    }

    public void credit(Double amount){
        this.balance+=amount;
    }
}
