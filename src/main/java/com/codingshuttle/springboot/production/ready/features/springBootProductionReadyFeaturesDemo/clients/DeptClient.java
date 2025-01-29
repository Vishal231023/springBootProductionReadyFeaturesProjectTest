package com.codingshuttle.springboot.production.ready.features.springBootProductionReadyFeaturesDemo.clients;

import com.codingshuttle.springboot.production.ready.features.springBootProductionReadyFeaturesDemo.entities.DepartmentEntity;

import java.util.List;

public interface DeptClient {

    List<DepartmentEntity> getAllDepts();
    DepartmentEntity getDeptById(Long id);
}
