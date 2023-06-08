package com.vanannek.companycrud.controler;

import com.vanannek.companycrud.entity.Account;
import com.vanannek.companycrud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private AccountService accService;

    @PostMapping("/add")
    public String addAcc(@RequestBody Account acc) {
        accService.addAcc(acc);
        return "success add employee";
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<Void> updateAcc(@PathVariable Long empId, @RequestBody Account acc) {
        accService.updateAcc(empId, acc);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<Void> deleteAcc(@PathVariable Long empId) {
        accService.deleteAcc(empId);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get")
    public Account getAcc(@RequestParam Long empId) {
        return accService.getAcc(empId);
    }

    @GetMapping("/get/{username}")
    public Account searchByUsername(@PathVariable String username) {
        return accService.findByUsername(username);
    }
}
