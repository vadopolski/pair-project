public class Money {
    private long amount;
    private final String currency;

    public Money(final long quantity, final String currency) {
        this.amount = quantity;
        this.currency = currency;
    }

    public long getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void reduce(long amount) {
            if(this.amount >= amount){
                this.amount = this.amount - amount;
            } else {
                // TODO: 02.12.18 Exception
            }
    }

    public void increase(long amount) {
            if(amount > 0){
                this.amount = this.amount + amount;
            } else {
                // TODO: 02.12.18 Exception
            }
    }
}