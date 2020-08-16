package com.jaytest.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

//     @JacksonXmlElementWrapper：可用于指定List等集合类，外围标签名；
//　　 @JacksonXmlProperty：指定包装标签名，或者指定标签内部属性名；
//　　 @JacksonXmlRootElement：指定生成xml根标签的名字；
//　　 @JacksonXmlText：指定当前这个值，没有xml标签包裹。
@JacksonXmlRootElement(localName ="message")
public class TicketRequest {

    @JacksonXmlElementWrapper(localName ="orderlist")
    @JacksonXmlProperty(localName ="order")
    private List<OrderRequest> orderList;

    @Override
    public String toString() {
        return "TicketRequest_zj01{" +
                "orderList=" + orderList +
                '}';
    }

    public List<OrderRequest> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderRequest> orderList) {
        this.orderList = orderList;
    }

}