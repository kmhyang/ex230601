package com.yedam.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@RunWith(SpringJUnit4ClassRunner.class) // spring을 기반으로
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml") // 컨테이너 구성 //db 관련
public class EmpMapperClient {

	@Autowired
	EmpMapper empMapper; // 인터페이스를 상속받은 구현클래스를 주입 받음.
	// 인터페이스 쓰는 이유 : 유지보수. 코드를 수정하지 않고 수정하기 위함.

	// @Test
	public void getEmpInfo() {
		EmpVO findEmp = empMapper.selectOne(100);
		assertEquals(findEmp.getFirstName(), "Steven"); // DB에서 가져온 값비교함.

		// root-context -> sqlsession, mybatis-spring scan)
	}

	//@Test
	public void 전체조회() {
		EmpVO vo = new EmpVO();
		vo.setDepartmentId("50,90");
//		vo.setFirstName("e"); // first_name에 "e"가 포함된 사원 조회
		vo.setOrderColumn("department_id, first_name");
		
		//전체조회
		List<EmpVO> list = empMapper.selectList(vo);
		
		//건수 조회
		int cnt = empMapper.selectCount(vo);
		
		for (EmpVO emp : list) {
			System.out.println(emp);
		}
	}
//		assertEquals(list.get(0).getEmployeeId(), "100"); //DB에서 가져온 값 비교

	// @Test
	public void insert() {
		EmpVO vo = new EmpVO();
		vo.setEmployeeId("6000");
		vo.setEmail("emailleeelleee");
		vo.setLastName("kkk");
		vo.setJobId("IT_PROG");
		vo.setHireDate("23/06/02");

		int result = empMapper.insertEmp(vo);
		assertEquals(result, 1);

//		mapper void로 설정할 경우
//		EmpVO findEmp = empMapper.selectOne(Integer.parseInt(vo.getEmployee_id()));
//		assertEquals(findEmp.getLast_name(), vo.getLast_name()); //DB에서 가져온 값비교함.
	}
	
	//@Test
	public void 등록() {
		EmpVO vo = new EmpVO();
		vo.setLastName("kkk");
		vo.setEmail("emailaaa");
		vo.setJobId("IT_PROG");
		vo.setHireDate("23/06/02");
		empMapper.insertEmp(vo);
		//등록 후에 id를 사용하고자 할 경우 selectKey 이용
		System.out.println("id : "+vo.getEmployeeId());
	}
	
	@Test
	public void selectJobs() {
		List<Map<String, Object>> list = empMapper.selectJobs();
		assertNotNull(list);
	}
}
