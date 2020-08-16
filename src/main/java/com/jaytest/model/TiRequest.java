package com.jaytest.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

//     @JacksonXmlElementWrapper：可用于指定List等集合类，外围标签名；
//　　 @JacksonXmlProperty：指定包装标签名，或者指定标签内部属性名；
//　　 @JacksonXmlRootElement：指定生成xml根标签的名字；
//　　 @JacksonXmlText：指定当前这个值，没有xml标签包裹。
@JacksonXmlRootElement(localName ="NXSME")
@Slf4j
public class TiRequest {

    @JacksonXmlElementWrapper(localName ="DATA")
    @JacksonXmlProperty(localName ="ROW_INFO")
    private List<ProjectRequest> DATA; //数组--列表

    @Override
    public String toString() {
        return "TiRequest_zj01{" +
                "orderList=" + DATA +
                '}';
    }

    public List<ProjectRequest> getDATA() {
        return DATA;
    }

    public void setDATA(List<ProjectRequest> DATA) {
        this.DATA = DATA;
    }

}