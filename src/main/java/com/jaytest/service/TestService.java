package com.jaytest.service;

import com.jaytest.model.ProjectRequest;

import java.util.List;

/**
 * 接口
 */
public interface TestService {
    void insertTiRequest(List<ProjectRequest> list);

    List<ProjectRequest> selProject(ProjectRequest projectRequest);

    List<ProjectRequest> selpidProject(ProjectRequest projectRequest);

}
