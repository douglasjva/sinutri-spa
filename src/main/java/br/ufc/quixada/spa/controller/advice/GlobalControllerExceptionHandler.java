package br.ufc.quixada.spa.controller.advice;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.HttpRequestMethodNotSupportedException;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
	@ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
	@ResponseBody
	public String unsupportedMethod(Exception e, HttpServletRequest request) {
		logger.error(e.getClass().getName() + ":" + e.getMessage());
		return "Método HTTP inválido para " + request.getRequestURL();
	}
	
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public String handleError(Exception e, HttpServletResponse response) throws Exception {
		
		logger.error(e.getClass().getName() + ":" + e.getMessage());
		
		String message;
		if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
			
			ResponseStatus responseStatus = e.getClass().getAnnotation(ResponseStatus.class);
			String reason = responseStatus.reason();
			HttpStatus value = responseStatus.value();
			
			response.setStatus( value.value() );
			message = (reason == null || reason.isEmpty() || reason.equals(value.name())) ? 
					e.getMessage() : reason;
		
		} else {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			message = "Ocorreu um erro internamente. Por favor, tente novamente em alguns instantes";
		}
		return message;
	}

}
