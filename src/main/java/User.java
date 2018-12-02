import java.util.Set;

public class User {
    private String name;
    private String lastname;
    private Set<Account> accounts;

    public User(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }
}
