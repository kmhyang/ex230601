package com.yedam.app.emp.mapper;

import java.util.List;

import com.yedam.app.emp.service.DeptVO;

public interface DeptMapper {
	public List<DeptVO> selectDeptList(DeptVO vo);
	public int selectCount (DeptVO vo);
	public List<DeptVO> selectDeptOne(int deptId);
	public int insertDept(DeptVO vo);
	public int updateDept(DeptVO vo);
	public int deleteDept(int deptId);
	public List<Map<String, Object>> selectEmp();
	public List<Map<String, Object>> selectLoc();
	
	
	
}
