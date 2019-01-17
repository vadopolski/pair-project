import java.time.LocalDateTime;

public class Bank implements Runnable{

    Transaction transaction;

    public Transaction createTransaction(Account accountFrom, Account accountTo,
                                         LocalDateTime dateTime, long amount, String currency) {
        transaction = new Transaction(accountFrom, accountTo, dateTime, amount, currency);

        return transaction;
    }

    @Override
    public void run() {
        try {
            transaction.complete();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
