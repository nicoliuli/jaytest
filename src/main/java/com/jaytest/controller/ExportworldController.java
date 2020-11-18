package com.jaytest.controller;

import cn.afterturn.easypoi.word.entity.WordImageEntity;
import com.jaytest.model.ExportWorld;
import com.jaytest.model.HttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
public class ExportworldController {

//    http://localhost:8081/export
    @RequestMapping("export")
    public void export(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String,Object> params = new HashMap<>();
        params.put("tt","集团劳务大数据分析报告（第一期）");
        params.put("title","这是标题");
        params.put("name","李四");

        WordImageEntity image = new WordImageEntity();
        image.setHeight(300);//设置高度
        image.setWidth(500);//设置宽度
        image.setType(WordImageEntity.Data);//类型
        image.setData(image2byte("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1455752348,3050716472&fm=26&gp=0.jpg"));


        params.put("img",image);
        params.put("cont","基于劳务大数据平台实时数据，目前集团内劳务情况分析如下：\n" +
                "\n" +
                "（一）全集团项目数据分析(来源于人工填报周报系统,含市政路桥)。至2020年11月13日， 全集团在施总承包项目1192个（含新开、水利项目，不含养护、专业分包项目）。 其中，京内718个京外474个；如下图：");
        //这里是我说的一行代码
        ExportWorld.exportWord("/Users/zhangjie/Desktop/project/jaytest/logs/modelworld/export.docx","/Users/zhangjie/Desktop/project/jaytest/logs/exportworld","aaa.docx",params,request,response);
    }

    /**
     * 图片转为byte数组
     *
     * @param path
     * @return
     */
    public static byte[] image2byte(String path) throws IOException {
        byte[] data = null;
        URL url = null;
        InputStream input = null;
        try{
            url = new URL(path);
            HttpURLConnection httpUrl = (HttpURLConnection) url.openConnection();
            httpUrl.connect();
            httpUrl.getInputStream();
            input = httpUrl.getInputStream();
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int numBytesRead = 0;
        while ((numBytesRead = input.read(buf)) != -1) {
            output.write(buf, 0, numBytesRead);
        }
        data = output.toByteArray();
        output.close();
        input.close();
        return data;
    }

//    get获取数据
    @RequestMapping("/geturl")
    public String geturl() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "李四");
        String ss = HttpUtils.sendGet("http://10.250.23.56/PC/LaborManagement/public/Send?bz=",1,"123456");
        log.info("ss:::::" + ss);
        return ss;
    }

}
