import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //create multi currency  single user account
        Money dollar1 = new Money(5, "USD");
        Money euro1 = new Money(10, "EUR");
        Money ruble1 = new Money(1000, "RUB");

        Map<String, Money> monies1 = new HashMap<>();
        monies1.put(dollar1.getCurrency(), dollar1);
        monies1.put(euro1.getCurrency(), euro1);
        monies1.put(ruble1.getCurrency(), ruble1);

        Account multiCurrencyAccount1 = new Account(1234);
        multiCurrencyAccount1.setMoney(monies1);

        //create multi user account
        Money dollar2 = new Money(4, "USD");

        Map<String, Money> monies2 = new HashMap<>();
        monies2.put(dollar2.getCurrency(), dollar2);

        Account multiUserAccount1 = new Account(4321);
        multiUserAccount1.setMoney(monies2);

        //create single user singly currency account
        Money ruble2 = new Money(5000, "RUB");

        Map<String, Money> monies3 = new HashMap<>();
        monies3.put(ruble2.getCurrency(), ruble2);

        Account singleUserSingleCurrencyAccount = new Account(1111);
        singleUserSingleCurrencyAccount.setMoney(monies3);

        //create user 1
        User user1 = new User("Ivan", "Petrov");

        Set<Account> accounts = new HashSet<>();
        accounts.add(multiCurrencyAccount1);
        accounts.add(multiUserAccount1);

        user1.setAccounts(accounts);

        //create user 2
        User user2 = new User("John", "Malkovich");

        Set<Account> accounts2 = new HashSet<>();
        accounts2.add(singleUserSingleCurrencyAccount);
        accounts2.add(multiUserAccount1);

        user2.setAccounts(accounts2);

        // Create and complete test transaction
        System.out.println("Account number is "  + multiCurrencyAccount1.getNumber() +
                        " amount of RUB is " + multiCurrencyAccount1.getMoney().get("RUB").getAmount());

        System.out.println("Account number is "  + singleUserSingleCurrencyAccount.getNumber() +
                        " amount of RUB is " + singleUserSingleCurrencyAccount.getMoney().get("RUB").getAmount());

        Transaction rubleTransaction = new Transaction(multiCurrencyAccount1, singleUserSingleCurrencyAccount,
                LocalDateTime.now(), 500, "RUB");

        System.out.println("The status of transaction is " + rubleTransaction.getStatus());

        rubleTransaction.complete();

        System.out.println("The status of transaction is " + rubleTransaction.getStatus());

        System.out.println("Account number is "  + multiCurrencyAccount1.getNumber() +
                " amount of RUB is " + multiCurrencyAccount1.getMoney().get("RUB").getAmount());

        System.out.println("Account number is "  + singleUserSingleCurrencyAccount.getNumber() +
                " amount of RUB is " + singleUserSingleCurrencyAccount.getMoney().get("RUB").getAmount());
    }
}