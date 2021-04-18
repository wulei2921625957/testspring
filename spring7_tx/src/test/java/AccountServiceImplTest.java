import com.wu.tx.AppConfig;
import com.wu.tx.Bean.Accounts;
import com.wu.tx.Bean.OpTypes;
import com.wu.tx.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class AccountServiceImplTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void openAccount() {
        Accounts accounts = new Accounts();
        accounts.setAccountId(30);
        Integer integer = accountService.openAccount(accounts, 100);
        System.out.println(integer);
    }

    @Test
    public void deposite() {
        Accounts accounts = new Accounts();
        accounts.setAccountId(2);
        Accounts deposite = accountService.deposite(accounts, OpTypes.deposite.getName(), 100, null);
        System.out.println(deposite);
    }

    @Test
    public void withdrow() {
        Accounts accounts = new Accounts();
        accounts.setAccountId(1);
        Accounts deposite = accountService.withdrow(accounts, OpTypes.withdraw.getName(), 100, null);
        System.out.println(deposite);
    }

    @Test
    public void transter() {
    }

    @Test
    public void showBalance() {
    }

    @Test
    public void findOpRecordById() {
    }
}