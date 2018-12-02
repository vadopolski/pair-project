import java.time.LocalDateTime;

public class Transaction {

    private final static String COMPLETED = "COMPLETED";
    private static final String CREATED = "CREATED";

    private Account accountFrom;

    private Account accountTo;

    private String status;

    private LocalDateTime dateTime;

    private String currency;

    private long amount;

    public Transaction(Account accountFrom, Account accountTo,
                       LocalDateTime dateTime, long amount, String currency) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.status = CREATED;
        this.dateTime = dateTime;
        this.amount = amount;
        this.currency = currency;
    }

    public Account getAccountFrom() { return accountFrom; }

    public Account getAccountTo() { return accountTo; }

    public String getStatus() { return status; }

    public LocalDateTime getDateTime() { return dateTime; }

    public long getAmount() { return amount; }

    public String getCurrency() { return currency; }


    public String complete(){
        Money moneyFrom = accountFrom.getMoney().get(currency);

        if (moneyFrom == null) {
            return "There is no money in this currency";
        }

        Money moneyTo = accountTo.getMoney().get(currency);

        if (moneyTo == null) {
            return "There is no money in this currency";
        }

        moneyFrom.reduce(amount);
        moneyTo.increase(amount);

        status = COMPLETED;

        return status;
    }
}