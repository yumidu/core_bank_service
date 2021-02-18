package com.yuja.bank.soap.service.test;

import com.bankservice.bankdetails.Account;
import com.bankservice.bankdetails.AccountTransferResult;
import com.yuja.bank.soap.service.AbstractTest;
import com.yuja.bank.soap.service.AccountsRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CoreBankServiceTest extends AbstractTest {
    @Autowired
    private AccountsRepository accountsRepo;

    @Before
    public void setUp(){
        accountsRepo.initData();
    }
    @After
    public void TearDown(){
        accountsRepo.initData();
    }
    @Test
    public void testFindAccount() {

        String accountNo = new String("123123123");

        Account entity = accountsRepo.findAccount(accountNo);

        Assert.assertNotNull("failure - expected not null", entity);
        Assert.assertEquals("failure - expected account_no attribute match", accountNo, entity.getAccountNo());

    }

    @Test
    public void testFindAccountBalance() {

        String accountNo = new String("123123123");
        float expectedBalance = 1000;

        float entity = accountsRepo.findAccountBalance(accountNo);
        Assert.assertEquals("failure - expected balance attribute match", expectedBalance, entity, 0);

    }

    @Test
    public void testFindTotalBalancePerUser() {

        String userId = new String("111");
        float expectedBalance = 3000;

        float entity = accountsRepo.findTotalBalancePerUser(userId);
        Assert.assertEquals("failure - expected balance attribute match", expectedBalance, entity, 0);

    }

    @Test
    public void testTransferToOwnAccount() {

        String userId = new String("111");
        String fromAccountNo = new String("123123123");
        String toAccountNo = new String("456456456");
        float transferAmount = 10;

        AccountTransferResult entity = accountsRepo.transferToOwnAccount(userId, fromAccountNo, toAccountNo, transferAmount);
        float expectedBalanceFromAccount = 990;
        float expectedBalanceToAccount = 2010;

        Assert.assertNotNull("failure - expected not null", entity);
        Assert.assertEquals("failure - expected from account balance attribute match", expectedBalanceFromAccount, entity.getFromAccount().getBalance(), 0);
        Assert.assertEquals("failure - expected to account balance attribute match", expectedBalanceToAccount, entity.getToAccount().getBalance(), 0);
        Assert.assertEquals("failure - Successful Transaction expected", "Transaction Successful", entity.getTransferState());
    }

    @Test
    public void testTransferToOtherAccount() {

        String userId = new String("111");
        String fromAccountNo = new String("456456456");
        String toAccountNo = new String("789789789");
        float transferAmount = 10;

        AccountTransferResult entity = accountsRepo.transferToOtherAccount(userId, fromAccountNo, toAccountNo, transferAmount);
        float expectedBalanceFromAccount = 1990;
        float expectedBalanceToAccount = 2330;

        Assert.assertNotNull("failure - expected not null", entity);
        Assert.assertEquals("failure - expected from account balance attribute match", expectedBalanceFromAccount, entity.getFromAccount().getBalance(), 0);
        Assert.assertEquals("failure - expected to account balance attribute match", expectedBalanceToAccount, entity.getToAccount().getBalance(), 0);
        Assert.assertEquals("failure - Successful Transaction expected", "Transaction Successful", entity.getTransferState());
    }


}
