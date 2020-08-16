package com.jaytest.model;


import java.util.List;
import com.fasterxml.jackson.dataformat.xml.annotation.*;

@JacksonXmlRootElement(localName ="message")
public class TicketResponse {

    private List<OrderResponse> orderList; //orderList在外边包了一个TicketResponse

    @JacksonXmlElementWrapper(localName ="orderlist-return1")
    @JacksonXmlProperty(localName ="order-return2")
    public List<OrderResponse> getOrderList() {
        return orderList;
    }

    @Override
    public String toString() {
        return "TicketResponse{" +
                "orderList=" + orderList +
                '}';
    }

    public void setOrderList(List<OrderResponse> orderList) {
        this.orderList = orderList;
    }
}