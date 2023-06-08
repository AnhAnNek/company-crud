package com.vanannek.companycrud.service.Impl;

import com.vanannek.companycrud.entity.Account;
import com.vanannek.companycrud.repository.AccountRepository;
import com.vanannek.companycrud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository repos;

    @Override
    public void addAcc(Account acc) {
        repos.save(acc);
    }

    @Override
    public void updateAcc(Long empId, Account acc) {
        repos
            .findById(empId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user id =" + empId));
        acc.setEmpId(empId);

        repos.save(acc);
    }

    @Override
    public void deleteAcc(Long empId) {
        Account acc = repos
                .findById(empId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user id =" + empId));
        acc.setEmpId(empId);

        repos.delete(acc);
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
