package com.frame;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

import com.user.User;

public class Logadvice {
	public void printlog() {
		Date d = new Date();
		System.out.println(d + "[����α�] ����Ͻ� ���� ����...");
	}

	public void beforelog(JoinPoint jp) {
		String method = jp.getSignature().getName(); // �Լ� �̸�
		Object[] args = jp.getArgs(); // �Էµ� �Ű�����
		System.out.println(method + ":" + args[0]);
		System.out.println("[before] ���� ����");
	}

	public void afterlog(JoinPoint jp, Object returnobj) {
		System.out.println("[after] ���� ����");
		System.out.println(returnobj);
	}

	public void exlog(JoinPoint jp , Exception ex) {
		Date d = new Date();
		System.out.println(d + "[���ܹ߻�]...");
		System.out.println(ex.getMessage());
	}

	public Object aroundlog(ProceedingJoinPoint pjp) throws Throwable {
		StopWatch sw = new StopWatch();
		sw.start();
		Date d = new Date();
		System.out.println(d + "Before Action ...");
		Object obj = pjp.proceed();
		d = new Date();
		System.out.println(d + "After Action ...");
		sw.stop();
		System.out.println("�޼ҵ� ���� �ð� :" +sw.getTotalTimeMillis()+"(ms)��");
		return obj;
	}

}
