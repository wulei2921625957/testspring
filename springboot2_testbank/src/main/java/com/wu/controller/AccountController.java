package com.wu.controller;

import com.alibaba.druid.util.StringUtils;
import com.wu.pojo.Accounts;
import com.wu.pojo.OpTypes;
import com.wu.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 吴磊
 * @program: testspring
 * @create: 2021-04-18 20:34
 */

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**
     * 开户
     *
     * @param balance
     * @return 开户后的账号ID
     */
    @RequestMapping("/openaccount/{balance}")
    private String OpenAccount(@PathVariable("balance") String balance) {
        Accounts accounts = new Accounts();
        if (StringUtils.isEmpty(balance) || Double.valueOf(balance) < 0) {
            return "参数不合法";
        }
        Integer acountId = accountService.openAccount(accounts, Double.valueOf(balance));
        return "账号ID为：" + acountId;
    }

    /**
     * 取钱
     *
     * @param id
     * @param money
     * @return
     */
    @RequestMapping("/withdrawmoney/{id}/{money}")
    private String withdrawMoney(@PathVariable("id") String id, @PathVariable("money") String money) {
        Accounts accounts = new Accounts();
        accounts.setAccountId(Integer.parseInt(id));
        Accounts accounts1 = accountService.withdrow(accounts, OpTypes.withdraw.getName(), Double.valueOf(money), null);
        return accounts1.toString();
    }

    /**
     * 存钱
     *
     * @param id
     * @param money
     * @return
     */
    @RequestMapping("/savemoney/{id}/{money}")
    private String saveMoney(@PathVariable("id") String id, @PathVariable("money") String money) {
        Accounts accounts = new Accounts();
        accounts.setAccountId(Integer.parseInt(id));
        Accounts accounts1 = accountService.deposite(accounts, OpTypes.deposite.getName(), Double.valueOf(money), null);
        return accounts1.toString();
    }

    /**
     * 交易
     *
     * @param id1
     * @param id2
     * @param money
     * @return
     */
    @RequestMapping("/tran/{id1}/{id2}/{money}")
    private String transaction(@PathVariable("id1") String id1,
                               @PathVariable("id2") String id2,
                               @PathVariable("money") String money) {
        Accounts a1 = new Accounts();
        a1.setAccountId(Integer.parseInt(id1));
        Accounts a2 = new Accounts();
        a2.setAccountId(Integer.parseInt(id2));
        Accounts transter = accountService.transter(a1, a2, Double.valueOf(money));
        return transter.toString();
    }

    /**
     * 查询账户
     *
     * @param id
     * @return
     */
    @RequestMapping("/show/{id}")
    private String selectAccount(@PathVariable("id") Integer id) {
        Accounts accounts = new Accounts();
        accounts.setAccountId(id);
        Accounts accounts1 = accountService.showBalance(accounts);
        return accounts1.toString();
    }
}
