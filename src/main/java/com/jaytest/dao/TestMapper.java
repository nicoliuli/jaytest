package com.jaytest.dao;

import com.jaytest.model.ProjectRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper {
	

	public Integer insertTiRequest(ProjectRequest projectRequest);

	public List<ProjectRequest> selProject(ProjectRequest projectRequest);

	public List<ProjectRequest> selpidProject(ProjectRequest projectRequest);

}
