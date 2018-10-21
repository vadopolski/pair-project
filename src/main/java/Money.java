public class Money {
    private long quantity;
    private final String currency;

    public Money(final long quantity, final String currency) {
        this.quantity = quantity;
        this.currency = currency;
    }

    public long getQuantity() {
        return quantity;
    }

    public String getCurrency() {
        return currency;
    }
}
