package com.yedam.app.emp.service;

import lombok.Data;

@Data
public class EmpVO {
	String employeeId;
	String firstName;
	String lastName;
	String hireDate;
	String jobId;
	String email;
	String departmentId;
	String orderColumn;
	
	String[] getDeptArr() { //deptArr로 부르면 됨.
		return departmentId.split(",");
	} //체크박스 여러건 삭제할 때 사용 가능
}
//bean 으로 등록하지 않음......
