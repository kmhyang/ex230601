package com.yedam.app.emp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@RestController
public class EmpRestController {
	
	@Autowired
	EmpMapper empMapper;
	
	//전체 조회
	@GetMapping("emps")
	public List<EmpVO> getEmpList(){ //+검색기능@RequestBody EmpVO vo
		EmpVO vo = new EmpVO();
		return empMapper.selectList(vo);
	}
	
	//단건 조회
	@GetMapping("emps/{employeeId}") //데이터 / 경로X
	public EmpVO getEmpInfo(@PathVariable int employeeId) { //@PathVarible : 경로를 받아옴.
		return empMapper.selectOne(employeeId);
	}
	//http://localhost:8081/app/emps/100 : 부메랑 (run as 실행 후)
	
//	public EmpVO getEmpInfo(@PathVariable(name="employeeId" int empId) { //@PathVarible : 경로를 받아옴.
//		return empMapper.selectOne(empId);
	
	//등록
	@PostMapping("emps")
	public EmpVO insertEmpInfo(@RequestBody EmpVO vo) {
		empMapper.insertEmp(vo);
		return vo;
	}
	//http://localhost:8081/app/emps
	
	//수정
	@PutMapping("emps/{employeeId}") // 수정할 대상
	public EmpVO updateEmpInfo(@PathVariable String employeeId, 
								@RequestBody EmpVO vo) { // 넘겨줄 값
		vo.setEmployeeId(employeeId);
		empMapper.updateEmp(vo);
		return vo;
	}
	
	//삭제
//	@DeleteMapping("emps/{employeeId}")
//	public int deleteEmpInfo(@PathVariable int employeeId) {
//		empMapper.deleteEmp(employeeId);
//		return employeeId;
//	}
	//http://localhost:8081/app/emps/212
	
	@DeleteMapping("emps/{employeeId}")
	public Map<String, Object> deleteEmpIfo(@PathVariable int employeeId) {
		boolean success = false;
		int result = empMapper.deleteEmp(employeeId);
		
		if(result > 0) {
			success = true;
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("result", success);
		map.put("employeeId", employeeId);
		return map;
	}
	//http://localhost:8081/app/emps/212
	
	
}

