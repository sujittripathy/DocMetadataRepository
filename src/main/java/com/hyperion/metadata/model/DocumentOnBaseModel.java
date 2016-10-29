package com.hyperion.metadata.model;

import org.springframework.data.annotation.Id;
import java.util.Date;

public class DocumentOnBaseModel {

    @Id
    private Long docID;
    private String accountNumber;
    private String accountId;
    private String author;
    private String documenttype;
    private String documenttypegroup;
    private String mimetype;
    private String name;
    private String policyNumber;
    private String policyPeriodId;
    private String securitytype;
    private Date createdDate;
    private Date modifiedDate;
    private String[] contacts;

    public DocumentOnBaseModel(){}

    public Long getDocID() {
        return docID;
    }

    public void setDocID(Long docID) {
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

    public String getDocumenttype() {
        return documenttype;
    }

    public void setDocumenttype(String documenttype) {
        this.documenttype = documenttype;
    }

    public String getDocumenttypegroup() {
        return documenttypegroup;
    }

    public void setDocumenttypegroup(String documenttypegroup) {
        this.documenttypegroup = documenttypegroup;
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

    public String getPolicyPeriodId() {
        return policyPeriodId;
    }

    public void setPolicyPeriodId(String policyPeriodId) {
        this.policyPeriodId = policyPeriodId;
    }

    public String getSecuritytype() {
        return securitytype;
    }

    public void setSecuritytype(String securitytype) {
        this.securitytype = securitytype;
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

    public String[] getContacts() {
        return contacts;
    }

    public void setContacts(String[] contacts) {
        this.contacts = contacts;
    }
}
