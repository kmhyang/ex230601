package com.yedam.app.dept.service;

import java.util.List;
import java.util.Map;

public interface DepService {
	//전체조회
	public List<DepVO> getAllDept();
	
	//단건조회
	public DepVO getDeptInfo(DepVO vo);
	
	//등록
	public int insertDeptInfo(DepVO vo); 
	
	//수정
	public Map<String, Object> updateDeptList(List<DepVO> vo); 
	
	//삭제
	public int deleteDeptList(List<DepVO> vo);
}
