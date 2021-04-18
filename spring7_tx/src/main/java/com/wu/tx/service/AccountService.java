package com.wu.tx.service;

import com.wu.tx.Bean.Accounts;
import com.wu.tx.Bean.OpRecord;

import java.util.List;

/**
 * @author: 吴磊
 * @program: testspring
 * @create: 2021-04-17 16:32
 */
public interface AccountService {

    /**
     * 开户
     *
     * @param accounts
     * @param money
     * @return
     */
    Integer openAccount(Accounts accounts, double money);

    /**
     * 存钱
     *
     * @param accounts
     * @param optype
     * @param money
     * @return
     */
    Accounts deposite(Accounts accounts, String optype, double money, String transferid);

    /**
     * 取钱
     *
     * @param accounts
     * @param optype
     * @param money
     * @return
     */
    Accounts withdrow(Accounts accounts, String optype, double money, String transferid);

    /**
     * 转账
     *
     * @param inAccount
     * @param outAccount
     * @param money
     * @return
     */
    Accounts transter(Accounts inAccount, Accounts outAccount, double money);

    /**
     * 查询余额
     *
     * @param accounts
     * @return
     */
    Accounts showBalance(Accounts accounts);

    /**
     * 查询流水
     *
     * @param accounts
     * @return
     */
    List<OpRecord> findOpRecordById(Accounts accounts);

}
