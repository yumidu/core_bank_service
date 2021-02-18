
package com.bankservice.bankdetails;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for accountTransferResult complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="accountTransferResult"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="from_account" type="{http://bankservice.com/bankdetails}account"/&amp;gt;
 *         &amp;lt;element name="to_account" type="{http://bankservice.com/bankdetails}account"/&amp;gt;
 *         &amp;lt;element name="transfer_state" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accountTransferResult", propOrder = {
    "fromAccount",
    "toAccount",
    "transferState"
})
public class AccountTransferResult {

    @XmlElement(name = "from_account", required = true)
    protected Account fromAccount;
    @XmlElement(name = "to_account", required = true)
    protected Account toAccount;
    @XmlElement(name = "transfer_state", required = true)
    protected String transferState;

    /**
     * Gets the value of the fromAccount property.
     * 
     * @return
     *     possible object is
     *     {@link Account }
     *     
     */
    public Account getFromAccount() {
        return fromAccount;
    }

    /**
     * Sets the value of the fromAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Account }
     *     
     */
    public void setFromAccount(Account value) {
        this.fromAccount = value;
    }

    /**
     * Gets the value of the toAccount property.
     * 
     * @return
     *     possible object is
     *     {@link Account }
     *     
     */
    public Account getToAccount() {
        return toAccount;
    }

    /**
     * Sets the value of the toAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Account }
     *     
     */
    public void setToAccount(Account value) {
        this.toAccount = value;
    }

    /**
     * Gets the value of the transferState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransferState() {
        return transferState;
    }

    /**
     * Sets the value of the transferState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransferState(String value) {
        this.transferState = value;
    }

}
