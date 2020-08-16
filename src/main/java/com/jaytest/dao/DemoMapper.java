package com.jaytest.dao;

import java.util.List;

import com.jaytest.model.Demo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DemoMapper {
	

	/**
	 * 添加  这是一个接口，-》xml
	 * @param demo
	 * @return
	 */
	public Integer addDemo(Demo demo);

	public Integer updateDemo(Demo demo); //Integer是返回值，修改的行数

	public List<Demo> queryDemo(Demo demo);

	public Demo getDemo(Integer id);

	public Demo delDemo(Integer id);

	

}
