package com.jaytest.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

public class ProjectRequest {
    private String PROJ_ID;
    private String PROJ_CODE;
    private String PROJ_NAME;
    private String PROJ_SNAME;
    private String OGN_ID;
    private String OGN_CODE;

    @Override
    public String toString() {
        return "ProjectRequest{" +
                "PROJ_ID='" + PROJ_ID + '\'' +
                ", PROJ_CODE='" + PROJ_CODE + '\'' +
                ", PROJ_NAME='" + PROJ_NAME + '\'' +
                ", PROJ_SNAME='" + PROJ_SNAME + '\'' +
                ", OGN_ID='" + OGN_ID + '\'' +
                ", OGN_CODE='" + OGN_CODE + '\'' +
                '}';
    }

    @JacksonXmlProperty(localName = "OGN_CODE")
    public String getOGN_CODE() {
        return OGN_CODE;
    }

    public void setOGN_CODE(String OGN_CODE) {
        this.OGN_CODE = OGN_CODE;
    }

    @JacksonXmlProperty(localName = "OGN_ID")
    public String getOGN_ID() {
        return OGN_ID;
    }

    public void setOGN_ID(String OGN_ID) {
        this.OGN_ID = OGN_ID;
    }

    @JacksonXmlProperty(localName = "PROJ_SNAME")
    public String getPROJ_SNAME() {
        return PROJ_SNAME;
    }

    public void setPROJ_SNAME(String PROJ_SNAME) {
        this.PROJ_SNAME = PROJ_SNAME;
    }

    @JacksonXmlProperty(localName = "PROJ_NAME")
    public String getPROJ_NAME() {
        return PROJ_NAME;
    }

    public void setPROJ_NAME(String PROJ_NAME) {
        this.PROJ_NAME = PROJ_NAME;
    }

    @JacksonXmlProperty(localName = "PROJ_CODE")
    public String getPROJ_CODE() {
        return PROJ_CODE;
    }

    public void setPROJ_CODE(String PROJ_CODE) {
        this.PROJ_CODE = PROJ_CODE;
    }

    @JacksonXmlProperty(localName = "PROJ_ID")
    public String getPROJ_ID() {
        return PROJ_ID;
    }

    public void setPROJ_ID(String PROJ_ID) {
        this.PROJ_ID = PROJ_ID;
    }



}
