package com.jaytest.model;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

//@JacksonXmlRootElement(localName ="response-z0")
public class TiResponse {

    private ProjectResponse DATA; //orderList在外边包了一个TiResponse

    @Override
    public String toString() {
        return "TicketResponse{" +
                "DATA=" + DATA +
                '}';
    }

    @JacksonXmlElementWrapper(localName ="response-z1")
    @JacksonXmlProperty(localName ="order-return2")
    public ProjectResponse getDATA() {
        return DATA;
    }

    public void setDATA(ProjectResponse DATA) {
        this.DATA = DATA;
    }
}