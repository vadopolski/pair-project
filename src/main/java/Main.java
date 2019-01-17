import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //create single user account
        Money ruble1 = new Money(1000, "RUB");
        Account singleUserAccount1 = new Account(1234, ruble1);
        
        //create multi user account
        Money dollar2 = new Money(4, "USD");
        Account singleUserAccount2 = new Account(4321, dollar2);
        
        Money ruble2 = new Money(5000, "RUB");
        Account multiUserAccount = new Account(1111, ruble2);
        
        //create user 1
        User user1 = new User("Ivan", "Petrov");
        Set<Account> accounts = new HashSet<>();
        
        accounts.add(singleUserAccount1);
        accounts.add(multiUserAccount);
        user1.setAccounts(accounts);

        //create user 2
        User user2 = new User("John", "Malkovich");
        Set<Account> accounts2 = new HashSet<>();
    
        accounts2.add(singleUserAccount2);
        accounts2.add(multiUserAccount);
        user2.setAccounts(accounts2);

        // Create and complete test transaction
        System.out.println("Account number is "  + singleUserAccount1.getNumber() +
                        " amount of " + singleUserAccount1.getMoney().getCurrency() +
                        " is " + singleUserAccount1.getMoney().getAmount());

        System.out.println("Account number is "  + multiUserAccount.getNumber() +
                        " amount of RUB is " + multiUserAccount.getMoney().getAmount());

        Transaction rubleTransaction = new Transaction(singleUserAccount1, multiUserAccount,
                LocalDateTime.now(), 500, "RUB");

        System.out.println("The status of transaction is " + rubleTransaction.getStatus());

        rubleTransaction.complete();

        System.out.println("The status of transaction is " + rubleTransaction.getStatus());
    
        System.out.println("Account number is "  + singleUserAccount1.getNumber() +
            " amount of " + singleUserAccount1.getMoney().getCurrency() +
            " is " + singleUserAccount1.getMoney().getAmount());
    
        System.out.println("Account number is "  + multiUserAccount.getNumber() +
            " amount of RUB is " + multiUserAccount.getMoney().getAmount());
    }
}