import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Account {
    private final long number;
    private Map<String, Money> money;

    public Account(final long number) {
        this.money = new HashMap<>();
        this.number = number;
    }

    public void setMoney(Map<String, Money> money) {
        this.money = money;
    }

    public long getNumber() {
        return number;
    }

    public Map<String, Money> getMoney() {
        return money;
    }
}
