package com.wu.controller;

import com.wu.pojo.Accounts;
import com.wu.pojo.OpTypes;
import com.wu.service.AccountService;
import com.wu.vo.AccountVO;
import com.wu.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 吴磊
 * @program: testspring
 * @create: 2021-04-18 20:34
 */

@RestController
@Slf4j
public class AccountController {

    @Autowired
    private AccountService accountService;


    /**
     * 开户
     *
     * @return 开户后的账号sFsID
     */
    @RequestMapping(value = "/open/{money}", method = {RequestMethod.GET, RequestMethod.POST})
    private ResultVO OpenAccount(AccountVO accountVO) {
        ResultVO<Object> resultVO = new ResultVO<>();
        try {
            Accounts accounts = new Accounts();
            Integer acountId = accountService.openAccount(accounts, Double.valueOf(accountVO.getMoney()));
            accounts.setAccountId(acountId);
            accounts.setBalance(accountVO.getMoney());
            resultVO.setCode(1);
            resultVO.setData(accounts);
        } catch (Exception e) {
            e.printStackTrace();
            resultVO.setCode(0);
            resultVO.setMsg(e.getMessage());
        }
        return resultVO;
    }

    /**
     * 取钱
     *
     * @return
     */
    @RequestMapping(value = "/withdraw/{AccountId}/{money}", method = {RequestMethod.GET, RequestMethod.POST})
    private ResultVO withdrawMoney(AccountVO accountVO) {
        ResultVO<Object> ro = new ResultVO<>();
        try {
            Accounts accounts = new Accounts();
            accounts.setAccountId(accountVO.getAccountId());
            Accounts accounts1 = accountService.withdrow(accounts, OpTypes.withdraw.getName(), Double.valueOf(accountVO.getMoney()), null);
            ro.setCode(1);
            ro.setData(accounts1);
        } catch (Exception e) {
            ro.setCode(0);
            ro.setMsg(e.getMessage());
        }
        return ro;
    }

    /**
     * 存钱
     *
     * @return
     */
    @RequestMapping("/save/{AccountId}/{money}")
    private ResultVO saveMoney(AccountVO accountVO) {
        ResultVO<Object> ro = new ResultVO<>();
        try {
            Accounts accounts = new Accounts();
            accounts.setAccountId(accountVO.getAccountId());
            Accounts deposite = accountService.deposite(accounts, OpTypes.deposite.getName(), Double.valueOf(accountVO.getMoney()), null);
            ro.setCode(1);
            ro.setData(deposite);
        } catch (Exception e) {
            ro.setCode(0);
            ro.setMsg(e.getMessage());
        }
        return ro;
    }

    /**
     * 交易
     *
     * @return
     */
    @RequestMapping(value = "/tran/{AccountId}/{money}/{inAccountId}", method = {RequestMethod.POST, RequestMethod.GET})
    private ResultVO transaction(AccountVO accountVO) {
        ResultVO<Object> ro = new ResultVO<>();
        try {
            Accounts a1 = new Accounts();
            a1.setAccountId(accountVO.getAccountId());
            Accounts a2 = new Accounts();
            a2.setAccountId(accountVO.getInAccountId());
            Accounts transter = accountService.transter(a2, a1, accountVO.getMoney());
            ro.setCode(1);
            ro.setData(transter);
        } catch (Exception e) {
            ro.setCode(0);
            ro.setMsg(e.getMessage());
        }
        return ro;
    }

    /**
     * 查询账户
     *
     * @return
     */
    @RequestMapping(value = "/select/{AccountId}", method = {RequestMethod.GET, RequestMethod.POST})
    private ResultVO selectAccount(AccountVO accountVO) {
        ResultVO<Object> ro = new ResultVO<>();
        try {
            Accounts accounts = new Accounts();
            accounts.setAccountId(accountVO.getAccountId());
            Accounts accounts1 = accountService.showBalance(accounts);
            ro.setCode(1);
            ro.setData(accounts1);
        } catch (Exception e) {
            ro.setCode(0);
            ro.setMsg(e.getMessage());
        }
        return ro;
    }
}
