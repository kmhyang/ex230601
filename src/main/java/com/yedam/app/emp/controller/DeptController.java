package com.yedam.app.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yedam.app.emp.mapper.DeptMapper;
import com.yedam.app.emp.service.DeptVO;

@Controller
public class DeptController {
	
	@Autowired DeptMapper deptMapper;
	
	@GetMapping("deptList")
	public String deptList(Model model, @ModelAttribute("dept") DeptVO vo) {
		model.addAttribute("deptList",deptMapper.selectDeptList(vo));
		return "dept/deptList";
	}
	
	//부서 등록 페이지 이동
	@GetMapping("detpInsert")
	public String deptInsertForm(Model model) {
		model.addAttribute("managers", deptMapper.selectEmp());
		model.addAttribute("locations", deptMapper.selectLoc());
		return "dept/deptInsert";
	}
	
	@PostMapping("detpInsert")
	public String deptInsert(DeptVO vo) {
		deptMapper.insertDept(vo);
		return "redirect:deptList";
	}
	
	//부서 수정 페이지
	@GetMapping("detpUpdate")
	public String deptUpdate(Model model, int deptId) {
		model.addAttribute("dept", deptMapper.selectDeptOne(deptId));
		model.addAttribute("managers", deptMapper.selectEmp());
		model.addAttribute("locations", deptMapper.selectLoc());
		return "dept/deptUpdate";
	}

	//부서 수정 처리detpUpdate
	@PostMapping("empUpdate")
	public String deptUpdate(DeptVO vo) {
		deptMapper.updateDept(vo);
		return "redirect:deptList";
	}
	
	@GetMapping("deptDelete")
	public String empDelete(@RequestParam int deptId) { 
		deptMapper.deleteDept(deptId);
		return "redirect:deptList";
	}

}
