package com.wu.tx.service.impl;

import com.wu.tx.Bean.Accounts;
import com.wu.tx.Bean.OpRecord;
import com.wu.tx.Bean.OpTypes;
import com.wu.tx.dao.impl.AccountDaoImpl;
import com.wu.tx.dao.impl.OpRecordDaoImpl;
import com.wu.tx.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author: 吴磊
 * @program: testspring
 * @create: 2021-04-17 16:24
 */

@Transactional(
        propagation = Propagation.REQUIRED,
        isolation = Isolation.DEFAULT,
        readOnly = false,
        timeout = 100,
        noRollbackForClassName = {"RunTimeException"}
)
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDaoImpl accountDao;

    @Autowired
    private OpRecordDaoImpl opRecordDao;

    @Override
    public Integer openAccount(Accounts accounts, double money) {
        accounts.setBalance(money);
        int i = accountDao.saveAccount(accounts);
        return i;
    }

    @Override
    public Accounts deposite(Accounts accounts, String optype, double money, String transferid) {
        Accounts a = showBalance(accounts);
        
        OpRecord opRecord = new OpRecord();
        opRecord.setAccountid(a.getAccountId());
        opRecord.setOpmoney(money);
        opRecord.setOptype(optype);
        opRecord.setOptime(new Date());
        if (transferid == null) {
            opRecord.setTransferid(" ");
        } else {
            opRecord.setTransferid(transferid);
        }
        opRecordDao.saveOpRecord(opRecord);

        a.setBalance(a.getBalance() + money);
        accountDao.updateAccount(a);
        return a;
    }

    @Override
    public Accounts withdrow(Accounts accounts, String optype, double money, String transferid) {
        Accounts a = showBalance(accounts);

        OpRecord opRecord = new OpRecord();
        opRecord.setAccountid(a.getAccountId());
        opRecord.setOpmoney(money);
        opRecord.setOptype(optype);
        opRecord.setOptime(new Date());
        if (transferid == null) {
            opRecord.setTransferid(" ");
        } else {
            opRecord.setTransferid(transferid);
        }
        opRecordDao.saveOpRecord(opRecord);

        a.setBalance(a.getBalance() - money);
        accountDao.updateAccount(a);
        return a;
    }

    @Override
    public Accounts transter(Accounts inAccount, Accounts outAccount, double money) {
        String s = UUID.randomUUID().toString();
        deposite(inAccount, OpTypes.transfer.getName(), money, s);
        Accounts withdrow = withdrow(outAccount, OpTypes.withdraw.getName(), money, s);
        return withdrow;
    }

    @Override
    @Transactional(readOnly = true)
    public Accounts showBalance(Accounts accounts) {
        return accountDao.findAccount(accounts.getAccountId());
    }

    @Override
    @Transactional(readOnly = true)
    public List<OpRecord> findOpRecordById(Accounts accounts) {
        return opRecordDao.findByOpRecord(accounts.getAccountId());
    }
}
