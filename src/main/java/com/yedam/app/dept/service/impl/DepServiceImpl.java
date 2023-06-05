package com.yedam.app.dept.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.dept.mapper.DepMapper;
import com.yedam.app.dept.service.DepService;
import com.yedam.app.dept.service.DepVO;

//★★★★★
@Service //Impl로 끝나는 모든 class는 Spring 어노테이션 등록 필수
public class DepServiceImpl implements DepService{

	@Autowired
	DepMapper depMapper;
	
	@Override
	public List<DepVO> getAllDept() {
		// TODO Auto-generated method stub
		return depMapper.selectAllDept();
	}

	@Override
	public DepVO getDeptInfo(DepVO vo) {
		// TODO Auto-generated method stub
		return depMapper.selectOneDept(vo);
	}

	@Override
	public int insertDeptInfo(DepVO vo) {
		int result = depMapper.insertDeptInfo(vo);
		System.out.println("id : " +vo.getDepartmentId());
		return result;
	}

	@Override
	public Map<String, Object> updateDeptList(List<DepVO> vo) {
		Boolean result = false;
		List<Integer> successList = new ArrayList<>();
		int count = 0;

		//수정 시 받아온 값은 for문을 돌려서 확인
		for(DepVO deptInfo : vo) {
			int res = depMapper.updateDeptInfo(deptInfo);
			if(res > 0) {
				//업데이트 성공
				count += 1;
				successList.add(deptInfo.getDepartmentId());
			}
		}
		
		if(count > 0) {
			result = true;
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("result", result);
		map.put("success", count);
		map.put("depList", successList);
		
		return map;
	}

	@Override
	public int deleteDeptList(List<DepVO> vo) {
		int count = 0;
		for(DepVO deptInfo : vo) {
			count += depMapper.deleteDeptInfo(deptInfo.getDepartmentId());
		}
		return count;
	}

}
