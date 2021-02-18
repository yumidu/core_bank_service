package com.yuja.bank.soap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.bankservice.bankdetails.GetAccountRequest;
import com.bankservice.bankdetails.GetAccountResponse;
import com.bankservice.bankdetails.GetAccountBalanceRequest;
import com.bankservice.bankdetails.GetAccountBalanceResponse;
import com.bankservice.bankdetails.GetAccountBalancePerUserRequest;
import com.bankservice.bankdetails.GetAccountBalancePerUserResponse;
import com.bankservice.bankdetails.TransferToOwnAccountRequest;
import com.bankservice.bankdetails.TransferToOwnAccountResponse;
import com.bankservice.bankdetails.TransferToOtherAccountResponse;
import com.bankservice.bankdetails.TransferToOtherAccountRequest;

@Endpoint
public class AccountEndPoint {
    private static final String NAMESPACE_URI = "http://bankservice.com/bankdetails";

    private AccountsRepository accountsRepository;

    @Autowired
    public AccountEndPoint(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAccountRequest")
    @ResponsePayload
    public GetAccountResponse getAccount(@RequestPayload GetAccountRequest request) {
        GetAccountResponse response = new GetAccountResponse();
        response.setAccount(accountsRepository.findAccount(request.getAccountNo()));

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAccountBalanceRequest")
    @ResponsePayload
    public GetAccountBalanceResponse getAccountBalance(@RequestPayload GetAccountBalanceRequest request) {
        GetAccountBalanceResponse response = new GetAccountBalanceResponse();
        response.setBalance(accountsRepository.findAccountBalance(request.getAccountNo()));

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAccountBalancePerUserRequest")
    @ResponsePayload
    public GetAccountBalancePerUserResponse getAccountBalancePerUser(@RequestPayload GetAccountBalancePerUserRequest request) {
        GetAccountBalancePerUserResponse response = new GetAccountBalancePerUserResponse();
        response.setBalance(accountsRepository.findTotalBalancePerUser(request.getUserId()));

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "transferToOwnAccountRequest")
    @ResponsePayload
    public TransferToOwnAccountResponse transferToOwnAccount(@RequestPayload TransferToOwnAccountRequest request) {
        TransferToOwnAccountResponse response = new TransferToOwnAccountResponse();
        response.setAccountTransferResult(accountsRepository.transferToOwnAccount(request.getUserId(), request.getFromAccountNo(), request.getToAccountNo(), request.getTransferAmount()));

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "transferToOtherAccountRequest")
    @ResponsePayload
    public TransferToOtherAccountResponse transferToOtherAccount(@RequestPayload TransferToOtherAccountRequest request) {
        TransferToOtherAccountResponse response = new TransferToOtherAccountResponse();
        response.setAccountTransferResult(accountsRepository.transferToOtherAccount(request.getUserId(), request.getFromAccountNo(), request.getToAccountNo(), request.getTransferAmount()));

        return response;
    }
}