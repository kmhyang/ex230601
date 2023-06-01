package com.yedam.app;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@RunWith(SpringJUnit4ClassRunner.class) //spring을 기반으로 
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml") //컨테이너 구성 //db 관련 
public class EmpMapperClient {
	@Autowired
	EmpMapper empMapper;
	
	@Test
	public void getEmpInfo() {
		EmpVO findEmp = empMapper.selectOne(100);
		assertEquals(findEmp.getFirst_name(), "Steven"); //DB에서 가져온 값과 두 개 값을 비교함.
	}
}
