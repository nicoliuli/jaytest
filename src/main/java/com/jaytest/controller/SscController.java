package com.jaytest.controller;

import lombok.extern.slf4j.Slf4j;
import com.jaytest.model.OrderResponse;
import com.jaytest.model.TicketRequest;
import com.jaytest.model.TicketResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class SscController {

    @Override
    public String toString() {
        return "SscController{}";
    }

    @PostMapping(value = "/test", consumes = { MediaType.APPLICATION_XML_VALUE }, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public TicketResponse test(@RequestBody TicketRequest ticketRequest){
//        ********************************************** 响应 **********************************************
        TicketResponse ticketResponse=new TicketResponse();
        List<OrderResponse> orderszzj=new ArrayList<OrderResponse>(); //数组
        OrderResponse o=new OrderResponse();
        o.setMsg("投注成功");
        o.setOrderId("zzjj");
        o.setSysId("22222233333");
        o.setErrorCode("success!");

        orderszzj.add(o);
        ticketResponse.setOrderList(orderszzj); //赋值
        log.info("xml！！！请求::" + ticketRequest);
        log.info("xml！！！回复的返回值::" + o);

        return ticketResponse;
    }

}
