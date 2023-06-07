package com.yedam.app.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component //bean 등록
public class LogAdvice { //Advice : aspect + pointcut
	//proxy pattern
	
	//포인트컷 : joinpoint(비즈니스 로직과 관련된 메소드) 중에서 Advice(공통코드)가 적용될 메소드 ★★★
	@Pointcut("within(com.yedam.app.aop.*)") //지정된 메소드 밑에 모든 패키지들 //within에서 필터링 걸어줌
	public void allPointCut() {}
	
	//Weaving : 포인트 컷 + Advice + 동작시점
	@Around("allPointCut()") //Around : 앞뒤로 동작 실행 (동작시점)
	public Object logger(ProceedingJoinPoint joinpoint) throws Throwable {
		//Aop가 적용되는 메서드의 이름
		String signatureeStr = joinpoint.getSignature().toString(); //호출되는 메서드에 대한 정보 - 이름을 변수로 담음
		//before
		System.out.println("시작 :"+signatureeStr);
		//공통기능
		System.out.println("핵심 기능 전 실행 - 공통기능 "+System.currentTimeMillis());
		try {
			Object obj = joinpoint.proceed(); //메소드 logger - joinpoint가 실행되는 시점 
			//실행시키는 메소드가 무엇인지 몰라서 최상위 Object로 담아서 반환해줌
			return obj;
		}finally {
			//공통기능
			//after
			System.out.println("핵심 기능 후 실행 - 공통기능 "+System.currentTimeMillis());
		}
	}
}
