package com.vanannek.companycrud.service;

import com.vanannek.companycrud.entity.Account;

public interface AccountService {
    void addAcc(Account acc);

    void updateAcc(Long empId, Account account);

    void deleteAcc(Long empId);

    Account getAcc(Long empId);

    Account findByUsername(String username);
}
