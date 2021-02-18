package com.yuja.bank.rest.service.controller;


import com.bankservice.bankdetails.Account;
import com.bankservice.bankdetails.AccountTransferResult;
import com.yuja.bank.rest.service.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/coreBankIntegrator")
public class AccountsRestController {
    @Autowired
    AccountService accountService;

    @GetMapping("/getAccountBalance/{accountNo}")
    public ResponseEntity<Float> getAccountBalance(@PathVariable(value = "accountNo") String accountNo) {
        try {
            Account account = accountService.getAccount(accountNo);
            return new ResponseEntity<>(account.getBalance(), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAccount/{accountNo}")
    public ResponseEntity<Account> getAccount(@PathVariable(value = "accountNo") String accountNo) {
        try {
            Account account = accountService.getAccount(accountNo);
            return new ResponseEntity<>(account, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/getAccountBalancePerUser/{userId}")
    public ResponseEntity<Float> getAccountBalancePerUser(@PathVariable(value = "userId") String userId) {
        try {
            float balancePerUser = accountService.getBalancePerUser(userId);
            return new ResponseEntity<>(balancePerUser, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/transferToOwnAccount/{userId}/{fromAccount}/{toAccount}/{amount}")
    public ResponseEntity<AccountTransferResult> transferToOwnAccount(@PathVariable(value = "userId") String userId,
                                                      @PathVariable(value = "fromAccount") String fromAccount,
                                                      @PathVariable(value = "toAccount") String toAccount,
                                                      @PathVariable(value = "amount") float amount) {
        try {
            AccountTransferResult transferResult = accountService.transferToOwnAccount(userId, fromAccount, toAccount, amount);
            return new ResponseEntity<>(transferResult, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/transferToOtherAccount/{userId}/{fromAccount}/{toAccount}/{amount}")
    public ResponseEntity<AccountTransferResult> transferToOtherAccount(@PathVariable(value = "userId") String userId,
                                                                      @PathVariable(value = "fromAccount") String fromAccount,
                                                                      @PathVariable(value = "toAccount") String toAccount,
                                                                      @PathVariable(value = "amount") float amount) {
        try {
            AccountTransferResult transferResult = accountService.transferToOtherAccount(userId, fromAccount, toAccount, amount);
            return new ResponseEntity<>(transferResult, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
