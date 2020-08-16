package com.jaytest.dao;

import com.jaytest.model.ProjectRequest;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper {
	

	public Integer insertTiRequest(ProjectRequest projectRequest);


}
