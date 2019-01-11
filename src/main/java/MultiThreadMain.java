import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadMain {
    public static void main(String[] args) throws InterruptedException {
        Money millionRuble = new Money(1000000, "RUB");

        Account accountFrom = new Account(1111, millionRuble);


        System.out.println("BEFORE Account number is "  + accountFrom.getNumber() +
                " amount of RUB is " + accountFrom.getMoney().getAmount());

        List<Account> accounts = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Money money = new Money(0L, "RUB");
            Account account = new Account(i, money);
            accounts.add(account);
        }

        List<Transaction> transactions = new ArrayList<>();

        Random random = new Random();

        Bank bank = new Bank();

        ExecutorService pool = Executors.newFixedThreadPool(10);

        // create 100 10000 RUR transaction to random account number
        for (int i = 0; i < 100; i++){
            int acountNumber = random.nextInt(10);
            Transaction transaction = bank.createTransaction(accountFrom, accounts.get(acountNumber),
                    LocalDateTime.now(), 10000, "RUB");
            pool.execute(transaction);
//            transaction.complete();
            transactions.add(transaction);
        }

        Thread.sleep(100);


        System.out.println("AFTER Account number is "  + accountFrom.getNumber() +
                " amount of RUB is " + accountFrom.getMoney().getAmount());

        long result = 0;
        for (Account account: accounts){
            result += account.getMoney().getAmount();
            System.out.println("Account number is " + account.getNumber() +
                               " amount is " + account.getMoney().getAmount() +
                                " " + account.getMoney().getCurrency());

        }

        System.out.println("AFTER The sum of amount in all to accounts is: " + result);

        pool.shutdown();
    }
}