package com.wu.service.impl;

import com.wu.pojo.Accounts;
import com.wu.pojo.OpTypes;
import com.wu.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
public class AccountServiceImplTest {

    @Autowired
    private AccountService accountService;

    @Test
    void openAccount() {
        Accounts accounts = new Accounts(5, 100);
        Integer integer = accountService.openAccount(accounts, 100);
        System.out.println(integer);
    }

    @Test
    void deposite() {
        Accounts accounts = new Accounts();
        accounts.setAccountId(5);
        Accounts deposite = accountService.deposite(accounts, OpTypes.deposite.getName(), -120, null);
        System.out.println(deposite);
    }

    @Test
    void withdrow() {
        Accounts accounts = new Accounts();
        accounts.setAccountId(5);
        Accounts withdrow = accountService.withdrow(accounts, OpTypes.withdraw.getName(), 10, null);
        System.out.println(withdrow);
    }

    @Test
    @Transactional
        //在junit中通过使用  @Transactional  在测试完后，用恢复现场.
    void transter() {
        Accounts a1 = new Accounts();

        a1.setAccountId(2);
        Accounts a2 = new Accounts();
        a2.setAccountId(5);
        Accounts transter = accountService.transter(a2, a1, 100);
        System.out.println(transter);
    }

    @Test
    void showBalance() {
        Accounts a1 = new Accounts();

        a1.setAccountId(2);
        System.out.println(accountService.showBalance(a1));
    }

    @Test
    void findOpRecordById() {
    }
}