package com.xu.dao;

import com.xu.po.Account;

public interface AccountDao {
    Account findAccountById(int id) throws Exception;

    Account findAccountByName(String username) throws Exception;
}
