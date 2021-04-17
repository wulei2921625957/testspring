import com.wu.tx.AppConfig;
import com.wu.tx.Bean.OpRecord;
import com.wu.tx.Bean.OpTypes;
import com.wu.tx.dao.impl.OpRecordDaoImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class OpRecordDaoImplTest {
    @Autowired
    private OpRecordDaoImpl opRecordDao;


    @Test
    public void setDataSource() {

    }

    @Test
    public void saveOpRecord() {
        OpRecord opRecord = new OpRecord();
        opRecord.setAccountid(2);
        opRecord.setOpmoney(1.0);
        opRecord.setOptype(OpTypes.deposite.getName());
        opRecord.setOptime(new Date());
        opRecord.setTransferid("");
        Integer integer = opRecordDao.saveOpRecord(opRecord);
        System.out.println(integer);
    }

    @Test
    public void findAll() {
        List<OpRecord> all = opRecordDao.findAll();
        all.forEach(System.out::println);
    }

    @Test
    public void findByOpRecord() {
        List<OpRecord> byOpRecord = opRecordDao.findByOpRecord(1);
        byOpRecord.forEach(System.out::println);
    }
}