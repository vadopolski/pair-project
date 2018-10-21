import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        //create multi currency  single user account
        Money dollar1 = new Money(5, "USD");
        Money euro1 = new Money(10,"EUR");
        Money ruble1 = new Money(1000, "RUB");

        Set<Money> monies1 = new HashSet<>();
        monies1.add(dollar1);
        monies1.add(euro1);
        monies1.add(ruble1);

        Account multiCurrencyAccount1 = new Account(1234);
        multiCurrencyAccount1.setMoney(monies1);

        //create multi user account
        Money dollar2 = new Money(4, "USD");

        Set<Money> monies2 = new HashSet<>();
        monies2.add(dollar2);

        Account multiUserAccount1 = new Account(4321);
        multiUserAccount1.setMoney(monies2);

        //create single user singly currency account
        Money ruble2 = new Money(5000, "RUB");

        Set<Money> monies3 = new HashSet<>();
        monies3.add(ruble2);

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
    }
}
