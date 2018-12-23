import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadMain {
    public static void main(String[] args) throws InterruptedException {
        Money millionRuble = new Money(1000000, "RUB");

        Map<String, Money> monies1 = new HashMap<>();
        monies1.put(millionRuble.getCurrency(), millionRuble);

        Account accountFrom = new Account(1111);
        accountFrom.setMoney(monies1);

        System.out.println("BEFORE Account number is "  + accountFrom.getNumber() +
                " amount of RUB is " + accountFrom.getMoney().get("RUB").getAmount());

        List<Account> accounts = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Money money = new Money(0L, "RUB");
            Account account = new Account(i);
            account.getMoney().put(money.getCurrency(), money);
            accounts.add(account);
        }

        List<Transaction> transactions = new ArrayList<>();

        Random random = new Random();

        TransactionManager transactionManager = new TransactionManager();
//        ExecutorService pool = Executors.newSingleThreadExecutor();
        ExecutorService pool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++){
            int acountNumber = random.nextInt(10);
            Transaction transaction = transactionManager.createTransaction(accountFrom, accounts.get(acountNumber),
                    LocalDateTime.now(), 10000, "RUB");
            pool.execute(transaction);
//            transaction.complete();
            transactions.add(transaction);
        }

        Thread.sleep(100);


        System.out.println("AFTER Account number is "  + accountFrom.getNumber() +
                " amount of RUB is " + accountFrom.getMoney().get("RUB").getAmount());

        long result = 0;
        for (Account account: accounts){
            result += account.getMoney().get("RUB").getAmount();

            System.out.println("Account number: " +  account.getNumber()
                                + "acoount amount: " + account.getMoney().get("RUB").getAmount());

        }

        System.out.println("AFTER The sum of amount in all to accounts is: " + result);

        pool.shutdown();
    }
}