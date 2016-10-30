package com.hyperion.metadata.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "claims")
public class CCDocumentModel {

    @Id
    private int docID;
    private String claimNumber;
    private String claimId;
    private String author;
    private String documenttype;
    private String documenttypegroup;
    private String mimetype;
    private String name;
    private Date createdDate;
    private Date modifiedDate;
    private String[] contacts;
    private String guidEnvelopeId;

    public String getGuidEnvelopeId() {
        return guidEnvelopeId;
    }

    public void setGuidEnvelopeId(String guidEnvelopeId) {
        this.guidEnvelopeId = guidEnvelopeId;
    }

    public String getClaimId() {
        return claimId;
    }

    public void setClaimId(String claimId) {
        this.claimId = claimId;
    }

    public String[] getIncident() {
        return incident;
    }

    public void setIncident(String[] incident) {
        this.incident = incident;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    private String[] incident;
    private String source;

    public String getClaimNumber() {
        return claimNumber;
    }

    public void setClaimNumber(String claimNumber) {
        this.claimNumber = claimNumber;
    }

    public CCDocumentModel(){}

    public int getDocID() {
        return docID;
    }

    public void setDocID(int docID) {
        this.docID = docID;
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
