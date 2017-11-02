package com.ljd.dao;

import com.ljd.pojo.Account;

import java.util.List;

/**
 * Created by author on 17-11-2.
 */
public interface AccountDAO {
    int add(Account account);

    int update(Account account);

    int delete(int id);

    Account findAccountById(int id);

    List<Account> findAccountList();
}
