package com.ljd.service;

import com.ljd.pojo.Account;

import java.util.List;

/**
 * Created by author on 17-11-2.
 */
public interface AccountService {
    int add(Account account);
    int update(Account account);
    int delete(int id);
    Account findAccountById(int id);
    List<Account> findAccountList();
}
