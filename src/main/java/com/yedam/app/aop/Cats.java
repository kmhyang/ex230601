package com.yedam.app.aop;

import lombok.Data;

@Data
public class Cats {
	private String name;
	private int age;
	private String color;
	
	public void printInfo() {
		System.out.println(this.name + ", " + this.age+", "+this.color);
		//aop-context.xml : component를 여기에 등록하면  필드가 없어져서 xml 파일에서 등록
	}
}
