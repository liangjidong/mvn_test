package com.ljd.dao.impl;

import com.ljd.dao.AccountDAO;
import com.ljd.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by author on 17-11-2.
 */
@Repository
public class AccountDAOImpl implements AccountDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(Account account) {
        String sql = "insert into account(name,money) values(?,?)";
        return jdbcTemplate.update(sql, account.getName(), account.getMoney());
    }

    @Override
    public int update(Account account) {
        String sql = "update account set name=?,money=? where id=?";
        return jdbcTemplate.update(sql, account.getName(), account.getMoney(), account.getId());
    }

    @Override
    public int delete(int id) {
        String sql = "delete from table account where id=?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public Account findAccountById(int id) {
        List<Account> accounts = jdbcTemplate.query("select * from account where id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Account.class));
        if (accounts == null || accounts.size() == 0)
            return null;
        return accounts.get(0);
    }

    @Override
    public List<Account> findAccountList() {
        List<Account> accounts = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<>(Account.class));
        return accounts;
    }
}
