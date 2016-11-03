package com.hyperion.metadata.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "policy")
public class PCDocumentModel {

    @Id
    private int docID;
    private String accountNumber;
    private String accountId;
    private String activity;
    private String author;
    private String documentType;
    private String mimetype;
    @Field(value = "documentname")
    private String name;
    private String job;
    private String policy;
    private String policyNumber;
    private String policyperiod;
    private String securitytype;
    private Date createdDateTime;
    private Date modifiedDateTime;
    private String source;
    private String guidEnvelopeId;
    private String uniqueid;
    private int batchNumber;
    private String description;
    private boolean obsolete;
    private String customerID;
    private String eprDocumentType;
    private boolean printsuppression;
    private String spoolID;


    public String getUniqueid() {
        return uniqueid;
    }
    public void setUniqueid(String uniqueid) {
        this.uniqueid = uniqueid;
    }
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }
    public String getCustomerID() {
        return customerID;
    }
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }
    public String getEprDocumentType() {
        return eprDocumentType;
    }
    public void setEprDocumentType(String eprDocumentType) {
        this.eprDocumentType = eprDocumentType;
    }
    public boolean isPrintsuppression() {
        return printsuppression;
    }
    public void setPrintsuppression(boolean printsuppression) {
        this.printsuppression = printsuppression;
    }
    public String getSpoolID() {
        return spoolID;
    }
    public void setSpoolID(String spoolID) {
        this.spoolID = spoolID;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public boolean isObsolete() {
        return obsolete;
    }

    public void setObsolete(boolean obsolete) {
        this.obsolete = obsolete;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(int batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getGuidEnvelopeId() {
        return guidEnvelopeId;
    }

    public void setGuidEnvelopeId(String guidEnvelopeId) {
        this.guidEnvelopeId = guidEnvelopeId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public PCDocumentModel() {
    }

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

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMimetype() {
        return mimetype;
    }

    public void setMimetype(String mimetype) {
        this.mimetype = mimetype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getPolicyperiod() {
        return policyperiod;
    }

    public void setPolicyperiod(String policyperiod) {
        this.policyperiod = policyperiod;
    }

    public String getSecuritytype() {
        return securitytype;
    }

    public void setSecuritytype(String securitytype) {
        this.securitytype = securitytype;
    }

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public Date getModifiedDateTime() {
        return modifiedDateTime;
    }

    public void setModifiedDateTime(Date modifiedDateTime) {
        this.modifiedDateTime = modifiedDateTime;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }


}
