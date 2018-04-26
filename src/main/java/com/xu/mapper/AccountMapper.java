package com.xu.mapper;

import com.xu.po.Account;
import com.xu.vo.AccountVo;

import java.util.List;

public interface AccountMapper {
    List<Account> findAccountList(AccountVo accountVo) throws Exception;
}
