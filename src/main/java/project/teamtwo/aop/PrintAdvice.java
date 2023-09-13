package project.teamtwo.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class PrintAdvice {
	
	
	@Around("execution( * project.teamtwo.controller.*.aopSession*(..))")	
	public Object printMVC(ProceedingJoinPoint jp) throws Throwable{	//�帧�� ������ ��ħ(�״�� �θ� �����ִ� ����)
		//���� Ȯ��
		RequestAttributes ra = RequestContextHolder.currentRequestAttributes();
		ServletRequestAttributes sa = (ServletRequestAttributes)ra;
		HttpServletRequest request = sa.getRequest();
		HttpSession session = request.getSession();
		Object obj = "/member/loginForm";
		if(session.getAttribute("memId") != null) {
			//�α��ε�!!!
			System.out.println("dd");
			obj = jp.proceed();  //�ż��� ������ �����Ŵ	(void �϶� ���°͸�(return �� ���))
		}		
		System.out.println("üũ");
		return obj;
	}



//	@Around("execution( * test.spring.service.AopService*.*(..))")		
//	public Object printAround(ProceedingJoinPoint jp) throws Throwable{	//�帧�� ������ ��ħ(�״�� �θ� �����ִ� ����)
//		System.out.println("aop Around before");
//		Object obj = jp.proceed();		//�ż��� ������ �����Ŵ	(void �϶� ���°͸�(return �� ���))
//		System.out.println("aop Around after");
//		return obj;
//	}
}