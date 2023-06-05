package com.yedam.app.dept.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.yedam.app.dept.service.DepService;
import com.yedam.app.dept.service.DepVO;
import com.yedam.app.dept.service.DeptListVO;
import com.yedam.app.emp.mapper.EmpMapper;

@Controller
public class DepController {
	@Autowired
	DepService depService;
	
	@Autowired
	EmpMapper empMapper;
	
	//경로 <-> 기능 (View-페이지)
	//경로 + Method-> Unique
	
	//조회 ( 데이터, 페이지 ) -> GET
	//등록, 수정, 삭제 -> POST
	
	//전체조회 - 페이지
//	@RequestMapping(value = "/depList")
	@GetMapping("depList")
//	public String getDeptAllList(Model model) {
	public String getDeptAllList(@RequestParam(required=false) String msg,Model model, HttpServletRequest request) {
		model.addAttribute("depList",depService.getAllDept());
		
		System.out.println("redirect : "+msg);
		
		Map<String,?> flashMap = RequestContextUtils.getInputFlashMap(request); //? : Object
		if(flashMap != null) {
			System.out.println("department_id : "+flashMap.get("departmentId"));
		}
		return "dep/list";
	}
	
	//단건조회 - 페이지
	@GetMapping("deptInfo")
	public String getDeptInfo(DepVO vo, Model model) {
		DepVO findDept = depService.getDeptInfo(vo); //단건조회 받아온 값
		model.addAttribute("deptInfo", findDept);
		return "dep/info";
	}
	
	//등록 - 페이지 : GET
	@GetMapping("depInsert")
	public String depInsertForm() {
		return "dep/insert";
	}
	
	//등록 - 기능 : POST
	@PostMapping("depInsert")
	public String depInsert(DepVO vo, RedirectAttributes rtt) { //model : redirect 하면 변경된 정보가 client를 만나면 사라짐
		depService.insertDeptInfo(vo);
		System.out.println("vo : "+vo);
		rtt.addFlashAttribute("departmentId", vo.getDepartmentId()); //model에 저장된 정보를 일시적으로 session에 저장.?????
		rtt.addAttribute("msg","test"); //?msg=test
		return "redirect:depList";
//		return "redirect:deplist?departmentId="+deptVO.getDepartmentId()"; //보안X 경로에 다 노출됨??
	}
	
	
	//삭제 - 기능 : POST
	@PostMapping("depDelete")
	public String depDelete(DeptListVO list) {
		int result = depService.deleteDeptList(list.getDepList());
		return "redirect:depList?msg="+result;
	}
	//json 형태가 아닌 데이터 값을 넘길때
	//text -> key - value 형태로 넘어감.
	//DeptListVO로 list 배열로 해당 값을 넘겨줌.
	
	
//	@RequestBody : JSON 포맷을 사용하는 경우 
//					-> content-type : 'application/json' 
//	=>  fetch('',body:{})
//	Jackson 라이브러리 : json?
	//수정 - 기능 : POST
	@PostMapping("depUpdate") 
	@ResponseBody //비동기방식 처리
	public Map<String, Object> depUpdate(@RequestBody List<DepVO> vo, RedirectAttributes rtt) {
		return depService.updateDeptList(vo);
		
		//동기방식 처리
//		public String depUpdate(@RequestBody List<DepVO> vo, RedirectAttributes rtt) {
//		Map<String, Object> map = depService.updateDeptList(vo);
//		rtt.addFlashAttribute("updateRes", map);
//		return "redirect:deptInfo?departmentId="+vo.get(0).getDepartmentId(); //배열에 담겨서 받아온 배열 get(0)번째의 getDepartmentId
//		return "redirect:depList";
	}
}
