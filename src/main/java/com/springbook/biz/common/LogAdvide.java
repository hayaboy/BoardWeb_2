package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

//@Service
//@Aspect  // AOP �������� ���� �߿�, �ֽ���Ʈ�� ����Ʈ�ư� �����̽��� ����, ���� @Aspect�� ������ �ֽ���Ʈ ��ü���� �ݵ�� ����Ʈ �ư� �����̽��� �����ϴ� ������ �־�� ��
public class LogAdvide {

//		@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")  // ����Ʈ ��
		public void allPointCut() {
			
		}
	
	
//		@Before("allPointCut()")                   // �����̽�
//		public void beforeLog(JoinPoint jp) {
//			String method=jp.getSignature().getName();
//			Object args []=jp.getArgs();
//			System.out.println("[���� ó��"   +  method + " ()�޼ҵ� args ���� " + args[0].toString());
//			
//		}
		
		
		//@Before("allPointCut()")                   // �����̽�
		public void printLog() {
			System.out.println("[���� �α�] ����Ͻ� ���� ���� �� ����");
		}
}
