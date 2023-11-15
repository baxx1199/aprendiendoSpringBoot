package com.baxxy.springboot.horario.app.interceptors;

import java.util.Calendar;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("HorarioTranscurrido")
public class HorarioInterceptor implements HandlerInterceptor{
	
	//private static final Logger logger = LoggerFactory.getLogger(HorarioInterceptor.class);
	

	@Value("${config.horario.apertura}")
	private Integer apertura ;
	
	@Value("${config.horario.cierre}")
	private Integer cierre;
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Calendar calendar = Calendar.getInstance();
		Integer hora = calendar.get(Calendar.HOUR_OF_DAY);
		
		if(hora >= apertura && hora < cierre) {
			StringBuilder message = new StringBuilder("Bienvenido a PruebaMatic ");
			message.append(", Horario de atencion: ");
			message.append(" Apertura: "+apertura+  ":00 hrs");
			message.append(" Cierre:"+ cierre +":00 hrs ");
			message.append("Gracias por su visita");
			
			request.setAttribute("mensaje", message.toString());
			
			return true;
			
		}
		response.sendRedirect(request.getContextPath().concat("/cerrado"));
		System.out.println("cerrado");
		return false;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		String mensaje =(String) request.getAttribute("mensaje");
		System.out.println("cerrado");
		
		if(modelAndView !=  null && handler instanceof HandlerMethod) {
			
			modelAndView.addObject("horario",mensaje);
		}
		
	}
}
