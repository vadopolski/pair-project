
public class Account {
    private final long number;
    private final Money money;

    public Account(final long number, final Money money) {
        this.money = money;
        this.number = number;
    }
    
    public long getNumber() {
        return number;
    }
    
    public Money getMoney() {
        return money;
    }
}
