package com.yuja.bank.rest.service.services;

import com.bankservice.bankdetails.*;
import org.audit4j.core.annotation.Audit;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Audit(action = "AccountService.getAccount")
    public Account getAccount(String accountNo){
        AccountsPortService accountSoapService = new AccountsPortService();
        GetAccountRequest accRequest = new GetAccountRequest();
        accRequest.setAccountNo(accountNo);
        GetAccountResponse accResponse = accountSoapService.getAccountsPortSoap11().getAccount(accRequest);
        return accResponse.getAccount();
    }

    @Audit(action = "AccountService.getBalancePerUser")
    public float getBalancePerUser(String userId){
        AccountsPortService accountSoapService = new AccountsPortService();
        GetAccountBalancePerUserRequest accBalancePerUserRequest = new GetAccountBalancePerUserRequest();
        accBalancePerUserRequest.setUserId(userId);
        GetAccountBalancePerUserResponse accBalancePerUserResponse = accountSoapService.getAccountsPortSoap11().getAccountBalancePerUser(accBalancePerUserRequest);
        return accBalancePerUserResponse.getBalance();
    }

    @Audit(action = "AccountService.transferToOwnAccount")
    public AccountTransferResult transferToOwnAccount(String userId, String fromAccount, String toAccount, float amount){
        AccountsPortService accountSoapService = new AccountsPortService();
        TransferToOwnAccountRequest transferOwnRequest = new TransferToOwnAccountRequest();
        transferOwnRequest.setUserId(userId);
        transferOwnRequest.setFromAccountNo(fromAccount);
        transferOwnRequest.setToAccountNo(toAccount);
        transferOwnRequest.setTransferAmount(amount);
        TransferToOwnAccountResponse transferOwnResponse = accountSoapService.getAccountsPortSoap11().transferToOwnAccount(transferOwnRequest);
        return transferOwnResponse.getAccountTransferResult();
    }

    @Audit(action = "AccountService.transferToOtherAccount")
    public AccountTransferResult transferToOtherAccount(String userId, String fromAccount, String toAccount, float amount){
        AccountsPortService accountSoapService = new AccountsPortService();
        TransferToOtherAccountRequest transferOtherRequest = new TransferToOtherAccountRequest();
        transferOtherRequest.setUserId(userId);
        transferOtherRequest.setFromAccountNo(fromAccount);
        transferOtherRequest.setToAccountNo(toAccount);
        transferOtherRequest.setTransferAmount(amount);
        TransferToOtherAccountResponse transferOtherResponse = accountSoapService.getAccountsPortSoap11().transferToOtherAccount(transferOtherRequest);
        return transferOtherResponse.getAccountTransferResult();
    }

}
