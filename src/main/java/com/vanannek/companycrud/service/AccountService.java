package com.vanannek.companycrud.service;

import com.vanannek.companycrud.entity.Account;

public interface AccountService {
    Account addAcc(Account acc);

    Account updateAcc(Long empId, Account account);

    boolean deleteAcc(Long empId);

    Account getAcc(Long empId);

    Account findByUsername(String username);
}
