package com.codingshuttle.springboot.production.ready.features.springBootProductionReadyFeaturesDemo;

import com.codingshuttle.springboot.production.ready.features.springBootProductionReadyFeaturesDemo.clients.impl.DeptClientImpl;
import com.codingshuttle.springboot.production.ready.features.springBootProductionReadyFeaturesDemo.entities.DepartmentEntity;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.class)
class SpringBootProductionReadyFeaturesDemoApplicationTests {

	@Autowired
	private DeptClientImpl deptClient;

	@Test
	void contextLoads() {
	}

	@Test
	@Order(2)
	void getAllDepts(){
		List<DepartmentEntity> deptList = deptClient.getAllDepts();
		System.out.println(deptList);

	}

	@Test
	@Order(1)
	void getDeptById(){
		DepartmentEntity departmentEntity = deptClient.getDeptById(1L);
		System.out.println(departmentEntity);

	}

}
