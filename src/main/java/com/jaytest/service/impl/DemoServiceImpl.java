package com.jaytest.service.impl;

import com.jaytest.dao.DemoMapper;
import com.jaytest.model.Demo;
import com.jaytest.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 实现类
 */
@Service("demoService")
public class DemoServiceImpl implements DemoService {

    /**
     *
     */
    public void addDemo(Demo demo){
        // 业务逻辑 开始


        // 写数据库
        demoMapper.addDemo(demo);
        //业务逻辑结束
    }


    public Integer updateDemo(Demo demo){

        Integer integer = demoMapper.updateDemo(demo);
        return integer;
    }

    @Override
    public List<Demo> queryDemo(Demo demo) {
        return demoMapper.queryDemo(demo);
    }

    @Override
    public Demo getDemo(Integer id) {
        return demoMapper.getDemo(id);
    }

    @Override
    public Demo delDemo(Integer id){ return  demoMapper.delDemo(id); }

    //  @Resource(name = "demodao")
  //  private DemoDao demoDao;// = new DemoDaoImpl();

    @Autowired
    private DemoMapper demoMapper;
}
