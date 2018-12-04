import java.time.LocalDateTime;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Transaction implements Runnable {
    
    private final static String COMPLETED = "COMPLETED";
    private static final String CREATED = "CREATED";
    
    private Account accountFrom;
    private Account accountTo;
    private String status;
    private LocalDateTime dateTime;
    private String currency;
    private long amount;
    private Lock bankLock;
    
    public Transaction(Account accountFrom, Account accountTo,
        LocalDateTime dateTime, long amount, String currency) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.status = CREATED;
        this.dateTime = dateTime;
        this.amount = amount;
        this.currency = currency;
        bankLock = new ReentrantLock();
    }
    
    public Account getAccountFrom() {
        return accountFrom;
    }
    
    public Account getAccountTo() {
        return accountTo;
    }
    
    public String getStatus() {
        return status;
    }
    
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    
    public long getAmount() {
        return amount;
    }
    
    public String getCurrency() {
        return currency;
    }
    
    
    public String complete() throws InterruptedException {
        bankLock.lock();
        
        try {
            Money moneyFrom = accountFrom.getMoney().get(currency);
            
            if (moneyFrom == null) {
                return "There is no money in this currency";
            }
            
            Money moneyTo = accountTo.getMoney().get(currency);
            
            if (moneyTo == null) {
                return "There is no money in this currency";
            }
            
            moneyFrom.reduce(amount);
            moneyTo.increase(amount);
            
            Thread.sleep(10);
            
            status = COMPLETED;
            
            return status;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bankLock.unlock();
        }
        return  null;
    }
    
    @Override
    public void run() {
        try {
            this.complete();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}