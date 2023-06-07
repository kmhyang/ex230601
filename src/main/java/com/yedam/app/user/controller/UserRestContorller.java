package com.yedam.app.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.user.service.UserVO;

//@Controller
@RestController //해당 컨트롤러의 모든 메서드는 데이터를 반환.
public class UserRestContorller {
	
	@PostMapping("insertUser")
//	@ResponseBody //데이터(객체)를 반환하는 메서드 @RestContorller에선 ResponseBody 사용X
	public UserVO insertUser(UserVO vo) {
		System.out.println("name : "+ vo.getName());
		System.out.println("age : "+ vo.getAge());
		return vo;
	}
	
	@GetMapping("getHome")
	public String getHome() {
		return "home";
		//페이지 요청X 데이터를 반환하는 경우에만 사용.
		//home controller : 페이지 요청
	}
	
	
	
}
