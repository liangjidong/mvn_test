package com.ljd.controller;

import com.ljd.pojo.Account;
import com.ljd.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by author on 17-11-2.
 */
@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Account> list() {
        try {
            return accountService.findAccountList();
        } catch (Exception e) {
            logger.error("调用AccountController.list()出错", e);
            return null;
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Account getById(@PathVariable("id") int id) {
        try {
            return accountService.findAccountById(id);
        } catch (Exception e) {
            logger.error("调用AccountController.getById()出错", e);
            return null;
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") int id) {
        try {
            int result = accountService.delete(id);
            if (result == 1) {
                return "success";
            }
            return "fail";
        } catch (Exception e) {
            logger.error("调用AccountController.delete()出错", e);
            return null;
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateAccount(@PathVariable("id") int id, @RequestParam(value = "name", required = true) String name, @RequestParam(value = "money", required = true) long money) {
        try {
            Account account = new Account();
            account.setId(id);
            account.setName(name);
            account.setMoney(money);
            int result = accountService.update(account);
            if (result == 1) {
                return "success";
            }
            return "fail";
        } catch (Exception e) {
            logger.error("调用AccountController.updateAccount()出错", e);
            return null;
        }

    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addAccount(@RequestParam(value = "name", required = true) String name, @RequestParam(value = "money", required = true) long money) {
        try {
            Account account = new Account();
            account.setName(name);
            account.setMoney(money);
            int result = accountService.add(account);
            if (result == 1) {
                return "success";
            }
            return "fail";
        } catch (Exception e) {
            logger.error("调用AccountController.addAccount()出错", e);
            return null;
        }

    }
}
