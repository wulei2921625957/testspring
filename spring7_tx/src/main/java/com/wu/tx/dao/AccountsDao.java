package com.wu.tx.dao;

import com.wu.tx.Bean.Accounts;

import java.util.List;

/**
 * @author: 吴磊
 * @program: testspring
 * @create: 2021-04-14 20:20
 */
public interface AccountsDao {
    int saveAccount(Accounts account);

    Accounts updateAccount(Accounts account);

    Accounts findAccount(int accountId);

    List<Accounts> findAll();

    void delete(int accountId);
}
