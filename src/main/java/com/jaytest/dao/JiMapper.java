package com.jaytest.dao;

import java.util.List;

import com.jaytest.model.Ji;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JiMapper {


    public Ji JigetDemo(Integer id);
    public List<Ji> queryDemo(Ji ji);
}
