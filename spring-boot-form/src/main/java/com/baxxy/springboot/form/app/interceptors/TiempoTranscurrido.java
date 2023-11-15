package com.baxxy.springboot.form.app.interceptors;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component("tiempoTranscurridoInterceptor")
public class TiempoTranscurrido implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(TiempoTranscurrido.class);
	
	@Value("config.horario.apertura")
	private Integer apertura ;
	
	@Value("config.horario.cierre")
	private Integer cierre;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if (request.getMethod().equalsIgnoreCase("post")) {
			return true;
		}
		
		if (handler instanceof HandlerMethod) {
			HandlerMethod metodo = (HandlerMethod) handler;
			logger.info("esto es un metodo controlador "+metodo.getMethod().getName());
			
			
		}
		
		logger.info("Tiempo transcurrido: PreHandler() entrando.....");
		logger.info("Se a interceptado un handler con nombre ....."+ handler);
		long tiempoInicio = System.currentTimeMillis();
		request.setAttribute("tiempoInicio", tiempoInicio);
		
		Random random = new Random();
		Integer demora = random.nextInt(500);
		Thread.sleep(demora);
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		if (!request.getMethod().equalsIgnoreCase("post")) {
			
		
			long tiempoFin = System.currentTimeMillis();
			long tiempoInicio = (Long) request.getAttribute("tiempoInicio");
			
			long tiempoTranscurrido = tiempoFin - tiempoInicio  ;
					
			
			if(handler instanceof HandlerMethod && modelAndView !=null) {
				modelAndView.addObject("tt", tiempoTranscurrido);
				
			}
				
			logger.info("Tiempo transcurrido fue de : " + tiempoTranscurrido + " ms");
			logger.info("Tiempo transcurrido: PostHandler() Seliendo.....");
		}
	}

	
	
}
