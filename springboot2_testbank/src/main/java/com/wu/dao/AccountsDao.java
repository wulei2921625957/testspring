package com.wu.dao;


import com.wu.pojo.Accounts;

import java.util.List;

/**
 * @author: 吴磊
 * @program: testspring
 * @create: 2021-04-14 20:20
 */
public interface AccountsDao {
    /**
     * 保存账户
     *
     * @param account
     * @return
     */
    int saveAccount(Accounts account);

    /**
     * 更新账户
     *
     * @param account
     * @return
     */
    Accounts updateAccount(Accounts account);

    /**
     * 根据账户ID查询账户信息
     *
     * @param accountId
     * @return
     */
    Accounts findAccount(int accountId);

    /**
     * 查询所有账户信息
     */
    List<Accounts> findAll();

    /**
     * 根据账户ID删除账户
     *
     * @param accountId
     */
    void delete(int accountId);
}
