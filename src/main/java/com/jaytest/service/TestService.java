package com.jaytest.service;

import com.jaytest.model.ProjectRequest;
import com.jaytest.model.TiRequest;

import java.util.List;

/**
 * 接口
 */
public interface TestService {
    public void insertTiRequest(TiRequest tiRequest);

    public List<ProjectRequest> selProject(ProjectRequest projectRequest);

}
