package advance;

import org.example.junit.advance.BankAccount;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class BankAccountTest {
    @Test
    void testDeposit() {
        BankAccount account = new BankAccount(100.0);
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), "Balance should be updated correctly after deposit");
    }

    @Test
    void testWithdraw() {
        BankAccount account = new BankAccount(100.0);
        account.withdraw(30.0);
        assertEquals(70.0, account.getBalance(), "Balance should be updated correctly after withdrawal");
    }

    @Test
    void testWithdrawInsufficientFunds() {
        BankAccount account = new BankAccount(50.0);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(100.0), "Should throw exception for insufficient funds");
    }
}
