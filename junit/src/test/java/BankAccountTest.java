import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    void testDepositIncreasesBalance() {
        BankAccount account = new BankAccount(100);
        account.deposit(50);
        assertEquals(150, account.getBalance());
    }

    @Test
    void testWithdrawDecreasesBalance() {
        BankAccount account = new BankAccount(100);
        account.withdraw(40);
        assertEquals(60, account.getBalance());
    }

    @Test
    void testWithdrawFailsWhenInsufficientFunds() {
        BankAccount account = new BankAccount(30);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(50));
    }

    @Test
    void testGetBalance() {
        BankAccount account = new BankAccount(200);
        assertEquals(200, account.getBalance());
    }
}
