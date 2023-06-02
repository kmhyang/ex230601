package com.yedam.app.emp.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.app.emp.service.EmpVO;

public interface EmpMapper {
	public EmpVO selectOne(int empId);
	public int selectCount(EmpVO vo); //목록구하는 쿼리와 카운트 쿼리는 매개변수가 같아야 함. --> 페이징 걸때 제대로 할 수 있음.
	public List<EmpVO> selectList(EmpVO vo);
//	public boolean insertEmp(EmpVO vo);
	public int insertEmp(EmpVO vo);
	public int deleteEmp(int empId);
	public int updateEmp(EmpVO vo);
	public List<Map<String, Object>> selectJobs();  //EmpVO 대신 Map으로 사용함.
	public List<Map<String, Object>> selectDept();  //EmpVO 대신 Map으로 사용함.
	
}
