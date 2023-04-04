package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

//@Service
//@Aspect  // AOP 설정에서 가장 중요, 애스펙트는 포인트컷과 어드바이스의 결합, 따라서 @Aspect가 설정된 애스펙트 객체에는 반드시 포인트 컷과 어드바이스를 결합하는 설정이 있어야 함
public class LogAdvide {

//		@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")  // 포인트 컷
		public void allPointCut() {
			
		}
	
	
//		@Before("allPointCut()")                   // 어드바이스
//		public void beforeLog(JoinPoint jp) {
//			String method=jp.getSignature().getName();
//			Object args []=jp.getArgs();
//			System.out.println("[사전 처리"   +  method + " ()메소드 args 정보 " + args[0].toString());
//			
//		}
		
		
		//@Before("allPointCut()")                   // 어드바이스
		public void printLog() {
			System.out.println("[공통 로그] 비즈니스 로직 수행 전 동작");
		}
}
