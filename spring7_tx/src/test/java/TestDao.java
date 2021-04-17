import com.wu.tx.AppConfig;
import com.wu.tx.Bean.Accounts;
import com.wu.tx.dao.impl.AccountDaoImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * @author: 吴磊
 * @program: testspring
 * @create: 2021-04-14 19:41
 */

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class TestDao {
    @Autowired
    private DataSource dataSource;


    @Autowired
    private AccountDaoImpl accountDao;

    @Test
    public void testDataSource() throws SQLException {
        Assert.assertNotNull(dataSource);
        System.out.println(dataSource.getConnection());
    }

    @Test
    public void testAccountDaoImpl() {
        Assert.assertNotNull(accountDao);
    }


    @Test
    public void testOpenAccounts() {
        Accounts accounts = new Accounts(10, 10);
        int i = accountDao.saveAccount(accounts);
        System.out.println(i);
    }

    @Test
    public void testFindAll() {
        List<Accounts> all = accountDao.findAll();
        all.forEach(System.out::println);
    }

    @Test
    public void testFindOne() {
        Accounts accounts = accountDao.findAccount(1);
        System.out.println(accounts);
    }
}
