package com.yedam.app.dept.mapper;

import java.util.List;

import com.yedam.app.dept.service.DepVO;

public interface DepMapper {
	//전체조회
	public List<DepVO> selectAllDept();
	
	//단건조회
	public DepVO selectOneDept(DepVO vo);
	
	//등록
	public int insertDeptInfo(DepVO vo);
	
	//수정
	public int updateDeptInfo(DepVO vo);
	
	//삭제
	public int deleteDeptInfo(int deptId);
}
