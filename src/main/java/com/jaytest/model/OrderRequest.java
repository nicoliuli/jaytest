package com.jaytest.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class OrderRequest {
    private String lotteryType;
    private String phase;
    private String orderid;
    private String playtype;
    private String betcode;
    private String multiple;
    private String amount;

    @JacksonXmlProperty(localName = "lotterytype")
    public String getLotteryType() {
        return lotteryType;
    }

    public void setLotteryType(String lotteryType) {
        this.lotteryType = lotteryType;
    }

    @JacksonXmlProperty(localName = "phase")
    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "lotteryType='" + lotteryType + '\'' +
                ", phase='" + phase + '\'' +
                ", orderid='" + orderid + '\'' +
                ", playtype='" + playtype + '\'' +
                ", betcode='" + betcode + '\'' +
                ", multiple='" + multiple + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }

    @JacksonXmlProperty(localName = "orderid")
    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }


    @JacksonXmlProperty(localName = "playtype")
    public String getPlaytype() {
        return playtype;
    }

    public void setPlaytype(String playtype) {
        this.playtype = playtype;
    }

    @JacksonXmlProperty(localName = "betcode")
    public String getBetcode() {
        return betcode;
    }

    public void setBetcode(String betcode) {
        this.betcode = betcode;
    }

    @JacksonXmlProperty(localName = "multiple")
    public String getMultiple() {
        return multiple;
    }

    public void setMultiple(String multiple) {
        this.multiple = multiple;
    }

    @JacksonXmlProperty(localName = "amount")
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}