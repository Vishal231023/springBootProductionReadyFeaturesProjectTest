package com.codingshuttle.springboot.production.ready.features.springBootProductionReadyFeaturesDemo.clients.impl;

import com.codingshuttle.springboot.production.ready.features.springBootProductionReadyFeaturesDemo.clients.DeptClient;
import com.codingshuttle.springboot.production.ready.features.springBootProductionReadyFeaturesDemo.entities.DepartmentEntity;
import com.codingshuttle.springboot.production.ready.features.springBootProductionReadyFeaturesDemo.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
@Service
public class DeptClientImpl implements DeptClient {
    private final RestClient restClient;
    Logger log = LoggerFactory.getLogger(DeptClientImpl.class);

    public DeptClientImpl(RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public List<DepartmentEntity> getAllDepts() {
        log.info("get all depts");

        try {
            List<DepartmentEntity> departmentEntityList =   restClient.get()
                    .uri("departments")
                    .retrieve()
                    .body(new ParameterizedTypeReference<List<DepartmentEntity>>() {
                    });
            log.debug("dept succesfully retrieved");
            return departmentEntityList;

        }
        catch (Exception e){
            log.error("exception occured in getAllDepts",e);
            throw  new RuntimeException(e);
        }

    }

    @Override
    public DepartmentEntity getDeptById(Long id) {
        try {
            DepartmentEntity departmentEntity =   restClient.get()
                    .uri("departments/{id}",id)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError,(req,resp) -> {
                        System.out.println(new String(resp.getBody().readAllBytes()));
                        throw new ResourceNotFoundException("could not get the dept");
                    })
                    .body(new ParameterizedTypeReference<DepartmentEntity>() {
                    });
            return departmentEntity;
        }
        catch (Exception e){
            throw  new RuntimeException(e);
        }

    }
}
