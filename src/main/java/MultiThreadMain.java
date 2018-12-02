import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiThreadMain {
    public static void main(String[] args) throws InterruptedException {
        Money millionRuble = new Money(1000000, "RUB");

        Map<String, Money> monies1 = new HashMap<>();
        monies1.put(millionRuble.getCurrency(), millionRuble);

        Account accountFrom = new Account(1111);
        accountFrom.setMoney(monies1);

        System.out.println("Account number is "  + accountFrom.getNumber() +
                " amount of RUB is " + accountFrom.getMoney().get("RUB").getAmount());


        List<Account> accounts = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Money money = new Money(0L, "RUB");
            Account account = new Account(i);
            account.getMoney().put(money.getCurrency(), money);
            accounts.add(account);
        }

        List<Transaction> transactions = new ArrayList<>();



        for (int i = 0; i < 100; i++){
            new Thread(){
                Transaction transaction = new Transaction(accountFrom, accounts.get(0),
                        LocalDateTime.now(), 1000, "RUB");

                Thread.sleep(100);
                transaction.complete();
                transactions.add(transaction);
            }.start();
        }

        System.out.println("Account number is "  + accountFrom.getNumber() +
                " amount of RUB is " + accountFrom.getMoney().get("RUB").getAmount());

    }
}
