package com.hyperion.metadata.dto;

import java.util.Date;

public class PolicyDocumentsDTO {
    private int docID;
    private String accountNumber;
    private String policyNumber;
    private String guidEnvelopeId;
    private Date createdDateTime;

    public int getDocID() {
        return docID;
    }

    public void setDocID(int docID) {
        this.docID = docID;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getGuidEnvelopeId() {
        return guidEnvelopeId;
    }

    public void setGuidEnvelopeId(String guidEnvelopeId) {
        this.guidEnvelopeId = guidEnvelopeId;
    }

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
    }
}
