package com.jaytest.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName ="response")
public class ProjectResponse {

    private String code;

    private String data;

    @Override
    public String toString() {
        return "ProjectResponse{" +
                "code='" + code + '\'' +
                ", data='" + data + '\'' +
                '}';
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


//    public ProjectResponse() {
//    }
//
//    public ProjectResponse(String code, String data) {
//        this.code = code;
//        this.data = data;
//    }

//    @Override
//    public String toString() {
//        return "ProjectResponse-zzj{" +
//                "code='" + code + '\'' +
//                ", data='" + data + '\'' +
//                '}';
//    }
//
//    @JacksonXmlProperty(localName = "code")
//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String orderId) {
//        this.code = code;
//    }
//
//
//    @JacksonXmlProperty(localName = "data")
//    public String getData() {
//        return data;
//    }
//
//    public void setData(String orderId) {
//        this.data = data;
//    }
}