package com.yedam.app.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

/*
 *  command
 *  Pojo : 상속 필요 없음 / plain object
 */

@Controller
// =>
// 객체 생성해서 컨테이너에 빈 등록하고 
// 스프링 디스패처서블릿에서 호출할 수 있도록 커맨드 타입으로 만들어줌
// @Component 상속 받음
public class EmpController {
	
	@Autowired EmpMapper empMapper; //필요한 의존 객체의 “타입"에 해당하는 빈을 찾아 주입
	
//	@RequestMapping("empList")
//	public String empList(Model model, EmpVO vo) {
//		System.out.println(vo);
//		model.addAttribute("empList", empMapper.selectList(vo));
//		return "emp/empList";
//	}
	//부메랑 테스트 : http://localhost:8081/app/empList?departmentId=50,90&firstName=e&orderColumn=first_name
	
	@GetMapping("empList")
	public String empList(Model model, @ModelAttribute("emp") EmpVO vo) { //jsp(view)에서 값을 받아서 넘어옴
		System.out.println(vo);
//		model.addAttribute("emp", vo); --> 36L empVO--> emp임 // 다시 페이지를 호출하지 않아도 값을 저장해서 보여줌 -- @ModelAttribute 모델에 담지 않아도 값은 저장됨 
		model.addAttribute("empList", empMapper.selectList(vo));
		return "emp/empList";
	}
	
	//사원 등록 페이지로 이동
	@GetMapping("empInsert")
	public String empInsertForm(Model model) {
		model.addAttribute("jobs", empMapper.selectJobs());
		model.addAttribute("depts", empMapper.selectDept());
		return "emp/empInsert";
	}
	
	//사원 등록 처리
	@PostMapping("empInsert")
	public String empInsert(EmpVO vo) {
		empMapper.insertEmp(vo);
		return "redirect:empList"; //getMapping("empList")로 돌아감.
		
//		return "emp/empList"; //forward
	}
	
	//사원 수정페이지로 이동
	@GetMapping("empUpdate")
	public String empUpdate(Model model, int empId) { //@RequestParam : 생략 가능
		model.addAttribute("emp", empMapper.selectOne(empId));
		model.addAttribute("jobs", empMapper.selectJobs());
		model.addAttribute("depts", empMapper.selectDept());
		return "emp/empUpdate";
	}
	
	//사원 수정 처리
	@PostMapping("empUpdate")
	public String empUpdate(EmpVO vo) {
		empMapper.updateEmp(vo);
		return "redirect:empList";
	}
	
	//사원 삭제 처리
	@GetMapping("empDelete")
	public String empDelete(@RequestParam int empId) { //@RequestParam : 생략 가능
		empMapper.deleteEmp(empId);
		return "redirect:empList";
	}
}
