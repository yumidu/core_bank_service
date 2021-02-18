
package com.bankservice.bankdetails;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.bankservice.bankdetails package. 
 * &lt;p&gt;An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.bankservice.bankdetails
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAccountRequest }
     * 
     */
    public GetAccountRequest createGetAccountRequest() {
        return new GetAccountRequest();
    }

    /**
     * Create an instance of {@link GetAccountResponse }
     * 
     */
    public GetAccountResponse createGetAccountResponse() {
        return new GetAccountResponse();
    }

    /**
     * Create an instance of {@link Account }
     * 
     */
    public Account createAccount() {
        return new Account();
    }

    /**
     * Create an instance of {@link GetAccountBalanceRequest }
     * 
     */
    public GetAccountBalanceRequest createGetAccountBalanceRequest() {
        return new GetAccountBalanceRequest();
    }

    /**
     * Create an instance of {@link GetAccountBalanceResponse }
     * 
     */
    public GetAccountBalanceResponse createGetAccountBalanceResponse() {
        return new GetAccountBalanceResponse();
    }

    /**
     * Create an instance of {@link GetAccountBalancePerUserRequest }
     * 
     */
    public GetAccountBalancePerUserRequest createGetAccountBalancePerUserRequest() {
        return new GetAccountBalancePerUserRequest();
    }

    /**
     * Create an instance of {@link GetAccountBalancePerUserResponse }
     * 
     */
    public GetAccountBalancePerUserResponse createGetAccountBalancePerUserResponse() {
        return new GetAccountBalancePerUserResponse();
    }

    /**
     * Create an instance of {@link TransferToOwnAccountRequest }
     * 
     */
    public TransferToOwnAccountRequest createTransferToOwnAccountRequest() {
        return new TransferToOwnAccountRequest();
    }

    /**
     * Create an instance of {@link TransferToOtherAccountRequest }
     * 
     */
    public TransferToOtherAccountRequest createTransferToOtherAccountRequest() {
        return new TransferToOtherAccountRequest();
    }

    /**
     * Create an instance of {@link TransferToOwnAccountResponse }
     * 
     */
    public TransferToOwnAccountResponse createTransferToOwnAccountResponse() {
        return new TransferToOwnAccountResponse();
    }

    /**
     * Create an instance of {@link AccountTransferResult }
     * 
     */
    public AccountTransferResult createAccountTransferResult() {
        return new AccountTransferResult();
    }

    /**
     * Create an instance of {@link TransferToOtherAccountResponse }
     * 
     */
    public TransferToOtherAccountResponse createTransferToOtherAccountResponse() {
        return new TransferToOtherAccountResponse();
    }

}
