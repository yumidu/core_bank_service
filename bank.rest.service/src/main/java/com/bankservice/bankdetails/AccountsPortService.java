package com.bankservice.bankdetails;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.4.2
 * 2021-02-18T11:04:07.313+05:30
 * Generated source version: 3.4.2
 *
 */
@WebServiceClient(name = "AccountsPortService",
                  wsdlLocation = "file:/D:/proj_me/SSE_TASK/core_bank_service/bank.rest.service/src/main/resources/wsdl/corebank.wsdl",
                  targetNamespace = "http://bankservice.com/bankdetails")
public class AccountsPortService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://bankservice.com/bankdetails", "AccountsPortService");
    public final static QName AccountsPortSoap11 = new QName("http://bankservice.com/bankdetails", "AccountsPortSoap11");
    static {
        URL url = null;
        try {
            url = new URL("file:/D:/proj_me/SSE_TASK/core_bank_service/bank.rest.service/src/main/resources/wsdl/corebank.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(AccountsPortService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "file:/D:/proj_me/SSE_TASK/core_bank_service/bank.rest.service/src/main/resources/wsdl/corebank.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public AccountsPortService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public AccountsPortService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AccountsPortService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public AccountsPortService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public AccountsPortService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public AccountsPortService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns AccountsPort
     */
    @WebEndpoint(name = "AccountsPortSoap11")
    public AccountsPort getAccountsPortSoap11() {
        return super.getPort(AccountsPortSoap11, AccountsPort.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AccountsPort
     */
    @WebEndpoint(name = "AccountsPortSoap11")
    public AccountsPort getAccountsPortSoap11(WebServiceFeature... features) {
        return super.getPort(AccountsPortSoap11, AccountsPort.class, features);
    }

}
