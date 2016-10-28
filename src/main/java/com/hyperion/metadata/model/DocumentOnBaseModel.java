package com.hyperion.metadata.model;


import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "onbase")
public class DocumentOnBaseModel {

    private String policyNumber;
    private String accountNumber;
    private String policyPeriodId;
    private String accountId;
    private Date createdDate;
    private Date modifiedDate;

    public DocumentOnBaseModel(){}

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPolicyPeriodId() {
        return policyPeriodId;
    }

    public void setPolicyPeriodId(String policyPeriodId) {
        this.policyPeriodId = policyPeriodId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
