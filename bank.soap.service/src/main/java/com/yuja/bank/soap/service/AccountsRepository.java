package com.yuja.bank.soap.service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import com.bankservice.bankdetails.Account;
import com.bankservice.bankdetails.AccountTransferResult;
import org.springframework.stereotype.Component;

@Component
public class AccountsRepository {
    private static final Map<String, Account> accounts = new HashMap<>();

    @PostConstruct
    public void initData() {
        Account accOne = new Account();
        accOne.setUserId("111");
        accOne.setAccountNo("123123123");
        accOne.setBalance(1000);
        accounts.put(accOne.getAccountNo(), accOne);

        Account accTwo = new Account();
        accTwo.setUserId("111");
        accTwo.setAccountNo("456456456");
        accTwo.setBalance(2000);
        accounts.put(accTwo.getAccountNo(), accTwo);

        Account accThree = new Account();
        accThree.setUserId("222");
        accThree.setAccountNo("789789789");
        accThree.setBalance(2320);
        accounts.put(accThree.getAccountNo(), accThree);

        Account accFour = new Account();
        accFour.setUserId("333");
        accFour.setAccountNo("567567567");
        accFour.setBalance(1230);
        accounts.put(accFour.getAccountNo(), accFour);
    }

    public Account findAccount(String accountNo) {
        return accounts.get(accountNo);
    }

    public float findAccountBalance(String accountNo){
        return accounts.get(accountNo).getBalance();
    }

    public float findTotalBalancePerUser(String userId){
        float totalBalance = 0f;
        for (Map.Entry<String, Account> entry : accounts.entrySet()) {
            if(entry.getValue().getUserId().equals(userId)){
                totalBalance += entry.getValue().getBalance();
            }
        }
        return totalBalance;
    }

    public AccountTransferResult transferToOwnAccount(String userId, String fromAccountNo, String toAccountNo, float transferAmount){
        Account fromAccount = findAccount(fromAccountNo);
        Account toAccount = findAccount(toAccountNo);
        AccountTransferResult transferResult = new AccountTransferResult();
        if(fromAccount.getUserId().equals(userId)){
            if(toAccount.getUserId().equals(userId)) {
                if (fromAccount.getBalance() >= transferAmount) {
                    toAccount.setBalance(toAccount.getBalance() + transferAmount);
                    fromAccount.setBalance(fromAccount.getBalance() - transferAmount);
                    accounts.remove(fromAccount.getAccountNo());
                    accounts.remove(toAccount.getAccountNo());
                    accounts.put(fromAccount.getAccountNo(), fromAccount);
                    accounts.put(toAccount.getAccountNo(), toAccount);
                    transferResult.setFromAccount(fromAccount);
                    transferResult.setToAccount(toAccount);
                    transferResult.setTransferState("Transaction Successful");
                }
                else {
                    transferResult.setTransferState("Account balance in account " + fromAccount.getAccountNo() + " is insufficient");
                }
            }
            else{
                transferResult.setTransferState("Cannot find destination account number " + toAccountNo + " under the user " + userId);
            }
        }
        else{
            transferResult.setTransferState("Cannot find origin account number " + fromAccountNo + " under the user " + userId);
        }
        return transferResult;
    }

    public AccountTransferResult transferToOtherAccount(String userId, String fromAccountNo, String toAccountNo, float transferAmount){
        Account fromAccount = findAccount(fromAccountNo);
        Account toAccount = findAccount(toAccountNo);
        AccountTransferResult transferResult = new AccountTransferResult();
        if(fromAccount.getUserId().equals(userId)){
            if (fromAccount.getBalance() >= transferAmount) {
                toAccount.setBalance(toAccount.getBalance() + transferAmount);
                fromAccount.setBalance(fromAccount.getBalance() - transferAmount);
                accounts.remove(fromAccount.getAccountNo());
                accounts.remove(toAccount.getAccountNo());
                accounts.put(fromAccount.getAccountNo(), fromAccount);
                accounts.put(toAccount.getAccountNo(), toAccount);
                transferResult.setFromAccount(fromAccount);
                transferResult.setToAccount(toAccount);
                transferResult.setTransferState("Transaction Successful");
            }
            else {
                transferResult.setTransferState("Account balance in account " + fromAccount.getAccountNo() + " is insufficient");
            }
        }
        else{
            transferResult.setTransferState("Cannot find origin account number " + fromAccountNo + " under the user " + userId);
        }
        return transferResult;
    }
}