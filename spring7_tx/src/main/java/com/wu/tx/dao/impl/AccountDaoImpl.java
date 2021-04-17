package com.wu.tx.dao.impl;

import com.wu.tx.Bean.Accounts;
import com.wu.tx.dao.AccountsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;

/**
 * @author: 吴磊
 * @program: testspring
 * @create: 2021-04-14 20:27
 */
@Repository
public class AccountDaoImpl implements AccountsDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public int saveAccount(Accounts account) {
        String sql = "insert into accounts(balance) values (?)";
        //利用KeyHolder获取新增的这条数据的id数据
        KeyHolder keyHolder = new GeneratedKeyHolder();//生成键的保存器
        //connection由Spring调用的时候注入
        jdbcTemplate.update(connection -> {
            //哟指定表中是哪个列为 主键生成列
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"accountid"});//第二个参数的意思是返回这个字段生成的键
            ps.setString(1, "1");
            return ps;
        }, keyHolder);
        Number key = keyHolder.getKey();

        return key.intValue();
    }

    @Override
    public Accounts updateAccount(Accounts account) {
        String sql = "update accounts set balance = ? where accountid = ?";
        this.jdbcTemplate.update(sql, account.getBalance(), account.getAccountId());
        return account;
    }

    @Override
    public Accounts findAccount(int accountId) {
        String sql = "select * from accounts where accountid = ?";
        Accounts accounts1 = jdbcTemplate.queryForObject(sql, (rs, row) -> {
            Accounts accounts = new Accounts();
            accounts.setAccountId(rs.getInt("ACCOUNTID"));
            accounts.setBalance(rs.getInt("BALANCE"));
            return accounts;
        }, 1);

        return accounts1;
    }

    @Override
    public List<Accounts> findAll() {
        String sql = "select * from accounts";
        List<Accounts> query = jdbcTemplate.query(sql, (resultSet, rowNum) -> {
            Accounts accounts = new Accounts();
            accounts.setAccountId(resultSet.getInt("ACCOUNTID"));
            accounts.setBalance(resultSet.getInt("BALANCE"));
            return accounts;
        });
        return query;
    }

    @Override
    public void delete(int accountId) {
        String sql = "delete from accounts where accountid = ?";
        jdbcTemplate.update(sql, accountId);
    }
}
