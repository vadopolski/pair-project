import java.util.Set;

public class Account {
    private final long number;
    private Set<Money> money;

    public Account(final long number) {
        this.number = number;
    }

    public void setMoney(Set<Money> money) {
        this.money = money;
    }

    public long getNumber() {
        return number;
    }

    public Set<Money> getMoney() {
        return money;
    }
}
