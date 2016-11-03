package com.hyperion.metadata.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Document(collection = "claims")
public class CCDocumentModel {

    @Id
    private int docID;
    private String claimNumber;
    private String claim;
    private String author;
    private String documentType;
    private String documentSubType;
    private String mimetype;
    private String name;
    private Date createdDate;
    private Date modifiedDate;
    private String[] contacts;
    private List<Incident> incidentList; // 1 : M (1 Incident : Many Exposures)
    private String matter;
    private String source;

    public CCDocumentModel(){}

    public static class Incident{
        int publicid;
        String displayname;
        List<Exposure> exposureList;

        public int getPublicid() {
            return publicid;
        }

        public void setPublicid(int publicid) {
            this.publicid = publicid;
        }

        public String getDisplayname() {
            return displayname;
        }

        public void setDisplayname(String displayname) {
            this.displayname = displayname;
        }

        public List<Exposure> getExposureList() {
            return exposureList;
        }

        public void setExposureList(List<Exposure> exposureList) {
            this.exposureList = exposureList;
        }
    }

    public static class Exposure{
        int publicid;
        String displayname;

        public int getPublicid() {
            return publicid;
        }

        public void setPublicid(int publicid) {
            this.publicid = publicid;
        }

        public String getDisplayname() {
            return displayname;
        }

        public void setDisplayname(String displayname) {
            this.displayname = displayname;
        }
    }
    public String getMatter() {
        return matter;
    }

    public void setMatter(String matter) {
        this.matter = matter;
    }

    public List<Incident> getIncidentList() {
        return incidentList;
    }

    public void setIncidentList(List<Incident> incidentList) {
        this.incidentList = incidentList;
    }

    private String guidEnvelopeId;

    public String getGuidEnvelopeId() {
        return guidEnvelopeId;
    }

    public void setGuidEnvelopeId(String guidEnvelopeId) {
        this.guidEnvelopeId = guidEnvelopeId;
    }

    public String getClaimId() {
        return claim;
    }

    public void setClaimId(String claimId) {
        this.claim = claimId;
    }


    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getClaimNumber() {
        return claimNumber;
    }

    public void setClaimNumber(String claimNumber) {
        this.claimNumber = claimNumber;
    }

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

    public String getClaim() {
        return claim;
    }

    public void setClaim(String claim) {
        this.claim = claim;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentSubType() {
        return documentSubType;
    }

    public void setDocumentSubType(String documentSubType) {
        this.documentSubType = documentSubType;
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
