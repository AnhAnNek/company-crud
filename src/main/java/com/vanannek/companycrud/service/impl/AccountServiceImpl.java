package com.vanannek.companycrud.service.impl;

import com.vanannek.companycrud.entity.Account;
import com.vanannek.companycrud.repository.AccountRepository;
import com.vanannek.companycrud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository repos;

    @Override
    public Account addAcc(Account acc) {
        try
        {
            return repos.save(acc);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Account updateAcc(Long empId, Account acc) {
        repos
            .findById(empId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user id =" + empId));
        acc.setEmpId(empId);

        return repos.save(acc);
    }

    @Override
    public boolean deleteAcc(Long empId) {
        Optional<Account> optAcc = repos.findById(empId);

        if(optAcc.isEmpty())
            return false;

        try
        {
            Account acc = optAcc.get();
            repos.delete(acc);
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Account getAcc(Long empId) {
        return repos
                .findById(empId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user id =" + empId));
    }

    @Override
    public Account findByUsername(String username) {
        return repos
                .findByUsername(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found username=" + username));
    }
}
